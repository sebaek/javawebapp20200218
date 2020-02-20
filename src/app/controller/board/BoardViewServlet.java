package app.controller.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.bean.Board;
import app.bean.Reply;
import app.repository.BoardRepo;
import app.repository.ReplyRepo;

/**
 * Servlet implementation class BoardViewServlet
 */
@WebServlet("/board/view")
public class BoardViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// view path
	private final String view = "/WEB-INF/view/board/view.jsp";
	
	// repos
	private BoardRepo boardRepo;
	private ReplyRepo replyRepo;
	
	@Override
	public void init() throws ServletException {
		super.init();
		boardRepo = new BoardRepo();
		replyRepo = new ReplyRepo();
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// id를 request parameter에서 얻고
		String id = request.getParameter("id");
		
		// board를 db에서 읽어서
		Board board = boardRepo.getBoardById(id);
		
		// reply들을 읽어서
		List<Reply> replyList = replyRepo.listReply(id);
		
		// request attribute에 넣고
		request.setAttribute("board", board);
		request.setAttribute("replyList", replyList);
		
		// forward
		request.getRequestDispatcher(view).forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
