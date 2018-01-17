package bookstore.category.web.servlet;

import bookstore.category.domain.Category;
import bookstore.category.service.CategoryService;
import com.lanou.servlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Create by wdb on 2017/11/13 10:59
 */

@WebServlet(name = "CategoryServlet",urlPatterns = "/categoryServlet")
public class CategoryServlet extends BaseServlet {

    private CategoryService categoryService = new CategoryService();

    public String classify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //  显示左侧分类列表
        List<Category> cates = categoryService.findAll();

        //测试
//        for (Category c: cates
//             ) {
//            System.out.println(c);
//        }

        request.setAttribute("category",cates);
        return "f:/jsps/left.jsp";

    }
}
