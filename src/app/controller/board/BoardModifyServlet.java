package app.controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import app.bean.Board;
import app.bean.Member;
import app.repository.BoardRepo;

/**
 * Servlet implementation class BoardModifyServlet
 */
@WebServlet("/board/modify")
public class BoardModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// view path
	private final String view = "/WEB-INF/view/board/modify.jsp";
	
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
    public BoardModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		Board board = repo.getBoardById(id);
		
		request.setAttribute("board", board);
		request.getRequestDispatcher(view).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member m = (Member) session.getAttribute("loginUser");
		
		// board 객체 만들고
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String body = request.getParameter("body");
		String memberId = m.getMemberId();
		
		Board board = new Board();
		board.setId(Long.valueOf(id));
		board.setTitle(title);
		board.setBody(body);
		board.setMemberId(memberId);
		
		// db에서 수정하고
		boolean ok = repo.updateBoard(board);
		
		// forward or redirect
		if (ok) {
			response.sendRedirect(request.getContextPath() 
					+ "/view?id=" + id);
		} else {
			request.setAttribute("board", board);
			request.getRequestDispatcher(view).forward(request, response);
		}
	}

}








