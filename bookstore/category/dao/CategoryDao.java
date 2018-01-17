package bookstore.category.dao;

import bookstore.category.domain.Category;
import bookstore.user.dao.jdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Create by wdb on 2017/11/13 10:36
 */


//查询分类
public class CategoryDao {

    public List<Category> queryAll(){

        Connection conn = jdbcUtil.getConnection();
        QueryRunner qr = new QueryRunner();

        String sql = "select *from category ";
        List<Category> categories = null;
        try {
            categories = qr.query(conn,sql,new BeanListHandler<Category>(Category.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return categories;

    }

}
