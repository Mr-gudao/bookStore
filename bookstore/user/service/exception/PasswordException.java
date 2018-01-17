package bookstore.user.service.exception;

/**
 * Create by wdb on 2017/11/10 19:04
 */

public class PasswordException extends RegisterException {

    @Override
    public String getMessage() {
        return "密码输入格式错误,长度必须为6-10";
    }
}
