package classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * ClassName: HelloClassLoader
 * Description:
 * Author: xyf
 * Date: 2020-11-04 21:26
 * Version: 1.0
 **/
public class HelloClassLoader extends ClassLoader
{
    private String filePath;

    public HelloClassLoader(String filePath)
    {
        this.filePath = filePath;
    }

    /**
     * 重写findClass方法
     *
     * @param name 是我们这个类的全路径
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String name)
    {
        Class clazz = null;
        // 获取该class文件字节码数组
        byte[] classData = getData(this.filePath);
        if (classData != null)
        {
            // 将class的字节码数组转换成Class类的实例
            clazz = super.defineClass(name, classData, 0, classData.length);
        }
        return clazz;
    }

    /**
     * 读取指定路径下的class
     *
     * @return
     */
    private byte[] getData(String filePath)
    {
        File file = new File(filePath);
        if (file.exists())
        {
            FileInputStream in = null;
            ByteArrayOutputStream out = null;
            try
            {
                in = new FileInputStream(file);
                out = new ByteArrayOutputStream();

                byte[] buffer = new byte[1024];
                int size = 0;
                while ((size = in.read(buffer)) != -1)
                {
                    out.write(buffer, 0, size);
                }
            } catch (IOException e)
            {
                e.printStackTrace();
            } finally
            {
                try
                {
                    in.close();
                } catch (IOException e)
                {

                    e.printStackTrace();
                }
            }
            return convertBytes(out.toByteArray());
        }
        else
        {
            return null;
        }
    }

    /**
     * byte转换
     *
     * @param byteData
     * @return
     */
    private byte[] convertBytes(byte[] byteData)
    {
        if (byteData == null)
        {
            return null;
        }
        byte[] byteRes = new byte[byteData.length];
        for (int i = 0; i < byteData.length; i++)
        {
            byteRes[i] = (byte) (255 - byteData[i]);
        }
        return byteRes;
    }
}