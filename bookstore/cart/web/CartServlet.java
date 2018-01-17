package bookstore.cart.web;

import bookstore.book.dao.BookDao;
import bookstore.book.domain.Book;
import bookstore.cart.domain.Cart;
import bookstore.cart.domain.CartItem;
import com.lanou.servlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Create by wdb on 2017/11/13 19:22
 */

@WebServlet(name = "CartServlet",urlPatterns = "/cartServlet")
public class CartServlet extends BaseServlet {

    private BookDao bookDao = new BookDao();

    public  String cartAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获得购物车
        Cart cart = (Cart) request.getSession().getAttribute("cart");


        //获取点击购买时传入的bookid
        String bid = request.getParameter("bid");

        Book book1 = bookDao.queryBookByBid(bid);

        int count = Integer.parseInt(request.getParameter("count"));

        return null;


    }


}
