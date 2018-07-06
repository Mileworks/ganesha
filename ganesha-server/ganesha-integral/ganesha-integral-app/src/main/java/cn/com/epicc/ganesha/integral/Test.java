package cn.com.epicc.ganesha.integral;

import lombok.extern.slf4j.Slf4j;

/**
 * Description:
 * Author: lishangmin
 * Created: 2018-07-05 16:44
 */
@Slf4j
public class Test {
    public static void main(String[] args) {
        String a = "111";

        String b = "BB";

        log.info(a.hashCode() + " " +  b.hashCode());

        log.info(System.identityHashCode(a)+"");
        log.info(System.identityHashCode(b)+"");

        char[] chars = a.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (char c: chars) {
            Integer val = (int) c;
            log.info("value:{}",val);
            builder.append(val);
            log.info(builder.toString());
        }


    }
}
