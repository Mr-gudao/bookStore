package bookstore.user.service.exception;

/**
 * Create by wdb on 2017/11/11 14:24
 */

public class PasswordLoginException extends RegisterException {

    @Override
    public String getMessage() {
        return "密码输入错误,请重新输入";
    }
}
