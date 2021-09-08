/*
 *  UCF COP3330 Fall 2021 Assignment 1 Solution
 *  Copyright 2021 Alejandro Pelaez
 */
package Pelaez.Alejandro;
import java.util.Scanner;

public class App {

    static Scanner input = new Scanner(System.in);
    static boolean inputValid = false;

    public static void main(String[] args)
    {
        System.out.print("Enter a 1 if you are a male or a 2 if you are a female: ");
        int gender = ValidateInput();
        System.out.print("How many ounces of alcohol did you have? ");
        int A = ValidateInput();
        System.out.print("What is your weight, in pounds? ");
        int W = ValidateInput();
        System.out.print("How many hours has it been since your last drink? ");
        int H = ValidateInput();

        float r = gender == 1 ? 0.73f : 0.66f;
        float BAC = (float) ((A * 5.14 / W * r) - .015 * H);

        System.out.println("\nYour BAC is " + BAC);
        if (BAC > 0.08f)
            System.out.println("It is not legal for you to drive.");
        else
            System.out.println("It is legal for you to drive.");
    }

    private static int ValidateInput()
    {
        int value = 0;
        while (!inputValid) {
            String in = input.next();
            try {
                value = Integer.parseInt(in);
                inputValid = true;
            } catch (NumberFormatException e) {
                System.out.print("You didn't enter a valid integer. Please enter a new one: ");
            }
        }
        inputValid = false;
        return value;
    }
}
