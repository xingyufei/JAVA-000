import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 测试类
 *
 * Xingyufei
 *
 * 20021018
 */
public class Main {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        String filePath = Main.class.getResource("/").getPath();

        HelloClassLoader helloClassLoader = new HelloClassLoader(filePath + "/Hello.xlass");

        String className = "Hello";

        Class<?> helloClazz = helloClassLoader.findClass(className);

        Object object = helloClazz.newInstance();

        Method method = helloClazz.getDeclaredMethod("hello", new Class[0]);

        method.invoke(object, null);
    }

}