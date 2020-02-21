package app.controller.board;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import app.bean.Board;
import app.bean.Member;
import app.repository.BoardRepo;

/**
 * Servlet implementation class BoardAddServlet
 */
@WebServlet("/board/add")
@MultipartConfig
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
		
		Part filePart = request.getPart("file");
		String fileName = filePart.getSubmittedFileName();
		
		// create Board instance
		Board board = new Board();
		board.setTitle(title);
		board.setBody(body);
		board.setFileName(fileName);
		board.setMemberId(m.getMemberId());
		
		// insert db
//		boolean ok = repo.addBoard(title, body, m.getMemberId());
		repo.addBoard(board);
		
		System.out.println(board);
		
		// store file
		createFile(filePart, board);
		
		// forward or redirect
		if (board.getId() != 0) {
			response.sendRedirect(request.getContextPath());
		} else {
			request.setAttribute("title", title);
			request.setAttribute("body", body);
			request.getRequestDispatcher(view).forward(request, response);
		}
		
		
	}

	private void createFile(Part filePart, Board board) {
		ServletContext app = getServletContext();
		String contextRoot = app.getContextPath();
		
		String filePath = 
				"C:/Users/USER/Documents/myworkspace/static"
				+ contextRoot + "/" + board.getId();
		
		File fileDir = new File(filePath);
		
		if (!fileDir.exists()) {
			fileDir.mkdirs();
		}
	
		try {
			filePart.write(filePath + "/" + filePart.getSubmittedFileName());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	

}








