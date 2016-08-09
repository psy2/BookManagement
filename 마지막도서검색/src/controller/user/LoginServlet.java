package controller.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sevice.user.UserService;
import entity.user.UserEntity;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 한글처리??
		//get방식인 경우는 프로그램 처리보다는 tomcat 환경에서 처리해주는게 좋아요
		//URIEncoding="UTF8" 설정을 Connector 에 추가
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 한글처리
		//post방식인 경우에만 사용할 수 있어요
		request.setCharacterEncoding("UTF8");
		//2. 사용자로부터 넘어온 데이터를 받아요!(입력받아요)
		String id=request.getParameter("inputId");
		String pw=request.getParameter("inputPW");
		//3. 로직처리
		//service 객체를 이용해서 로직처리를 시켜요!
		UserService service =new UserService();
		//user에 대한 entity 를 만들어서 인자로 이용.
		UserEntity entity=new UserEntity();
		entity.setUid(id);
		entity.setUpw(pw);
		boolean result=service.login(entity);
		String []list = new String[1];
		//4.view
		RequestDispatcher rd=request.getRequestDispatcher("loginResult.jsp");
		if(result){
			//로그인에 성공했으니까 해당 클라이언트에게 session객체를 할당해요.
			HttpSession session=request.getSession(true);
			//만약 이전에 사용하던 세션 객체가 존재하면 만들지 말고 그거 들고와.
			//로그인될때마다...
			
			session.setAttribute("USERID",id);
			session.setAttribute("OLDCART",list );
//			request.setAttribute("MSG", id+"님 환영합니다");
			request.setAttribute("flag", true);
			rd.forward(request, response);
		}else{
			request.setAttribute("MSG", "로그인에 실패했어요 다시 로그인하세요!");
			request.setAttribute("flag", false);
			rd.forward(request,response);
		}
		
	}

}
