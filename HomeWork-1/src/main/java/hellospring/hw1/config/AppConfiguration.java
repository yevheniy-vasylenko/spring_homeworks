package hellospring.hw1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.util.concurrent.Executor;

@Configuration
@EnableScheduling
class AppConfiguration {
    @Bean
    public Executor taskScheduler() {
        // use the Spring ThreadPoolTaskScheduler
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        // always set the poolsize
        scheduler.setPoolSize(5);
        // for logging add a threadNamePrefix
        scheduler.setThreadNamePrefix("myTaskScheduler-");
        // wait for completion of the tasks
        scheduler.setWaitForTasksToCompleteOnShutdown(true);
        scheduler.setAwaitTerminationSeconds(3000);

        return scheduler;
    }
}
