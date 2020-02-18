package app.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import app.bean.Member;
import app.repository.MemberRepo;

/**
 * Servlet implementation class LogInServlet
 */
@WebServlet("/member/login")
public class LogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// view path
	private final String view = "/WEB-INF/view/member/login.jsp";
	
	// repo
	private MemberRepo repo;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.repo = new MemberRepo();
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogInServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(view).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파라미터에서 값을 받아서
		String id = request.getParameter("memberId");
		String pw = request.getParameter("password");
		
		// 회원 조회를 하고
		Member member = repo.getMember(id, pw);
		
		// 있으면 메인 화면 redirect
		if (member != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", member);
			response.sendRedirect(request.getContextPath() + "/");
		} else {
		// 없으면 로그인 forward
			request.setAttribute("message", "로그인 할 수 없음");
			request.getRequestDispatcher(view).forward(request, response);
		}
		
		
	}

}






