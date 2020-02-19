package app.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.bean.Member;
import app.repository.MemberRepo;

/**
 * Servlet implementation class SingUpServlet
 */
@WebServlet("/member/signup")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// view path
	private final String view = "/WEB-INF/view/member/signup.jsp";
       
	// repo instance
	private MemberRepo repo;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.repo = new MemberRepo();
	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
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
		// request parameter 받아서
		String id = request.getParameter("memberId");
		String pw = request.getParameter("password");
		String email = request.getParameter("email");
		String nickName = request.getParameter("nickName");
		
		// Member bean만들고
		Member member = new Member();
		member.setMemberId(id);
		member.setPassword(pw);
		member.setEmail(email);
		member.setNickName(nickName);
		
		// db에 insert하고
		boolean ok = repo.addMember(member);
		
		// forward or redirect
		if (ok) {
			response.sendRedirect(request.getContextPath() + "/");
		} else {
			request.getRequestDispatcher(view).forward(request, response);
		}
		
	}

}










