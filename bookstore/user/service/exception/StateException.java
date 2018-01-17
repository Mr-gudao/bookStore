package bookstore.user.service.exception;

/**
 * Create by wdb on 2017/11/11 20:08
 */

public class StateException extends RegisterException {

    @Override
    public String getMessage() {
        return "尚未激活,请先激活账户";
    }
}
