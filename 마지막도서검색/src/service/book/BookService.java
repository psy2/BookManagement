package service.book;

import java.util.ArrayList;

import dao.book.BookDAO;
import entity.book.BookEntity;

public class BookService {

	public ArrayList<BookEntity> search(BookEntity entity) {
		BookDAO dao=new BookDAO();
		ArrayList <BookEntity> result=dao.search(entity);
		
		return result;
	}

	public ArrayList<BookEntity> listCart(String[] list) {
		BookDAO dao=new BookDAO();
		ArrayList <BookEntity> result=dao.listCart(list);
		
		return result;
	}
	
	
	
}
