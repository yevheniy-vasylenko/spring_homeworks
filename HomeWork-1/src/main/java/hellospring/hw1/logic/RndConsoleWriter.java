package hellospring.hw1.logic;

import hellospring.hw1.data.RndInfo;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class RndConsoleWriter {

    @EventListener
    public void writeToConsole(RndInfo rndInfo) {
        System.out.println(String.format("Rnd: %s %s",
                rndInfo.getDate().toString(), rndInfo.getNumber()));
    }
}
