package hellospring.hw1.logic;

import hellospring.hw1.data.RndInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Random;

@Component
public class RndGenerator {
    @Autowired
    private ApplicationEventPublisher publisher;

    private Random random = new Random();

    @Scheduled(initialDelay = 1000, fixedRate = 1000)
    public void sec() {
        int numberToPublish = random.nextInt(100);
        RndInfo rndInfo = new RndInfo(new Date(), numberToPublish);
        System.out.println("Publishing element: " + rndInfo);
        publisher.publishEvent(rndInfo);
    }
}
