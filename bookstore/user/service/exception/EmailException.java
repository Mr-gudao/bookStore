package bookstore.user.service.exception;

/**
 * Create by wdb on 2017/11/10 19:07
 */

public class EmailException extends RegisterException {

    @Override
    public String getMessage() {
        return "邮箱账号输入格式错误,请检查后重新输入";
    }
}
