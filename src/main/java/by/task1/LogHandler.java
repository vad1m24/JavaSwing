package main.java.by.task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class LogHandler {
    private File logFile;

    LogHandler(String fileName) throws IOException{
        logFile = new File(fileName);
        if (! logFile.exists()) {
            this.logFile.createNewFile();
        }
    }

    public List<String> Read() throws IOException{
        BufferedReader fileStream = new BufferedReader(new FileReader(this.logFile));
        List<String> lines = (fileStream.lines().collect(Collectors.toList()));
        fileStream.close();
        return lines;
    }

    public void Write(String argLine) throws IOException{
        BufferedReader tempReader = new BufferedReader(new FileReader(this.logFile));
        List<String> lines = (tempReader.lines().collect(Collectors.toList()));
        BufferedWriter fileStream = new BufferedWriter(new FileWriter(this.logFile));
        for (String line : lines) {
            fileStream.append(line);
            fileStream.newLine();
        }
        fileStream.write(argLine);
        fileStream.newLine();
        fileStream.flush();
        fileStream.close();
        tempReader.close();
    }
}
