package Bean;
import java.io.UnsupportedEncodingException;
import java.sql.*;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
public class UserLoginBean {
	String id="";
	String name="";
	String password="";
	String sex="";

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public String insert(UserLoginBean user)
	{
	//	PreparedStatement ps=null;
		//try {
		DBConnectBean connect = new DBConnectBean();
		Connection conn = connect.getConnect();
		String sql = "INSERT INTO student VALUES(?,?,?,?)";
		try {//设置参数
		PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,user.getId());
			ps.setString(2,user.getName());
			ps.setString(3,user.getPassword());
			ps.setString(4,user.getSex());
				
			ps.executeUpdate();
			System.out.println("数据成功插入到数据库中！");
			return "true";
		} catch (SQLException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
			return "false";
		}	
	}
	public String select (UserLoginBean user) 
	{		
		try {
			DBConnectBean connect = new DBConnectBean();
			Connection conn = connect.getConnect();
			Statement st= conn.createStatement();
			ResultSet rs=null;
			String id=user.getId();
			String pass=user.getPassword();
			String sql="SELECT * FROM student WHERE id ='"+id+"'";
	        rs = st.executeQuery(sql);//指针
	        while(rs.next())
	        {
	        	if(id.equals(rs.getString(1))&&pass.equals((rs.getString(3))))
	        	{
	        		return "true";
	        	}
	        	else
	        	{
	        		return "false";
	        	}
	        }
	        return "false";
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "false";
		}
	}
	
	public ArrayList showStudent() {
		ArrayList alter = new ArrayList();
		try {
			DBConnectBean connect = new DBConnectBean();
			Connection conn = connect.getConnect();
		    ResultSet rs=null;
		
	    String sql = "select * from student";
	    PreparedStatement ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
			while (rs.next()) {
				UserLoginBean stu = new UserLoginBean();
				stu.setId(rs.getString(1));
				stu.setName(rs.getString(2));
				stu.setSex(rs.getString(4));
				alter.add(stu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return alter;
	}
	
	public UserLoginBean showStudent(String id) {
		UserLoginBean stu = new UserLoginBean();
			try {
				DBConnectBean connect = new DBConnectBean();
				Connection conn = connect.getConnect();
				ResultSet rs=null;
				String sql = "select * from student where id = '"+ id +"'";
				PreparedStatement ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				while (rs.next()) {
					stu.setId(rs.getString(1));
					stu.setName(rs.getString(2));
					stu.setSex(rs.getString(4));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return stu;
	}
	
	public String message(String sid) 
	{
		
		try {
			DBConnectBean connect = new DBConnectBean();
			Connection conn = connect.getConnect();
			Statement st= conn.createStatement();
			ResultSet rs=null;
			System.out.print(id);
			String sql="select * from student where id = '"+ sid +"'";
	        rs = st.executeQuery(sql);
	        while(rs.next())
	        {
	        	id=rs.getString("id");
	        	name=rs.getString("name");
	            sex=rs.getString("sex");
	        	System.out.println("检测："+name);
	        }
          return "true";
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 return "false";
		}
	}
	
	public void updateStudent(HttpServletRequest request,String sid) throws UnsupportedEncodingException {
		DBConnectBean connect = new DBConnectBean();
		Connection conn = connect.getConnect();
		//查看sql 
		//解决中文乱码
		String id=request.getParameter("id");
		String name=new String(request.getParameter("name").getBytes("ISO8859-1"),"GB2312");
		String sex=new String(request.getParameter("sex").getBytes("ISO8859-1"),"GB2312");
		System.out.print("update student set id='"+id+"',"+"name = '" + name + "',"+ "sex = '" + sex+"' where id = '"+ sid + "'");

		String sql = "update student set id='"+id+"',"+"name = '" + name + "',"+ "sex = '" +sex +"' where id = '"+ sid + "'";
		
		try {
			Statement st = conn.createStatement();
			st.executeUpdate(sql);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
