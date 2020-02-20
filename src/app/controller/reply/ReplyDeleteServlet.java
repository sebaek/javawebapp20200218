package app.controller.reply;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import app.bean.Member;
import app.repository.ReplyRepo;

/**
 * Servlet implementation class ReplyDeleteServlet
 */
@WebServlet("/reply/delete")
public class ReplyDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// repos
	private ReplyRepo repo;
	
	@Override
	public void init() throws ServletException {
		repo = new ReplyRepo();
		super.init();
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyDeleteServlet() {
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
		
		// 필요한 정보 얻기
		String replyId = request.getParameter("replyId");
		String boardId = request.getParameter("boardId");
		
		// db에서 지우고
		repo.deleteReply(replyId, m.getMemberId());
		
		// redirect or forward
		response.sendRedirect(request.getContextPath() 
				+ "/board/view?id=" + boardId);
	}

}










