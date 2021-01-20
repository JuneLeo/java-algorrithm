package com.algorithm.sample.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnotationTest {
    public static void main(String[] args) {
        //设置生成 Proxy类
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        try {
            Method method = AnnotationTest.class.getDeclaredMethod("a");
            MockDebug annotation = method.getAnnotation(MockDebug.class);
            Class<? extends Annotation> aClass = annotation.annotationType();
            System.out.println(annotation.value());
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    @MockDebug(value = "a")
    public void a() {

    }
}
