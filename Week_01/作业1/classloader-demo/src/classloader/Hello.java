package classloader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * ClassName: Hello
 * Description:
 * Author: xyf
 * Date: 2020-11-04 21:25
 * Version: 1.0
 **/
public class Hello
{
    public void hello()
    {
        System.out.println("Hello, classLoader!");
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException
    {
        String filePath = Hello.class.getResource("/").getPath();

        HelloClassLoader helloClassLoader = new HelloClassLoader(filePath + "/Hello.xlass");

        String className = "Hello";

        Class<?> helloClazz = helloClassLoader.findClass(className);

        Object object = helloClazz.newInstance();

        Method method = helloClazz.getDeclaredMethod("hello", new Class[0]);

        method.invoke(object, null);
    }
}
