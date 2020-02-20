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
 * Servlet implementation class BoardDeleteServlet
 */
@WebServlet("/board/delete")
public class BoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
    public BoardDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member m = (Member) session.getAttribute("loginUser");
		
		// 필요한 정보 얻고
		String id = request.getParameter("id");
		String memberId = m.getMemberId();
		String password = request.getParameter("password");
		
		// db에서 delete 하고
		boolean ok = repo.deleteBoard(id, memberId, password);
		
		// forward or redirect
		if (ok) {
			response.sendRedirect(request.getContextPath());
		} else {
			
			response.sendRedirect(request.getContextPath()
					+ "/board/view?id=" + id);
		}
	}

}












