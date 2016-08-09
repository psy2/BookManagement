package controller.book;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.book.BookService;
import entity.book.BookEntity;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. �Է��� �޾ƿ�
		//2. ���ǿ��� �����͸� ���;� �ؿ�
		HttpSession session=request.getSession(true);
		String[] list=(String[]) session.getAttribute("CART");
		String[] oldlist=(String[]) session.getAttribute("OLDCART");
		String [] newlist=new String[list.length+oldlist.length];
		System.arraycopy(list, 0, newlist, 0, list.length);
		System.arraycopy(oldlist, 0, newlist, list.length, oldlist.length);
		session.setAttribute("OLDCART", newlist);
		//�� ������ ������ DBó�� �ؼ� ��ٱ��� ȭ���� ���� ���!
		
		BookService service=new BookService();
		ArrayList<BookEntity> result=service.listCart(newlist);
		//���� �ۼ��غ�����!!
		RequestDispatcher rd=request.getRequestDispatcher("cartResult.jsp");
		request.setAttribute("RESULT", result);
		rd.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
