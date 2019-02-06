package hellospring.hw1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;

@Configuration
@ComponentScan
class Application {

    public static void main(String[] args) {
        try(AbstractApplicationContext context = new AnnotationConfigApplicationContext(Application.class)) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println("Main: interrupted");
            }
        }
    }
}
