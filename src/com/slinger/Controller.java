package com.slinger;

import com.slinger.algorithms.*;

public class Controller {

    private final DataController dataController;

    public Controller() {
        this.dataController = new DataController();
    }

    public void runWithArguments(String mode, int key, String data, String inputFile, String outputFile, String algorithm) {
        //create context
        AlgorithmContext algorithmContext = new AlgorithmContext();

        //check if data is coming from a file
        if (data.isEmpty() && !inputFile.isEmpty()) {
            data = dataController.readFileAsString(inputFile);
        }

        //set encryption/decryption algorithm to use
        if ("unicode".equals(algorithm)) {
            algorithmContext.setEncryption(new UnicodeEncryption());
            algorithmContext.setDecryption(new UnicodeDecryption());
        } else {
            algorithmContext.setEncryption(new ShiftEncryption());
            algorithmContext.setDecryption(new ShiftDecryption());
        }

        //now actually encrypt/decrypt the data
        String result = "";

        if (mode.equals("enc")) {
            result = algorithmContext.encrypt(data, key);
        } else if (mode.equals("dec")) {
            result = algorithmContext.decrypt(data, key);
        }

        //check if we need to save result to file or just print result to console
        if (!outputFile.isEmpty()) {
            dataController.saveToFile(outputFile, result);
        } else {
            System.out.println(result);
        }
    }
}
