package com.pillarescent.FromRoman;

import com.pillarescent.CommonRoman.RomanNumerals;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Scanner;

public class RomanArabicIO {

    public final String commandToFinishRunning = "quit";
    protected boolean gotFinishRunningCommand(String line) {
        return line.toLowerCase().equals(commandToFinishRunning.toLowerCase());
    }

    public RomanArabicIO() {
        scanner = new Scanner(System.in);
        writer = new PrintWriter(System.out);
        prompt = "Enter a Roman numeral to see the equivalent number. Enter 'quit' when done.";
    }

    public RomanArabicIO(String inputString, StringWriter output) {
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
        int arabicValue = RomanNumerals.toArabic(trimmedLine);
        if (arabicValue < 0) {
            // ToDo: in toArabic, replace return of -1 with throwing an exception in error cases.
            writer.println(badRomanMessage(trimmedLine));
        }
        else {
            writer.println(arabicValue);
        }
        writer.flush();
    }

    protected String badRomanMessage(String input) {
        return "Error: expected a Roman numeral like I, XLII, or MMMCMXCIX. Instead saw '" + input + "'.";
    }

    protected Scanner scanner;
    protected PrintWriter writer;
    protected String prompt = "";

}
