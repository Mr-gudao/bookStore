package bookstore.user.service.exception;

/**
 * Create by wdb on 2017/11/10 18:38
 */

public class UsernameException extends RegisterException {


    @Override
    public String getMessage() {
        return "用户名输入格式有误,长度为2-10";
    }
}
