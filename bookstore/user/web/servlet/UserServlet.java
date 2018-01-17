package bookstore.user.web.servlet;

import bookstore.cart.domain.Cart;
import bookstore.user.dao.UserDao;
import bookstore.user.domain.User;
import bookstore.user.service.UserService;
import bookstore.user.service.exception.RegisterException;
import com.lanou.commons.CommonUtils;
import com.lanou.servlet.BaseServlet;
import email.Email;
import org.apache.commons.beanutils.BeanUtils;

import javax.mail.MessagingException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

/**
 * Create by wdb on 2017/11/14 9:23
 */

@WebServlet(name = "UserServlet",urlPatterns = "/userServlet")
public class UserServlet extends BaseServlet {

    private UserService userService = new UserService();
    private UserDao userDao = new UserDao();


    //注册账户
    public String register(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {

        request.setCharacterEncoding("utf-8");

        Email email = new Email();

        User user = new User();
        try {

            BeanUtils.populate(user, request.getParameterMap());
            user.setUid(CommonUtils.uuid());
            user.setCode(CommonUtils.uuid() + CommonUtils.uuid());

            //检查输入的信息,格式是否正确,是否已注册
            userService.check(user);
            userService.regist(user);
            userService.addIntoSql(user);

            email.t1(user);

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (RegisterException e) {
            request.setAttribute("user", user);
            request.setAttribute("errorMsg", e.getMessage());
            return "f:/jsps/user/regist.jsp";
        }

        return "r:/jsps/user/login.jsp";
    }


    //激活账户
    public String activate(HttpServletRequest request, HttpServletResponse response) {

        //激活账户,改变激活状态
        String code1 = request.getParameter("code");

        try {
            userDao.changeState(code1);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        String successMessage = "恭喜你,注册激活成功!!";
        request.setAttribute("mesg",successMessage);
        return "f:/jsps/user/login.jsp";
    }


    //登录
    public String login(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {

        request.setCharacterEncoding("utf-8");
        User user = new User();
        try {
            //获取登录jsp输入的内容
            BeanUtils.populate(user,request.getParameterMap());

            //检查输入的账户密码是否正确,是否处于激活状态
            userService.checkUserLogin(user);


        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (RegisterException e) {

            request.setAttribute("user",user);
            request.setAttribute("errorMsg",e.getMessage());
            return "f:/jsps/user/login.jsp";
        }

        Cookie cookie1 = new Cookie("cookieName",user.getUsername());
        response.addCookie(cookie1);
        //保存登录状态
        request.getSession().setAttribute("session_user",user);

        //生成购物车
        request.getSession().setAttribute("cart", new Cart());

        //登录成功,进入主页面
        return "r:/jsps/main.jsp";
    }

    //退出登录
    public String quit(HttpServletRequest request, HttpServletResponse response) {

        //invalidate()方法使窗口失效
        request.getSession().invalidate();
        return "r:/index.jsp";

    }
}