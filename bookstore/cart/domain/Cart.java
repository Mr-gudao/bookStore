package bookstore.cart.domain;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Create by wdb on 2017/11/13 19:56
 */

public class Cart {

    //商品id是键,商品是值
    private Map<String,CartItem> map= new HashMap<String,CartItem>();
    private String defaultAddress;

    public Map<String, CartItem> getMap() {
        return map;
    }

    public void setMap(Map<String, CartItem> map) {
        this.map = map;
    }

    public String getDefaultAddress() {
        return defaultAddress;
    }

    public void setDefaultAddress(String defaultAddress) {
        this.defaultAddress = defaultAddress;
    }




}
