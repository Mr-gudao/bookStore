package bookstore.category.service;

import bookstore.category.dao.CategoryDao;
import bookstore.category.domain.Category;

import java.util.List;

/**
 * Create by wdb on 2017/11/13 10:58
 */

public class CategoryService {

    private CategoryDao categoryDao = new CategoryDao();

    public List<Category> findAll(){

        List<Category> cate = categoryDao.queryAll();

        return cate;


    }

}
