package bookstore.book.dao;

import bookstore.book.domain.Book;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import bookstore.category.domain.Category;
import bookstore.user.dao.jdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/**
 * Create by wdb on 2017/11/13 14:20
 */

public class BookDao {

    Connection conn = jdbcUtil.getConnection();
    QueryRunner qr = new QueryRunner();

    //查找全部
    public List<Book> queryAllBook(){

        String sql = "select *from book";

        List<Book> books = null;
        try {
            books = qr.query(conn,sql,new BeanListHandler<Book>(Book.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;


    }
    public List<Book> queryBookByCid(String cid){

        String sql = "select *from book where cid = ?";

        List<Book> books = null;
        try {
            books = qr.query(conn,sql,new BeanListHandler<Book>(Book.class),cid);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;

    }

    public Book queryBookByBid(String bid){

        String sql = "select *from book where bid = ?";

        Book books = null;
        try {
            books = qr.query(conn,sql,new BeanHandler<Book>(Book.class),bid);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;

    }



}
