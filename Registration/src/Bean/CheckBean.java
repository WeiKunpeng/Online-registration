package Bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;


public class CheckBean {
	String sid="";
	String sname="";
	String tnumber="";
	String tsubject="";
	String score="";
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getTnumber() {
		return tnumber;
	}
	public void setTnumber(String tnumber) {
		this.tnumber = tnumber;
	}
	public String getTsubject() {
		return tsubject;
	}
	public void setTsubject(String tsubject) {
		this.tsubject = tsubject;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	
	public ArrayList<CheckBean> checkId (String id) {
		ArrayList<CheckBean> all = new ArrayList<CheckBean>();
		
			try {
				DBConnectBean connect = new DBConnectBean();
				Connection conn = connect.getConnect();
				ResultSet rs=null;
				System.out.println("检测：进循环前");
				String sql="select s_test.sid,tnumber,score,student.name,test.subject from student,test,s_test where s_test.sid=student.id and s_test.tnumber=test.number and s_test.sid='"+id+"'";
				Statement st = conn.createStatement();
				rs = st.executeQuery(sql);
				
					while(rs.next())
					{
					CheckBean ch=new CheckBean();
					System.out.println("执行");
					ch.setSid(rs.getString(1));
					ch.setSname(rs.getString(4));
					ch.setTnumber(rs.getString(2));
					ch.setTsubject(rs.getString(5));
					
					ch.setScore(rs.getString(3));
					all.add(ch);
					}		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return all;
	}
	
	public ArrayList<CheckBean> checkNumber (String number) {
		ArrayList<CheckBean> all = new ArrayList<CheckBean>();
		
			try {
				DBConnectBean connect = new DBConnectBean();
				Connection conn = connect.getConnect();
				ResultSet rs=null;
				System.out.println("检测：进循环前");
				String sql="select s_test.sid,tnumber,score,student.name,test.subject from student,test,s_test where s_test.sid=student.id and s_test.tnumber=test.number and s_test.tnumber='"+number+"'";
				Statement st = conn.createStatement();
				rs = st.executeQuery(sql);
				
					while(rs.next())
					{
					CheckBean ch=new CheckBean();
					System.out.println("执行");
					ch.setSid(rs.getString(1));
					ch.setSname(rs.getString(4));
					ch.setTnumber(rs.getString(2));
					ch.setTsubject(rs.getString(5));
					
					ch.setScore(rs.getString(3));
					all.add(ch);
					}		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return all;
	}
	
	//精确查找
	public ArrayList<CheckBean> accurateCheck (String id,String number) {
		ArrayList<CheckBean> all = new ArrayList<CheckBean>();
		
			try {
				DBConnectBean connect = new DBConnectBean();
				Connection conn = connect.getConnect();
				ResultSet rs=null;
				System.out.println("检测：进循环前");
				String sql="select s_test.sid,tnumber,score,student.name,test.subject from student,test,s_test where s_test.sid=student.id and s_test.tnumber=test.number and s_test.sid='"+id+"' and "+"s_test.tnumber='"+number+"'";
				Statement st = conn.createStatement();
				rs = st.executeQuery(sql);
				
					while(rs.next())
					{
					CheckBean ch=new CheckBean();
					System.out.println("执行");
					ch.setSid(rs.getString(1));
					ch.setSname(rs.getString(4));
					ch.setTnumber(rs.getString(2));
					ch.setTsubject(rs.getString(5));
					
					ch.setScore(rs.getString(3));
					all.add(ch);
					}		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return all;
	}
	
	public String insert(String sid,String tnumber) {
		DBConnectBean connect = new DBConnectBean();
		Connection conn = connect.getConnect();

		
		//String sql = "INSERT INTO s_test VALUES(?,?,?)";
		
		try {//设置参数
			Statement st= conn.createStatement();
			ResultSet rs=null;
			String sql ="select * from s_test where sid='"+ sid +"'and tnumber='"+ tnumber +"'";
			System.out.println("helloworld:"+sid+"helloworld:"+tnumber);
			rs = st.executeQuery(sql);
			if(!rs.next())
			  {
				PreparedStatement ps=conn.prepareStatement("INSERT INTO s_test VALUES(?,?,?)");
				ps.setString(1,sid);
				ps.setString(2,tnumber);
				ps.setString(3,null);

					
				ps.executeUpdate();
				System.out.println("hello数据成功插入到数据库中！");
				return "true";
			   }
			 else
				 return "false";
			  
		   }catch (SQLException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
			return "false";
		  }
				
		}

}
