package core;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionExample {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // get class
        Class<?> aClass = Class.forName("core.ReflectionExample$Example");

        // get constructors
        Constructor<?>[] constructors = aClass.getConstructors();

        Field[] fields = aClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("Field: " + field);
        }

        Method[] declaredMethods = aClass.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println("Method: " + method);
        }

        Field exampleField = aClass.getDeclaredField("exampleField");
        exampleField.setAccessible(true);
        Object exampleInstance = aClass.getDeclaredConstructor().newInstance();
        exampleField.set(exampleInstance, "New val");
        System.out.println("Updated Field Value: " + exampleField.get(exampleInstance));
    }
    public static class Example {
        private String exampleField = "AAA";
        private int exampleInt;

        public String getExampleField() {
            return exampleField;
        }

        public void setExampleField(String exampleField) {
            this.exampleField = exampleField;
        }
    }
}
