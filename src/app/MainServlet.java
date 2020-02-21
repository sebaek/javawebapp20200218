package app;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.bean.Board;
import app.repository.BoardRepo;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// view path
	private final String view = "/WEB-INF/view/main.jsp";
	
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
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		page = (page == null) ? "1" : page;
		
		int curPage = Integer.valueOf(page);
		int beginPage = curPage - 3;
		int endPage = curPage + 3;
		
		if (beginPage <= 0) {
			endPage = endPage + 1 + Math.abs(beginPage);
			beginPage = 1;
		}
		
		// db에서 board list 읽어옴
//		List<Board> list = repo.listBoard();
		List<Board> list = repo.listBoard(page);
		
		// request attribute에 set
		request.setAttribute("boardList", list);
		request.setAttribute("beginPage", beginPage);
		request.setAttribute("endPage", endPage);
		
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
