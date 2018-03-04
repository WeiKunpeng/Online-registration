package Bean;
import java.sql.*;
public class DBConnectBean {   //与数据库进行连接
	Connection Connect=null;
	public Connection getConnect()
	{
		try
		{	
			String url="jdbc:postgresql://127.0.0.1:5439/postgres";
			String user="postgres";
			String password = "";
			Class.forName("org.postgresql.Driver");
			Connect = DriverManager.getConnection(url,user,password);
			System.out.println("数据库连接成功!");
		} catch (ClassNotFoundException e) {
			System.out.println("数据库连接失败！");
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("数据库连接失败！");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Connect;
	}

}
