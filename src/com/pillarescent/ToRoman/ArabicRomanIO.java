package com.pillarescent.ToRoman;


import com.pillarescent.CommonRoman.RomanNumerals;

import java.io.PrintWriter;
import java.io.StringWriter;
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
        prompt = "Enter a regular number to see the Roman numeral equivalent. Enter 'quit' when done.";
    }

    public ArabicRomanIO(String inputString, StringWriter output) {
        scanner = new Scanner(inputString);
        writer = new PrintWriter(output);
        prompt = "";
    }

    public void handleInputs() {
        if ( ! prompt.isEmpty() ) {
            writer.println(prompt);
            writer.flush();
        }
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
        String trimmedLine = oneLine.trim();
        String convertedValue;
        int value;
        try {
            value = Integer.parseInt(trimmedLine);
            convertedValue = RomanNumerals.fromArabic(value);
        }
        catch (NumberFormatException numFormatEx) {
            convertedValue = "Error: expected a regular number like 1, 42, or 3999. Instead saw '" + trimmedLine + "'.";
        }
        writer.println(convertedValue);
        writer.flush();
    }

    protected Scanner scanner;
    protected PrintWriter writer;
    protected String prompt;
}
