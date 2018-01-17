package bookstore.user.service.exception;

/**
 * Create by wdb on 2017/11/10 19:20
 */

public class UserExistException extends RegisterException {

    @Override
    public String getMessage() {
        return"对不起,该用户名已经存在,请重新注册";
    }
}
