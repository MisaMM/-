package search;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchAction
 */
@WebServlet("/SearchAction")
public class SearchAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String text = request.getParameter("text");
		String s_type = request.getParameter("search_type");
		System.out.print(text+s_type);
		SearchDB sdb = new SearchDB();
		ArrayList<WorkInfo> works = new ArrayList<WorkInfo>();
		if(s_type.equals("内容"))
		{
			works=sdb.SearchByWork(text);
			request.getSession().setAttribute("worksList",works);
			response.sendRedirect("index.jsp?search=1");
		}
		if(s_type.equals("作者"))
		{	
			works=sdb.SearchByWriter(text);
			request.getSession().setAttribute("worksList",works);
		    response.sendRedirect("index.jsp?search=2");
		}
	}

}
