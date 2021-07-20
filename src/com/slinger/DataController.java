package com.slinger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DataController {

    public void saveToFile(String fileName, String data) {
        File file = new File(fileName);

        try (FileWriter writer = new FileWriter(file)) {
            writer.write(data);
        } catch (IOException e) {
            System.out.printf("An exception occurs %s", e.getMessage());
        }
    }

    public String readFileAsString(String fileName) {
        String data = "";

        try {
            data = new String(Files.readAllBytes(Paths.get(fileName)));
        } catch (IOException e) {
            System.out.println("No file found with name " + fileName + "!");
        }

        return data;
    }


}
