package controller.book;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddCartServlet
 */
@WebServlet("/addCart")
public class AddCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.한글처리
		response.setCharacterEncoding("UTF8");
		//2. 입력을 받아요!
		String[] list=request.getParameterValues("checkBook");//values는 여러개를 받을 수 있다.
		//이 배열안에 현재 선택한 책의 ISBN 번호가 들어가 있어요!
		//3. 서비스를 만들어서 로직처리를 해요
		//session을 이용해서 이 안에 사용자가 선택한 책의 정보를 저장
		//session은 servlet에서만 사용할 수 있어요!!
		//그래서 결국 이 안에서 session 처리를 할 꺼 에욧..
		
		HttpSession session=request.getSession(true);

		session.setAttribute("CART",list);
		response.sendRedirect("CartOK.html");//???????????????????이거랑 requestdispather와의 차이점 뭐였지
		
	}

}
