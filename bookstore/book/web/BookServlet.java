package bookstore.book.web;

import bookstore.book.domain.Book;
import bookstore.book.service.BookService;
import com.lanou.servlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Create by wdb on 2017/11/13 14:33
 */

@WebServlet(name = "BookServlet",urlPatterns = "/bookServlet")
public class BookServlet extends BaseServlet {

    private BookService bookService = new BookService();

    public String findAllBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Book> books = bookService.findAllBook();

//        for (Book b:books
//             ) {
//            System.out.println(b);
//        }

        request.setAttribute("book", books);
        return "f:/jsps/book/list.jsp";

    }

    public String findBookByCid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //单类查找
        String cid = request.getParameter("cid");

        List<Book> bookByCid = bookService.findBookByCid(cid);

        //测试
//        for (Book c:
//             bookByCid) {
//
//            System.out.println(c);
//
//        }

        request.setAttribute("book",bookByCid);
        return "f:/jsps/book/list.jsp";

    }

    public String findBookByBid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String bid = request.getParameter("bid");
        Book bookByBid = bookService.findBookByBid(bid);

        //测试
//                for (Book c:
//             bookByBid) {
//
//            System.out.println(c);
//
//        }
        request.setAttribute("book",bookByBid);
        return "f:/jsps/book/desc.jsp";




    }
}