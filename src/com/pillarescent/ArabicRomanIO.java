package com.pillarescent;


import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Scanner;

// ToDo: define exact usage, including how user quits the endless loop when inputting numbers at the console.

public class ArabicRomanIO {

    public ArabicRomanIO() {
        scanner = new Scanner(System.in);
        writer = new PrintWriter(System.out);
    }

    public ArabicRomanIO(String inputString) {
        scanner = new Scanner(inputString);
        writer = new PrintWriter(System.out);
    }

    public ArabicRomanIO(String inputString, StringWriter output) {
        scanner = new Scanner(inputString);
        writer = new PrintWriter(output);
    }

    public void handleInputs() {
        RomanNumerals romanNumerals = new RomanNumerals();
        while (scanner.hasNextLine()) {
            String oneLine = scanner.nextLine();
            String trimmedLine = oneLine.trim();
            writer.println(trimmedLine);
        }
    }

    protected Scanner scanner;
    protected PrintWriter writer;
}
