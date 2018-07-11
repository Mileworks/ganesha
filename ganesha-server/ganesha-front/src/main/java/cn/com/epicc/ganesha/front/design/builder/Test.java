package cn.com.epicc.ganesha.front.design.builder;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

/**
 * Description:
 * Author: lishangmin
 * Created: 2018-07-09 17:35
 */
@Slf4j
public class Test {

    public static void main(String[] args) {
        Human human  = Human.builder().age("11").build();
        log.info(JSON.toJSONString(human));

        Human human1 = Human.builder().name("zhangsan").age("14").build();
        log.info(JSON.toJSONString(human1));
    }
}
