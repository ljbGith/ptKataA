package com.pillarescent;


import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Scanner;

// ToDo: define exact usage, including how user quits the endless loop when inputting numbers at the console.

public class ArabicRomanIO {

    public final String commandToFinishRunning = "quit";
    protected boolean gotFinishRunningCommand(String line) {
        return line.toLowerCase().equals(commandToFinishRunning.toLowerCase());
    }

    public ArabicRomanIO() {
        scanner = new Scanner(System.in);
        writer = new PrintWriter(System.out);
    }

    public ArabicRomanIO(String inputString, StringWriter output) {
        scanner = new Scanner(inputString);
        writer = new PrintWriter(output);
    }

    public void handleInputs() {
        boolean keepGoing = true;
        while ( keepGoing && scanner.hasNextLine() ) {
            String oneLine = scanner.nextLine();
            if (gotFinishRunningCommand(oneLine)) {
                keepGoing = false;
            }
            else {
                handleLine(oneLine);
            }
        }
    }

    protected void handleLine(String oneLine) {
        RomanNumerals romanNumerals = new RomanNumerals();
        String trimmedLine = oneLine.trim();
        String convertedValue;
        int value;
        try {
            value = Integer.parseInt(trimmedLine);
            convertedValue = romanNumerals.fromArabic(value);
        }
        catch (NumberFormatException numFormatEx) {
            convertedValue = "Error: expected a regular number like 1, 42, or 3999. Instead saw '" + trimmedLine + "'.";
        }
        writer.println(convertedValue);
    }

    protected Scanner scanner;
    protected PrintWriter writer;
}
