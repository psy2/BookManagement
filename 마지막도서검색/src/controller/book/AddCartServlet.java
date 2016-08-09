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
		//1.�ѱ�ó��
		response.setCharacterEncoding("UTF8");
		//2. �Է��� �޾ƿ�!
		String[] list=request.getParameterValues("checkBook");//values�� �������� ���� �� �ִ�.
		//�� �迭�ȿ� ���� ������ å�� ISBN ��ȣ�� �� �־��!
		//3. ���񽺸� ���� ����ó���� �ؿ�
		//session�� �̿��ؼ� �� �ȿ� ����ڰ� ������ å�� ������ ����
		//session�� servlet������ ����� �� �־��!!
		//�׷��� �ᱹ �� �ȿ��� session ó���� �� �� ����..
		
		HttpSession session=request.getSession(true);

		session.setAttribute("CART",list);
		response.sendRedirect("CartOK.html");//???????????????????�̰Ŷ� requestdispather���� ������ ������
		
	}

}
