//这个JavaBean可能不用

package Bean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentMessageBean {
	String  id="";
	String  name="";
	String  password="";
	String  sex="";

	String  number="";
	String  subject="";
	String  data="";
	String  time="";
	String  address="";
	String  score="";
	
	public String message(String Sid) 
	{
		
		try {
			DBConnectBean connect = new DBConnectBean();
			Connection conn = connect.getConnect();
			Statement st= conn.createStatement();
			ResultSet rs=null;
			System.out.print(id);
			String sql="SELECT student.id,name,sex,test.number,subject,data,time,address,s_test.sid,tnumber,score FROM student,test,s_test WHERE s_test.sid=student.id and test.tnumber=s_test.number and s_test.sid='"+Sid+"'";
	        rs = st.executeQuery(sql);
	        while(rs.next())
	        {
	        	id=rs.getString("student.id");
	        	name=rs.getString("name");
	            sex=rs.getString("sex");

	        	number=rs.getString("test.number");
	        	subject=rs.getString("subject");
	        	address=rs.getString("address");
	        	data=rs.getString("data");
	        	time=rs.getString("time");
	        	score=rs.getString("score");
	        	System.out.println(name);
	        }
          return "true";
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 return "false";
		}
	}
	/*
	public void message1(String userid) 
	{
		
		try {
			DBConnectBean con = new DBConnectBean();
			Connection conn = con.getConn();
			Statement st= conn.createStatement();
			ResultSet rs=null;
			System.out.print(userid);
			String sql="select Sid,Name,Sex,Age,Image,Degree,Enterprise,student.id,Language,examnumber.numbers,Address,Time from examcard,student,examnumber where examcard.id=student.id and examnumber.numbers=examcard.numbers and student.id='"+userid+"'";
	        rs = st.executeQuery(sql);
	        while(rs.next())
	        {
	        	Studentid=rs.getString("sid");
	        	username=rs.getString("name");
	            sex=rs.getString("sex");
	        	age=rs.getString("age");
	        	image=rs.getString("image");
	        	degree=rs.getString("degree");
	        	workplace=rs.getString("enterprise");
	        	id=rs.getString("id");
	        	language=rs.getString("language");
	        	number=rs.getString("numbers");
	        	address=rs.getString("address");
	        	time=rs.getString("time");
	        	System.out.println(username);
	        	System.out.println(degree);
	        }

		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
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
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
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
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}

}