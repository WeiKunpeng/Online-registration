package Bean;
import java.io.UnsupportedEncodingException;
import java.sql.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
public class TestBean {
	String  number="";
	String  subject="";
	String  date="";
	String  time="";
	String  address="";
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String insert(TestBean test)
	{
		DBConnectBean connect = new DBConnectBean();
		Connection conn = connect.getConnect();
		String sql = "INSERT INTO test VALUES(?,?,?,?,?)";
		try {//设置参数
		PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,test.getNumber());
			ps.setString(2,test.getSubject());
			ps.setString(3,test.getDate());
			ps.setString(4,test.getTime());
			ps.setString(5,test.getAddress());
				
			ps.executeUpdate();
			System.out.println("数据成功插入到数据库中！");
			return "true";
		} catch (SQLException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
			return "false";
		}	
	}
	
	
	public String message(String num) 
	{
		try {
			DBConnectBean connect = new DBConnectBean();
			Connection conn = connect.getConnect();
			Statement st= conn.createStatement();
			ResultSet rs=null;
			//String num=test.getNumber();

			String sql="SELECT * FROM test WHERE number ='"+num+"'";
			System.out.println(sql);
	        rs = st.executeQuery(sql);//指针
	        while(rs.next())
	        {
	        	number=rs.getString(1);
	        	subject=rs.getString(2);
	        	date=rs.getString(3);
	        	time=rs.getString(4);
	        	address=rs.getString(5);
	        }
	        return "true";
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "false";
		}
	}
	
	public ArrayList showTest() {
		ArrayList alter = new ArrayList();
		try {
			DBConnectBean connect = new DBConnectBean();
			Connection conn = connect.getConnect();
		    ResultSet rs=null;
		
	    String sql = "select * from test";
	    PreparedStatement ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
			while (rs.next()) {
				TestBean test = new TestBean();
				test.setNumber(rs.getString(1));
				test.setSubject(rs.getString(2));
				test.setDate(rs.getString(3));
				test.setTime(rs.getString(4));
				test.setAddress(rs.getString(5));
				alter.add(test);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return alter;
	}
	
	public TestBean showTest(String number) {
		TestBean test = new TestBean();
			try {
				DBConnectBean connect = new DBConnectBean();
				Connection conn = connect.getConnect();
				ResultSet rs=null;
				String sql = "select * from test where number = '"+ number +"'";
				PreparedStatement ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				while (rs.next()) {
					test.setNumber(rs.getString(1));
					test.setSubject(rs.getString(2));
					test.setDate(rs.getString(3));
					test.setTime(rs.getString(4));
					test.setAddress(rs.getString(5));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return test;
	}
	
	public void updateTest(HttpServletRequest request,String tnumber) throws UnsupportedEncodingException {
		DBConnectBean connect = new DBConnectBean();
		Connection conn = connect.getConnect();
		//查看sql   
		String number=request.getParameter("number");
		String subject=new String(request.getParameter("subject").getBytes("ISO8859-1"),"GB2312");
		String date=new String(request.getParameter("date").getBytes("ISO8859-1"),"GB2312");
		String time=new String(request.getParameter("time").getBytes("ISO8859-1"),"GB2312");
		String address=new String(request.getParameter("address").getBytes("ISO8859-1"),"GB2312");
		System.out.print("update test set number='"+number+"',"+"subject = '" +subject + "',"+ "date = '" +date+ "'," + "time = '" + time+ "',"+ "address = '" +address+"' where number = '"+ tnumber + "'");

		String sql = "update test set number='"+number+"',"+"subject = '" + subject + "',"+ "date = '" + date + "',"+ "time = '" +time+ "',"+ "address = '" +address+"' where number = '"+ tnumber + "'";

		try {
			Statement st = conn.createStatement();
			st.executeUpdate(sql);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
}
