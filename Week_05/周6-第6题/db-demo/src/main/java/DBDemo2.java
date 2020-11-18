import java.sql.*;

/**
 * ClassName: DBDemo3
 * Description:
 * Author: xyf
 * Date: 2020-11-18 21:44
 * Version: 1.0
 **/
public class DBDemo2
{
    public static void main(String[] args)
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try
        {
            //1 加载驱动
            Class.forName("com.mysql.jdbc.Driver");

            //2 获取连接
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/test", "root", "1111");

            //设置事务非自动提交（默认是自动提交）
            //开启事务
            connection.setAutoCommit(false);

            //3 创建statment对象
            preparedStatement = connection
                    .prepareStatement("select * from user where id=? for update");

            preparedStatement.setInt(1, 5);

            //4 执行sql
            resultSet = preparedStatement.executeQuery();

            //5 遍历结果
            //resultSet.next():移动指针，如果指针的位置有值则返回true否则返回false
            while (resultSet.next())
            {//遍历行
                System.out.println("id:" + resultSet.getInt("id"));
                System.out.println("name:" + resultSet.getString("name"));
            }

            //更新
            //参数使用占位符?
            //preparedStatement好处：sql可以预编译，重复利用。提高应用执行速度
            preparedStatement = connection
                    .prepareStatement("update user set sex=? where id=?");
            preparedStatement.setString(1, "man1");
            preparedStatement.setInt(2, 5);
            int c = preparedStatement.executeUpdate();
            //c 影响行数
            if (c > 0)
            {
                System.out.println("第一个sql更新成功");
            }

            //更新
            //参数使用占位符?
            //preparedStatement好处：sql可以预编译，重复利用。提高应用执行速度
            preparedStatement.setString(1, "man2");
            preparedStatement.setInt(2, 6);
            c = preparedStatement.executeUpdate();
            //c 影响行数
            if (c > 0)
            {
                System.out.println("第二个sql更新成功");
            }

            // 如果没有异常，则直接提交事务
            connection.commit();//提交事务

        } catch (SQLException e)
        {
            try
            {
                // 如果上面的代码有异常，则进入catch块中回滚事务
                connection.rollback();//回滚事务
            } catch (SQLException e1)
            {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } catch (ClassNotFoundException e)
        {
            try
            {
                connection.rollback();//回滚事务
            } catch (SQLException e1)
            {
                e1.printStackTrace();
            }
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
                //statement.close();
                preparedStatement.close();
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
