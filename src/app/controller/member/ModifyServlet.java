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
 * Servlet implementation class ModifyServlet
 */
@WebServlet("/member/modify")
public class ModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//view path
	private final String view = "/WEB-INF/view/member/view.jsp";
	
	//repos
	private MemberRepo repo;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.repo = new MemberRepo();
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyServlet() {
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
		
		// request parameter 꺼내서
		String id = request.getParameter("memberId");
		String pw = request.getParameter("password");
		String email = request.getParameter("email");
		String nickName = request.getParameter("nickName");
		
		Member member = new Member();
		member.setMemberId(id);
		member.setPassword(pw);
		member.setEmail(email);
		member.setNickName(nickName);
		// db 수정
		repo.modifyMember(member);
		
		// forward or redirect
		HttpSession session = request.getSession();
		session.setAttribute("loginUser", member);
		request.getRequestDispatcher(view).forward(request, response);
		
	}
	
	

}







