package bookstore.cart.domain;

import bookstore.book.domain.Book;

/**
 * Create by wdb on 2017/11/13 20:09
 */

public class CartItem {

    private Book book; //条目内的商品
    private int count;  //条目内商品的数量

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}


