package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminInsertTestServlet
 */
@WebServlet("/AdminInsertTestServlet")
public class AdminInsertTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminInsertTestServlet() {
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
		String number=request.getParameter("number");
		String subject=new String(request.getParameter("subject").getBytes("ISO8859-1"),"GB2312");
		String date=new String(request.getParameter("date").getBytes("ISO8859-1"),"GB2312");
		String time=new String(request.getParameter("time").getBytes("ISO8859-1"),"GB2312");
		String address=new String(request.getParameter("address").getBytes("ISO8859-1"),"GB2312");
		Bean.TestBean test = new Bean.TestBean();
		test.setNumber(number);
		test.setSubject(subject);
		test.setDate(date);
		test.setTime(time);
		test.setAddress(address);
		//System.out.print(id);
		String  result = new Bean.TestBean().insert(test);
		if(result.equals("true")){
			response.sendRedirect("AdminAlterTest.jsp");
		}

	}

}
