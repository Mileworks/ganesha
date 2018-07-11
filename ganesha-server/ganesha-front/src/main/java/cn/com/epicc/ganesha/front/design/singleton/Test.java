package cn.com.epicc.ganesha.front.design.singleton;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Description:
 * Author: lishangmin
 * Created: 2018-07-09 14:12
 */
public class Test {

    private static int threadCount = 100;

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        for(int i =0 ; i < threadCount ; i++) {
            executorService.execute(() -> {
                try {
                    King.getInstance2().say();
                }finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        executorService.shutdown();
    }
}
