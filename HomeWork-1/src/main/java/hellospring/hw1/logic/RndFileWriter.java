package hellospring.hw1.logic;

import hellospring.hw1.data.RndInfo;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class RndFileWriter {
    private static final String OUTPUT_FILE_NAME = "rnd.txt";

    private PrintWriter writer;

    @PostConstruct
    public void init() {
        Path fullOutputFileName = Paths.get(System.getProperty("java.io.tmpdir"), OUTPUT_FILE_NAME);
        System.out.println(String.format("%s will print the output to file: %s",
                this.getClass().getSimpleName(), fullOutputFileName));

        try {
            System.out.println("Opening file...");
            writer = new PrintWriter(new FileWriter(fullOutputFileName.toString(), false));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (writer == null) {
            System.err.println("Failed to create output file");
        }
    }

    @PreDestroy
    public void destroy() {
        if (writer != null) {
            System.out.println("Closing file...");
            writer.close();
        }
    }

    @EventListener
    @Async
    public void writeToFileAsync(RndInfo rndInfo) {
        appendFile(String.format("%s %s", rndInfo.getDate().toString(), rndInfo.getNumber()));
    }

    private void appendFile(String message) {
        if (writer != null) {
            writer.println(message);
        }
    }
}
