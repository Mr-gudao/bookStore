package bookstore.user.service;

import bookstore.user.dao.UserDao;
import bookstore.user.domain.User;
import bookstore.user.service.exception.*;

import java.sql.SQLException;

/**
 * Create by wdb on 2017/11/10 10:43
 */
        // 做判断
public class UserService {
    private UserDao userDao = new UserDao();
   public boolean check(User user) throws RegisterException {
       //用户名输入错误
        if (user.getUsername().length()<2 || user.getUsername().length()>10){
            throw new UsernameException();
        }
        //密码输入错误
        if (user.getPassword().length()<6 || user.getPassword().length()>10){
            throw new PasswordException();
        }
        //邮箱输入错误
        if (user.getEmail().matches("^\\\\w+((-\\\\w+)|(\\\\.\\\\w+))*\\\\@[A-Za-z0-9]+((\\\\.|-)[A-Za-z0-9]+)*\\\\.[A-Za-z0-9]+$")){

            throw new EmailException();
       }
        return false;
   }
   public boolean regist(User user) throws RegisterException {

       User userExist1 = null;

       User userExist2 = null;
       try {
           userExist1 = userDao.findByName(user.getUsername());
           userExist2 = userDao.findByEmail(user.getEmail());
           if (userExist1 != null) {
               //说明用户名存在
               throw new UserExistException();
           }
           if (userExist2 != null){

               throw new EmailExistException();
           }
       } catch (SQLException e) {
           e.printStackTrace();
       }
               return false;
           }
    //注册成功,添加到数据库
    public boolean addIntoSql(User user) {
        userDao.addIntSql(user);
        return true;
    }


    public boolean
    checkUserLogin(User user) throws RegisterException {

       User userLogin = null;

        try {
            userLogin = userDao.findByName(user.getUsername());

            if (userLogin == null){
                throw new usernameLoginException();
            }

            if(!userLogin.getPassword().equals(user.getPassword())){
                throw new PasswordLoginException();
            }

            if (userLogin.getState() == 0){
                throw  new StateException();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

}
