package app.controller.reply;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import app.bean.Member;
import app.bean.Reply;
import app.repository.ReplyRepo;

/**
 * Servlet implementation class ReplyAddServlet
 */
@WebServlet("/reply/add")
public class ReplyAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//repos
	private ReplyRepo repo;
	
	@Override
	public void init() throws ServletException {
		super.init();
		repo = new ReplyRepo();
	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member m = (Member) session.getAttribute("loginUser");
		
		// 필요한 정보 셋팅
		String boardId = request.getParameter("boardId");
		String body = request.getParameter("body");
		String memberId = m.getMemberId();
		
		Reply reply = new Reply();
		reply.setBody(body);
		reply.setBoardId(Long.valueOf(boardId));
		reply.setMemberId(memberId);
		
		// db에 insert
		boolean ok = repo.addReply(reply);
		
		// forward or redirect
		response.sendRedirect(request.getContextPath()
				+ "/board/view?id=" + boardId);
		
	}

}










