package cn.com.epicc.ganesha.integral;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Description:
 * Author: lishangmin
 * Created: 2018-07-05 16:44
 */
@Slf4j
public class Test {

    private final static int threadCount = 100;

    public static void main(String[] args) throws Exception{
        RestTemplate restTemplate = new RestTemplate();
        ExecutorService exec = Executors.newCachedThreadPool();

        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);

        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            exec.execute(()->{
                try{
                    String url="http://127.0.0.1:8000/api-b/integral/add";
                    String bodyValTemplate = "accountId=" + URLEncoder.encode("111", "utf-8") + "&integral=" + URLEncoder.encode("10", "utf-8");
                    HttpHeaders headers = new HttpHeaders();
                    headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
                    HttpEntity entity = new HttpEntity(bodyValTemplate, headers);
                    restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
                    log.info("Thread:{}",threadNum);
                }catch (Exception e){
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                    log.info("count:{}",countDownLatch.getCount());
                }
            });
        }
        countDownLatch.await();
        exec.shutdown();
    }

}
