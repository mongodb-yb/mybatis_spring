package com.yubo.test;

import com.yubo.service.UserRedPacketService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author yubo
 * @version V1.0
 * @description
 * @date 2020/4/8 15:59
 */
public class RedPacketTest {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        UserRedPacketService userRedPacketService = applicationContext.getBean(UserRedPacketService.class);
        ExecutorService executorService = Executors.newFixedThreadPool(500);
        CountDownLatch countDownLatch = new CountDownLatch(30000);
        int count = 0;
        for (int i = 0; i < 2500; i++) {
            count++;
            long j = i;
            Runnable runnable = () -> userRedPacketService.insertUserRedPacket(1L, (j + 1));
            executorService.execute(runnable);
            countDownLatch.countDown();
        }
        System.out.println(count);
    }
}
