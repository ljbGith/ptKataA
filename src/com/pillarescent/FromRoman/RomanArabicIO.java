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
    }

    public RomanArabicIO(String inputString, StringWriter output) {
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

    public boolean isValidRoman() {
        boolean ok = true;
        RomanNumerals romanNumerals = new RomanNumerals();
        if (scanner.hasNextLine()) {
            String nextRomanToCheck = scanner.nextLine();
            ok = romanNumerals.isWellFormedRomanNumeral(nextRomanToCheck);
        }
        return ok;
    }

    protected void handleLine(String oneLine) {
        RomanNumerals romanNumerals = new RomanNumerals();
        String trimmedLine = oneLine.trim();
        if (romanNumerals.isWellFormedRomanNumeral(trimmedLine)) {
            int arabicValue = romanNumerals.toArabic(trimmedLine);
            if (arabicValue < 0) {
                // ToDo: in toArabic, replace return of -1 with throwing an exception in error cases.
                writer.println(badRomanMessage(trimmedLine));
            }
            else {
                writer.println(arabicValue);
            }
        }
        else {
            writer.println(badRomanMessage(trimmedLine));
        }
    }

    protected String badRomanMessage(String input) {
        return "Error: expected a Roman numeral like I, XLII, or MMMCMXCIX. Instead saw '" + input + "'.";
    }

    protected Scanner scanner;
    protected PrintWriter writer;

}
