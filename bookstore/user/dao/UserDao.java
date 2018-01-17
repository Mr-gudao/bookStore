package bookstore.user.dao;

import bookstore.user.domain.User;
import com.lanou.commons.CommonUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Create by wdb on 2017/11/10 11:00
 */

    //  只能操作数据库,不能做其他操作

public class UserDao {

    public User findByName(String username) throws SQLException {

        Connection conn1 = jdbcUtil.getConnection();

        QueryRunner qr = new QueryRunner();

        String sq1 = "select *from tb_user where username = ?";

        User user1 = qr.query(conn1, sq1, new BeanHandler<User>(User.class), username);

        return user1;

    }

    public User findByEmail(String email) throws SQLException {

        Connection conn2 = jdbcUtil.getConnection();

        QueryRunner qr = new QueryRunner();

        String sq2 = "select *from tb_user where email = ?";

        User user2 = qr.query(conn2, sq2, new BeanHandler<User>(User.class), email);

        return user2;

    }

    public void addIntSql(User user) {


        Connection conn3 = jdbcUtil.getConnection();

        QueryRunner qr = new QueryRunner();

        String sq3 = "insert into tb_user values(?,?,?,?,?,0)";

        PreparedStatement prep = null;


        try {
            prep = conn3.prepareStatement(sq3);

            prep.setString(1, user.getUid());
            prep.setString(2, user.getUsername());
            prep.setString(3, user.getPassword());
            prep.setString(4, user.getEmail());
            prep.setString(5, user.getCode());

            prep.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        jdbcUtil.close(prep);
        jdbcUtil.close(conn3);


    }


    public void changeState(String code) throws SQLException {

        Connection conn1 = jdbcUtil.getConnection();

        QueryRunner qr = new QueryRunner();

        String sq4 = "update tb_user set state=1  where code = ?";

         qr.update(conn1,sq4,code);

    }


}


