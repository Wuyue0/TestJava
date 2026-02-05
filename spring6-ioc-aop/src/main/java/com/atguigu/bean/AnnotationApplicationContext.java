package com.atguigu.bean;

import com.atguigu.anno.Bean;
import com.atguigu.anno.Di;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AnnotationApplicationContext implements  ApplicationContext{
    // 创建map集合放bean对象
    private Map<Class, Object> beanFactory = new HashMap<>();
    // 当前传递的包路径的前边的基础路径
    private String rootPath;

    // 构造函数进行初始化
    public AnnotationApplicationContext(String basePackage) throws Exception {
        // com.atguigu 变成com/atguigu 必须使用 / 作为分隔符
        // 传递给Thread.currentThread().getContextClassLoader().getResource
        // 这里传递/或者\\都可以底层统一返回/格式不管是windows还是mac
        String packagePath = basePackage.replace('.', '/');
        // 获取包绝对路径 不同操作系统返回的格式不同 mac没事
        //  file:/C:/Users/11040/IdeaProjects/TestJava/spring6-ioc-aop/target/classes/com/atguigu
        // mac 下 /xxx/xxx
        // 主要是windows下返回的路径多带一个\ (指的是 c盘前边的/)但是new File 不带 底层会根据packagePath自动选择
        URL url = Thread.currentThread().getContextClassLoader().getResource(packagePath);
        // URL -> Path（跨平台）url转码 可以不写 只是为了乱码使用的
        Path rootDir = Paths.get(url.toURI());
        String filePath = rootDir.toString(); // 保存完整的路径给file对象
        System.out.println(filePath);
        // 每次改变rootdir 除去 传递的包之外的路径
        for (int i = 0; i < basePackage.split("\\.").length; i++) {
            rootDir = rootDir.getParent();
        }
        // String filePath = URLDecoder.decode(url.getPath(), "utf-8");
        // filePath.substring(0, filePath.length() - packagePath.length()); 废弃兼容性问题

        rootPath = rootDir.toString();

        // 包扫描
        loadBean(new File(filePath));

        // 属性注入
        loadDi();

    }

    //属性注入
    private void loadDi() throws IllegalAccessException {
        // 1.根据beanFactory的map结合里边来拿对象 进入注入
        // 遍历对象
        Set<Map.Entry<Class, Object>> entries = beanFactory.entrySet();
        for (Map.Entry<Class, Object> entry: entries){
            // 获取每个对象value实例化的对象
            Object obj = entry.getValue();
            // 获取实例话对象对应的类对象class
            Class<?> clazz = obj.getClass();
            // 获取类对象对应的每个属性
            Field[] declaredFields = clazz.getDeclaredFields();
            // 遍历每个属性
            for (Field field:declaredFields){
                // 获取属性上边di注解 存在就有不存在就没有
                Di annotation = field.getAnnotation(Di.class);
                if(annotation != null){
                    field.setAccessible(true);
                    // 如果有di注解的话 把对象进行依赖注入 根据类型找到对象
                    field.set(obj, beanFactory.get(field.getType()));
                }

            }

        }


        // 获取对象value 每个对象的属性都获取到

        //
    }

    // 核心步骤 根据注解实例化放到map对象中
    private void loadBean(File file) throws Exception {
        // 是否是目录还是文件夹
        if (file.isDirectory()){
            // 获取文件里面的所有内容
            File[] childrenFiles = file.listFiles();
            if(childrenFiles == null || childrenFiles.length == 0){
                return;
            }
            for (File child : childrenFiles) {
                loadBean(child);  // 递归操作 为了获取文件而已
            }
        }else{
            // 是文件的话
            // 得到包路径+类名称部分 rootDir.length()
            String pathWithClass = file.getAbsolutePath().substring(rootPath.length()+1);
            // 当前的路径包含class 也就是class文件
            if(pathWithClass.contains(".class")){
                // 把.class去掉 并且把/变成.
                String allName = pathWithClass.replace(File.separatorChar, '.').replaceAll("\\.class$", "");
                //获取class对象
                Class clazz = Class.forName(allName);
                // 判断类上边是否有注解@bean
                if(!clazz.isInterface()){
                        // 判断类上边是否有注解@bean 如果有的话就对当前类进行实例话
                        Annotation annotation = clazz.getAnnotation(Bean.class);
                        if(annotation != null){
                            //实例化
                            Object instance = clazz.getDeclaredConstructor().newInstance();
                            // 把实例化放进map对象
                            // 当前类有接口 就把接口class作为key 否则就让自己的class作为key
                            if(clazz.getInterfaces().length > 0){
                                beanFactory.put(clazz.getInterfaces()[0], instance);
                            }else{
                                beanFactory.put(clazz, instance);
                            }
                        }
                    }
            }
        }
    }

    // 返回对象
    @Override
    public Object getBean(Class clazz) {
        return beanFactory.get(clazz);
    }

    public static void main(String[] args) throws Exception {
//        AnnotationApplicationContext("com.atguigu");
//        AnnotationApplicationContext annotationApplicationContext = new AnnotationApplicationContext("com.atguigu");
//        UserService userService = (UserService) annotationApplicationContext.getBean(UserService.class);
//        userService.show();
    }

}
