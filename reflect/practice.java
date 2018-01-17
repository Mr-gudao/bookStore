package reflect;
import java.lang.reflect.Field;

/**
 * Create by wdb on 2017/11/14 15:38
 */

public class practice {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        //反射机制获取类的三种方法

        //第一种方法(.forname)
        Class c1 =Class.forName("Employee");

        //第二种方法.class
        Class c2 =Employee.class;

        //第三种方法,创建该类的对象,对象有getClass方法

        Employee employee= new Employee();
        Class c3 = employee.getClass();

       // 反射机制创建该类的对象
        //调用Employee的无参构造方法
        Object object = c1.newInstance();

        //获得该类的所有属性
        Field[] fileds = c1.getDeclaredFields();
    }



}
