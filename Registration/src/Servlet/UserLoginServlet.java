package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=new String(request.getParameter("id").getBytes("ISO8859-1"),"GB2312");
		String password=request.getParameter("password");//获取用户名和密码
		System.out.print("123");
		Bean.UserLoginBean user = new Bean.UserLoginBean();
		user.setId(id);
		user.setPassword(password);
				String result = new Bean.UserLoginBean().select(user);
				if(result.equals("true")){
			   /*
					Bean.UserLoginBean Student=new Bean.UserLoginBean();
					Student=user.showStudent(id);
					System.out.println("学生信息传输检测");
					request.setAttribute("id", Student.getId());
					request.setAttribute("name", Student.getName());
			//		request.setAttribute("password", Student.getPassword());
					request.setAttribute("sex", Student.getSex());
					System.out.println(Student.getId());
					System.out.println(Student.getName());
					//request.getRequestDispatcher("UserSelect.jsp").forward(request, response);
			    */
					 
					response.sendRedirect("UserSelect.jsp?sid="+id);
				}
				else{
					response.sendRedirect("UserLoginError.jsp");
				}
	}

}
