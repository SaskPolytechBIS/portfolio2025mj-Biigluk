/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Recursion;

/**
 *
 * @author ibrah
 */
public class RecursionDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //RULES OF RECURSION
        //1. Method must call itself
        //2.There must be a base case
        System.out.println("sum:" + sumall(5));
        System.out.println("Factorial: " + factorial(5));
        System.out.println("Power: " + myPow(2, 3));
        System.out.println("Pallindrome: " + isPalindrome("racecar"));
        indentoTron(5);
    }

    public static int sumall(int n) {
        if (n == 1) {
            return n;
        } else {
            return n + sumall(n - 1);
        }
    }

    public static int factorial(int n) {
        if (n == 1) {
            return n;
        } else {
            return n * factorial(n - 1);
        }

    }

    public static int myPow(int a, int b) {
        if (b == 0) {
            return 1;
        } else if (b == 1) {
            return a;

        } else {
            return a * myPow(a, b - 1);
        }
    }

    public static boolean isPalindrome(String s, int start, int end) {

        if (s.charAt(start) != s.charAt(end)) {
            return false;
        } else if (start > end) {
            return true;
        } else {
            return (isPalindrome(s, start + 1, end - 1));
        }
    }

    public static boolean isPalindrome(String s) {
        return (isPalindrome(s, 0, s.length() - 1));
    }

    public static void indentoTron(int n) {
        indentoTron(n, 1);
    }

    public static void indentoTron(int n, int i) {
        if (i > n) {
            return;
        } else {
            printSpaces(i);
            System.out.println("This was written by call number" + i);
            indentoTron(n, i + 1);
            printSpaces(i);

            System.out.println(" This two also written by call number" + i);

        }
    }

    public static void printSpaces(int spaces) {
        if (spaces == 0) {
            return;
        } else {
            System.out.print(" ");
            printSpaces(spaces - 1);
        }
    }
}
