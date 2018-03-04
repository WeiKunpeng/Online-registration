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

import Bean.ScoreBean;
/**
 * Servlet implementation class AdminEnterScoreServlet
 */
@WebServlet("/AdminEnterScoreServlet")
public class AdminEnterScoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminEnterScoreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int i=0;
		HttpSession session = request.getSession();
		session.getAttribute("studentScores");
		ArrayList<ScoreBean> arr1 = new ArrayList<ScoreBean>();
		ArrayList<ScoreBean> arr2 = new ArrayList<ScoreBean>();
		String sid;
		arr2 = (ArrayList<ScoreBean>)session.getAttribute("studentScores");
		Bean.ScoreBean s = new Bean.ScoreBean();
	/*	for(i = 0;i<arr2.size();i++)
		{
			s = (ScoreBean) arr2.get(i);
		}
	*/	
		for (i = 0;i<arr2.size();i++){
			String sequ = "score"+i;
			String score = request.getParameter(sequ);
			s = (ScoreBean) arr2.get(i);
			sid=(String)((ScoreBean)arr2.get(i)).getSid();
			s.setScore(score);	
			Bean.ScoreBean sco=new Bean.ScoreBean().scoreform(s,(String)s.getScore());
			session.setAttribute("score", sco);
			System.out.println("AdminEnterScore"+sid);
			System.out.println("AdminEnterScore"+s.getScore());
		} 
		

		request.getRequestDispatcher("AdminScore.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
