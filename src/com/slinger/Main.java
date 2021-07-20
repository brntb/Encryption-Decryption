package com.slinger;

public class Main {

    public static void main(String[] args) {
        Controller controller = new Controller();

        if (args.length == 0) {
            printHelpOptions();
        } else {
            runProgramWithArguments(controller, args);
        }

    }

    private static void runProgramWithArguments(Controller controller, String[] args) {
        String mode = "enc";
        int key = 0;
        String data = "";
        String inputFile = "";
        String outputFile = "";
        String algorithm = "shift";

        for (int i = 0; i < args.length; i += 2) {
            if ("-mode".equals(args[i])) {
                mode = args[i + 1];
            } else if ("-key".equals(args[i])) {
                if (!args[i + 1].matches("[0-9]+")) {
                    System.out.println("Error! Key must be whole number. Program will start with key set to 0");
                } else {
                    key = Integer.parseInt(args[i + 1]);
                }
            } else if ("-data".equals(args[i])) {
                data = args[i + 1];
            } else if ("-in".equals(args[i])) {
                inputFile = args[i + 1];
            } else if ("-out".equals(args[i])) {
                outputFile = args[i + 1];
            } else if ("-alg".equals(args[i])) {
                algorithm = args[i + 1];
            }
        }

        controller.runWithArguments(mode, key, data, inputFile, outputFile, algorithm);
    }

    private static void printHelpOptions() {
        System.out.println("ERROR! This app only runs with passed arguments! Valid options are: ");
        System.out.println("-mode with enc/dec");
        System.out.println("-in with file name to read from");
        System.out.println("-out with file name to write to");
        System.out.println("-key with integer to shift characters");
        System.out.println("-alg with shift/unicode");
        System.out.println("\nEXAMPLES:");
        System.out.println("java Main -mode enc -in road_to_treasure.txt -out protected.txt -key 5 -alg unicode");
        System.out.println("java Main -mode enc -key 5 -data \"Hello World!\" -alg unicode");
        System.out.println("NOTE: Order does not matter!");
    }

}
