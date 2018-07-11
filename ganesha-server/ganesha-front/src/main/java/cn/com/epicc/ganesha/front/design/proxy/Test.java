package cn.com.epicc.ganesha.front.design.proxy;

/**
 * Description:
 * Author: lishangmin
 * Created: 2018-07-09 17:50
 */
public class Test {

    public static void main(String[] args) {
        Proxy proxy = new Proxy(new GameImpl());
        proxy.execute();
    }

}
