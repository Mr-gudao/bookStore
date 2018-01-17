package bookstore.user.web.servlet.filter;

import bookstore.user.domain.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Create by wdb on 2017/11/14 17:06
 */

//没有登录的用户,无法使用购物车和订单功能
@WebFilter(urlPatterns = "")
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest Request, ServletResponse Response, FilterChain Chain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) Request ;

        //从session中获得登录信息,如果没有登录,则不允许执行相关功能
        User user = (User) httpServletRequest.getSession().getAttribute("session_user");

        if (user != null){
            Chain.doFilter(Request,Response);
        }else{

            httpServletRequest.setAttribute("errorMsg","您还没有登录");
            httpServletRequest.getRequestDispatcher("/jsps/user/login.jsp");
        }
    }

    @Override
    public void destroy() {

    }
}
