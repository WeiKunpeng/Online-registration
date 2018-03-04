package Bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class ScoreBean {
	String  sid="";
	String  sname="";
	String  tnumber="";
	String  tsubject="";
	String  score="";
	
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getTnumber() {
		return tnumber;
	}
	public void setTnumber(String tnumber) {
		this.tnumber = tnumber;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getTsubject() {
		return tsubject;
	}
	public void setTsubject(String tsubject) {
		this.tsubject = tsubject;
	}
	
	public void userCheck(String id,String number)
    {

		try {
			DBConnectBean connect = new DBConnectBean();
			Connection conn = connect.getConnect();
			Statement st= conn.createStatement();
			ResultSet rs=null;

			String sql="select s_test.sid,tnumber,score,student.name,test.subject from student,test,s_test where student.id=s_test.sid and test.number=s_test.tnumber and s_test.sid='"+id+"'and s_test.tnumber='"+number+"'";
			rs = st.executeQuery(sql);
	           while(rs.next())
	           {
	        	sid=rs.getString(1);
	        	sname=rs.getString(4);
	        	tnumber=rs.getString(2);
	        	tsubject=rs.getString(5);
	        	score=rs.getString(3);

			 }

		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	
	
	public ArrayList<ScoreBean> scoreform()
	{ 
		ArrayList<ScoreBean> all = new ArrayList<ScoreBean>();
		try {
			DBConnectBean connect = new DBConnectBean();
			Connection conn = connect.getConnect();
		ResultSet rs=null;
		 String sql="select s_test.sid,tnumber,student.name,test.subject from student,test,s_test where s_test.sid=student.id and s_test.tnumber=test.number";
		 PreparedStatement ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				ScoreBean score=new ScoreBean();
				score.setSid(rs.getString(1));
				score.setSname(rs.getString(3));
				score.setTnumber(rs.getString(2));
				score.setTsubject(rs.getString(4));
				all.add(score);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return all;
		
	}
	
	public ScoreBean scoreform(ScoreBean sco, String scores) {
		ScoreBean score=new ScoreBean();

			try {
				DBConnectBean connect = new DBConnectBean();
				Connection conn = connect.getConnect();
				ResultSet rs=null;
				String sid=sco.getSid();
				String tnumber=sco.getTnumber();
				
				Statement st = conn.createStatement();
				String sql="select sid,tnumber from s_test where sid='"+sid+"'and tnumber='"+tnumber+"'";
			    PreparedStatement ps = conn.prepareStatement(sql);
			    System.out.println("检测:函数开始调用");
				rs = ps.executeQuery();
				if(!rs.next())
				{
					String sql2="select s_test.sid,tnumber,score,student.id,name,test.number,subject from student,test,s_test where s_test.sid=student.id and s_test.tnumber=test.number and student.id='"+sid+"'and test.number='"+tnumber+"'";
					ps = conn.prepareStatement(sql2);
					rs = ps.executeQuery();
					
					while(rs.next())
					{
					System.out.println("检测：执行");
					//System.out.println(rs.getString(1));
					score.setSid(rs.getString(1));
					score.setSname(rs.getString(5));
					score.setTnumber(rs.getString(2));
					score.setTsubject(rs.getString(7));
					//System.out.println(rs.getString(1));
					//System.out.println("insert into score values('"+rs.getString(1)+"','"+rs.getString(2)+"','"+rs.getString(3)+"','"+scores+"')");
					String sql3="insert into s_test values('"+rs.getString(1)+"','"+rs.getString(2)+scores+"')";
					st.executeUpdate(sql3);
					}		
				}
				
				else{
					System.out.println("此学生该科目成绩已存在");
					rs = ps.executeQuery();
				}
				
				String sql1 = "select s_test.sid,tnumber,student.name,test.subject from student,test,s_test where s_test.sid=student.id and s_test.tnumber=test.number and s_test.sid="+sid+"'";
			    ps = conn.prepareStatement(sql1);
				   rs = ps.executeQuery();
					while (rs.next()) {
						score.setSid(rs.getString(1));
						score.setSname(rs.getString(2));
						score.setTnumber(rs.getString(3));
						score.setTsubject(rs.getString(3));
						score.setScore(rs.getString(4));
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return score;
	}
	
	//所有学生成绩表单
	public ArrayList<ScoreBean> scoreform1()
	{
		ArrayList<ScoreBean> all = new ArrayList<ScoreBean>();
		try {
			DBConnectBean connect = new DBConnectBean();
			Connection conn = connect.getConnect();
		ResultSet rs=null;
		
	    String sql = "select s_test.sid,tnumber,score,student.name,test.subject from student,test,s_test where s_test.sid=student.id and s_test.tnumber=test.number";
	    PreparedStatement ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
			while (rs.next()) {
				ScoreBean score=new ScoreBean();
				score.setSid(rs.getString(1));
				score.setSname(rs.getString(4));
				score.setTnumber(rs.getString(2));
				score.setTsubject(rs.getString(5));
				score.setScore(rs.getString(3));
				all.add(score);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return all;
	}
	
	
	public ScoreBean scoreform(String sid,String tnumber) {
		ScoreBean score=new ScoreBean();

			try {
				DBConnectBean connect = new DBConnectBean();
				Connection conn = connect.getConnect();
				ResultSet rs=null;
				System.out.println(sid);
				String sql = "select s_test.sid,tnumber,score,student.name,test.subject from student,test,s_test where s_test.sid=student.id and s_test.tnumber=test.number and s_test.sid='"+sid+"'and s_test.tnumber='"+tnumber+"'";
				PreparedStatement ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				while (rs.next()) {
					
					score.setSid(rs.getString(1));
					score.setSname(rs.getString(4));
					score.setTnumber(rs.getString(2));
					score.setTsubject(rs.getString(5));
					score.setScore(rs.getString(3));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return score;
	}
	
	
	
	public void updateScore(HttpServletRequest request,String sid,String tnumber) {
		DBConnectBean connect = new DBConnectBean();
		Connection conn = connect.getConnect();

		
		String sql = "update s_test set score = '" + request.getParameter("score")+"'where sid = '"+ sid + "'and tnumber='"+tnumber+"'";
		
		try {
			Statement st = conn.createStatement();
			st.executeUpdate(sql);
			//dc.con.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
