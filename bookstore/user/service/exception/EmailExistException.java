package bookstore.user.service.exception;

/**
 * Create by wdb on 2017/11/10 19:53
 */

public class EmailExistException extends RegisterException{

    @Override
    public String getMessage() {
        return
                "该邮箱账号已被注册,请输入其他邮箱账号";
    }
}
