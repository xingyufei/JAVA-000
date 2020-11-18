import java.sql.*;

/**
 * ClassName: DBDemo1
 * Description: 使用 JDBC 原生接口，实现数据库的增删改查操作
 * Author: xyf
 * Date: 2020-11-18 21:23
 * Version: 1.0
 **/
public class DBDemo1
{
    public static void main(String[] args)
    {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try
        {
            //1 加载驱动
            Class.forName("com.mysql.jdbc.Driver");

            //2 获取连接
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/test", "root", "1111");

            //3 创建statment对象
            statement = connection.createStatement();

            //4 执行sql，获取结果集resultSet
            resultSet = statement.executeQuery("select * from user");

            //5 遍历结果
            //resultSet.next():移动指针，如果指针的位置有值则返回true否则返回false
            while (resultSet.next())
            {//遍历行
                // 通过结果集resultSet获取响应的数据
                System.out.println("id:" + resultSet.getInt("id"));
                System.out.println("name:" + resultSet.getString("name"));
            }

            //更新
            int c = statement.executeUpdate("update user set sex='男' where id=2");
            //c 影响行数
            if (c > 0)
            {
                System.out.println("更新成功");
            }


        } catch (SQLException e)
        {
            e.printStackTrace();
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        } finally
        {
            try
            {
                resultSet.close();
            } catch (SQLException e)
            {
                e.printStackTrace();
            }

            //6 关闭statment
            try
            {
                statement.close();
            } catch (SQLException e)
            {
                e.printStackTrace();
            }

            //7 关闭连接
            try
            {
                connection.close();
            } catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }
}
