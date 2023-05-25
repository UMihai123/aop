package Audit;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Log {
    private String filePath;

    public Log(String filePath) {
        this.filePath = filePath;
    }

    public void writeStringToCSV(String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(content);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
