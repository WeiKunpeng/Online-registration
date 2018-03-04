package Bean;

import java.sql.*;

public class AdminLoginBean {
	String adminname="";
	String password="";
	
	
	public String select (AdminLoginBean user) 
	{		
		try {
			DBConnectBean connect = new DBConnectBean();
			Connection conn = connect.getConnect();
			Statement st= conn.createStatement();
			ResultSet rs=null;
			String name=user.getAdminname();
			String pass=user.getPassword();
			String sql="select * from admin where adminname ='"+name+"'";
	        rs = st.executeQuery(sql);
	        while(rs.next())
	        {
	        	if(name.equals(rs.getString(1))&&pass.equals(rs.getString(2)))
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


	public String getAdminname() {
		return adminname;
	}


	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

}
