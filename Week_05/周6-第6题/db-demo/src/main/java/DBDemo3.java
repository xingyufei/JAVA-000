import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * ClassName: DBDemo3
 * Description:
 * Author: xyf
 * Date: 2020-11-18 21:44
 * Version: 1.0
 **/
public class DBDemo3
{
    public static final String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/test";
    public static final String jdbcUsername = "root";
    public static final String jdbcPassword = "123456";


    public static void main(String[] args) throws Exception
    {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(jdbcUrl);
        hikariConfig.setUsername(jdbcUsername);
        hikariConfig.setPassword(jdbcPassword);
        hikariConfig.setMaximumPoolSize(10);
        hikariConfig.setMaxLifetime(1800000);
        hikariConfig.setIdleTimeout(600000);
        HikariDataSource ds = new HikariDataSource(hikariConfig);
        Connection connection = ds.getConnection();

        // select
        String query = "SELECT * FROM user";
        Statement queryStatement = connection.createStatement();
        ResultSet resultSet = queryStatement.executeQuery(query);
        while (resultSet.next())
        {
            String id = resultSet.getString("id");
            String name = resultSet.getString("name");
            System.out.println("id:" + id + ", name:" + name);
        }
        resultSet.close();
    }
}
