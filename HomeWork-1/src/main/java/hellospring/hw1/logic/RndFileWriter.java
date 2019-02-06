package hellospring.hw1.logic;

import hellospring.hw1.data.RndInfo;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class RndFileWriter {
    private static final String OUTPUT_FILE_NAME = "rnd.txt";
    private static Path fullOutputFileName;

    @PostConstruct
    public void init() {
        fullOutputFileName = Paths.get(System.getProperty("java.io.tmpdir"), OUTPUT_FILE_NAME);
        System.out.println(String.format("%s will print the output to file: %s",
                this.getClass().getSimpleName(), fullOutputFileName));

        deleteIfExists(fullOutputFileName);
    }

    @EventListener
    @Async
    public void writeToFileAsync(RndInfo rndInfo) {
        appendFile(String.format("%s %s", rndInfo.getDate().toString(), rndInfo.getNumber()));
    }

    private void appendFile(String message) {
        try(PrintWriter writer = new PrintWriter(new FileWriter(fullOutputFileName.toString(), true))) {
            writer.println(message);
        }
        catch(IOException e) {
            System.err.println(e);
        }
    }

    private void deleteIfExists(Path fullFileNamePath) {
        if (Files.exists(fullFileNamePath)) {
            try {
                Files.delete(fullFileNamePath);
            }
            catch(IOException e) {
                System.err.println(e);
            }
        }
    }
}
