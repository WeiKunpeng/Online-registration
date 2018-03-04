package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

import Bean.CheckBean;
/**
 * Servlet implementation class AdminCheckScoreServlet
 */
@WebServlet("/AdminCheckScoreServlet")
public class AdminCheckScoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminCheckScoreServlet() {
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
		HttpSession session = request.getSession();
		ArrayList<CheckBean> all = new ArrayList<CheckBean>();
		String id=new String(request.getParameter("id").getBytes("ISO8859-1"),"GB2312");
		String number=new String(request.getParameter("number").getBytes("ISO8859-1"),"GB2312");
		if(id.length()!=0)    //id²»Îª¿Õ
		{
			if(number.length()!=0)
            {
				all=new Bean.CheckBean().accurateCheck(id, number);
				session.setAttribute("check", all);
				request.getRequestDispatcher("AdminAccurateCheck.jsp").forward(request, response);
			}
			else
			{
				all=new Bean.CheckBean().checkId(id);
				session.setAttribute("check", all);
				request.getRequestDispatcher("AdminAccurateCheck.jsp").forward(request, response);
			}
		}
		else
		{
			if(number.length()!=0)
			{
				all=new Bean.CheckBean().checkNumber(number);
				session.setAttribute("check", all);
				request.getRequestDispatcher("AdminAccurateCheck.jsp").forward(request, response);
			}
			else
				response.sendRedirect("CheckError.jsp");
		}
		
	}

}
