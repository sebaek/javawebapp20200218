package app.controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import app.bean.Member;
import app.repository.BoardRepo;

/**
 * Servlet implementation class BoardAddServlet
 */
@WebServlet("/board/add")
public class BoardAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// view path
	private final String view = "/WEB-INF/view/board/add.jsp";
	
	// repos
	private BoardRepo repo;
	
	@Override
	public void init() throws ServletException {
		super.init();
		repo = new BoardRepo();
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member m = (Member) session.getAttribute("loginUser");
		
		if (m != null) {
			// 로그인 된 경우
			request.getRequestDispatcher(view).forward(request, response);
		} else {
			// 로그인 안된 경우
			response.sendRedirect(request.getContextPath() 
					+ "/member/login");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member m = (Member) session.getAttribute("loginUser");
		
		// get req parameters
		String title = request.getParameter("title");
		String body = request.getParameter("body");
		
		// insert db
		boolean ok = repo.addBoard(title, body, m.getMemberId());
		
		// forward or redirect
		if (ok) {
			response.sendRedirect(request.getContextPath());
		} else {
			request.setAttribute("title", title);
			request.setAttribute("body", body);
			request.getRequestDispatcher(view).forward(request, response);
		}
		
		
	}
	
	
	
	

}








