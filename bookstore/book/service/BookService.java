package bookstore.book.service;

import bookstore.book.dao.BookDao;
import bookstore.book.domain.Book;

import java.util.List;

/**
 * Create by wdb on 2017/11/13 14:24
 */

public class BookService {

    private BookDao bookDao = new BookDao();

    public List<Book> findAllBook(){

        //全部查找
        List<Book> books = bookDao.queryAllBook();

        return books;
    }

    public List<Book> findBookByCid(String cid){

        //全部查找
        List<Book> books1 = bookDao.queryBookByCid(cid);

        return books1;
    }

    public Book findBookByBid(String bid){

        //全部查找
        Book books2 = bookDao.queryBookByBid(bid);

        return books2;
    }


}
