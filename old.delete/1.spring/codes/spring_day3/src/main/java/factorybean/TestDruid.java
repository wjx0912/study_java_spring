package factorybean;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;

import java.sql.SQLException;

public class TestDruid {
    public static void main(String[] args) throws SQLException {

        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://192.168.0.192:3306/2001");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("tmp123456");

        DruidPooledConnection connection = druidDataSource.getConnection();
        System.out.println(connection);

    }
}
