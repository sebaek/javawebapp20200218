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
 * Servlet implementation class ReplyModifyServlet
 */
@WebServlet("/reply/modify")
public class ReplyModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// repos
	private ReplyRepo repo;
	
	@Override
	public void init() throws ServletException {
		super.init();
		repo = new ReplyRepo();
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyModifyServlet() {
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
		
		// request parameter 받고
		String boardId = request.getParameter("boardId");
		String replyId = request.getParameter("replyId");
		String body = request.getParameter("body");
		String memberId = m.getMemberId();
		
		// db 수정하고
		repo.updateReply(replyId, memberId, body);
		
		// forward or redirect
		response.sendRedirect(request.getContextPath()
				 + "/board/view?id=" + boardId);
	}

	
	
	
	
}










