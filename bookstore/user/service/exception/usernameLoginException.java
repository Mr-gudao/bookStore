package bookstore.user.service.exception;

/**
 * Create by wdb on 2017/11/11 11:54
 */

public class usernameLoginException extends RegisterException {

    @Override
    public String getMessage() {
        return "该用户还未注册,请检查后重新输入或进行注册";
    }
}
