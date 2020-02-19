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
 * Servlet implementation class MemberDeleteServlet
 */
@WebServlet("/member/delete")
public class MemberDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// view path
	private final String view = "/WEB-INF/view/member/delete.jsp";
	
	// repos
	private MemberRepo repo;
	
	@Override
	public void init() throws ServletException {
		super.init();
		repo = new MemberRepo();
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberDeleteServlet() {
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
		HttpSession session = request.getSession();
		Member m = (Member) session.getAttribute("loginUser");
		String id = m.getMemberId();
		String pw = request.getParameter("password");
		
		boolean ok = repo.deleteMember(id, pw);
		
		if (ok) {
			session.invalidate();
			response.sendRedirect(request.getContextPath() + "/");
		} else {
			request.getRequestDispatcher(view).forward(request, response);
		}
		
	}

}







