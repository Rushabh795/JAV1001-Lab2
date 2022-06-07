/*  Student ID           :- A00257629
    Student Name         :- Aman Thakur
                   AND
    Student ID           :- A00240755
    Student Name         :- Rushabh Shah

    Program & Assignment :- MAPD / 
    Program Defination   :- JAV1001-Lab2 Methods And Arrays
    Program Description  :- JAV-1001 - 50733 - App Development for Android - 202205 - 001
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import javax.lang.model.util.ElementScanner6;

// This class contains all the bussiness and functioal logic
public class ArrayTools {
    // Initilased a scanner for input purposes throughout the class
    //
    static Scanner myScanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Called start method to start the program execution
        //
        start();
    }

    // This method is where execution begins
    //
    static void start() {
        // Asking for input whether user wants to do:
        // String Encryption or use Array Tools (Reverse, Average, Find Element)
        //
        System.out.println(
                "Please select an option to perform:- \n1. Caesar Cipher.\n2. Array Tools (Reverse an array, Find average of array elements, Find an element from array).\n3. Exit.");
        int option = myScanner.nextInt();
        if (option == 1) {
            stringCipher();
        } else if (option == 2) {
            arrayTools(true, null);
        } else if (option == 3) {
            // Exit
        } else {
            // In case user enters option which is not present
            //
            System.out.println("Please try again!");
            start();
        }
    }

    // This is asked once user done with one operation
    // Y: asks for more or other operation
    // N: Exit
    static void tryMore() {
        System.out.println("Do you wish to perform more actions? (Y/N)");
        String option = myScanner.next().toUpperCase();
        if (option.equalsIgnoreCase("Y")) {
            start();
        } else {
            // Program Exited
        }
    }

    // This method asks user string input
    //
    static void stringCipher() {
        System.out.println("Please enter string for Caesar cipher");
        String normalString = myScanner.nextLine();
        normalString = myScanner.nextLine();
        System.out.println("Please enter offset");
        int offset = myScanner.nextInt();
        String encryptedString = cypher(normalString, offset);
        System.out.println("Encrypted String is: " + encryptedString);
        tryMore();
    }

    // This method used for array manipulations
    //
    static void arrayTools(boolean myValue, int[] myArr) {
        if (myValue) {
            System.out.println("How many elements you want to enter in the Array?");
            int intUserInput = myScanner.nextInt();
            System.out.println("Pelese Enter " + intUserInput + " elements");
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < intUserInput; i++) {
                int intUserInputArray = myScanner.nextInt();
                list.add(intUserInputArray);
            }
            myArr = convertNow(list);
            actionToPerformOnArray(myArr);
            System.out.println("Array " + Arrays.toString(myArr) + '\n');
        } else {
            actionToPerformOnArray(myArr);
            System.out.println("Array " + Arrays.toString(myArr) + '\n');
        }
    }

    static void actionToPerformOnArray(int[] myArr) {
        System.out.println("What do you want to do with this Array? Please select option" + '\n'
                + "1. Reverse Array." + '\n'
                + "2. Average Array." + '\n'
                + "3. Find element in array.");
        int intUserOptionInput = myScanner.nextInt();
        int[] getconvertArray = myArr;
        switch (intUserOptionInput) {
            case 1:
                // this mehod is used for reverse array
                int[] rev = getReversedArray(myArr);
                System.out.println("Reverse array is " + (Arrays.toString(rev)));
                getConvertmore(getconvertArray);
                break;
            case 2:
                // this mehod is used for getting average from user
                double avg = getAverageFromArray(myArr);
                System.out.println("Average of array is " + avg);
                getConvertmore(getconvertArray);
                break;
            case 3:
                // this mehod is used for chcek value is available or not
                System.out.println("Plese enter the element which you want to find.");
                int getArrayValue = myScanner.nextInt();
                boolean found = findNumber(myArr, getArrayValue);
                if (found) {
                    System.out.println("Element " + getArrayValue + " is found in " + Arrays.toString(myArr));
                    getConvertmore(getconvertArray);
                } else {
                    System.out.println("Element " + getArrayValue + " is not found in " + Arrays.toString(myArr));
                    getConvertmore(getconvertArray);

                }
                break;
            default:
                System.out.println('\n' + "*****************************************");
                System.out.println("Oops..!! Something is going wrong,Let's try again ");
                System.out.println("*****************************************");
                break;
        }
    }

    // This method encrypts string with help of Caesar Cipher
    // Takes string and offset to convert
    //
    public static String cypher(String message, int offset) {
        String result = new String();
        for (char character : message.toCharArray()) {
            if (character != ' ') {
                int originalPos = character - 'a';
                int newPos = (originalPos + offset) % 26;
                char encryptedChar = (char) ('a' + newPos);
                result += encryptedChar;
            } else {
                result += character;
            }
        }
        return result;
    }

    // To find average from array passed to function
    //
    public static double getAverageFromArray(int[] array) {
        int arrayTotal = 0;
        for (int i = 0; i < array.length; i++) {
            arrayTotal += array[i];
        }
        double average = (double) arrayTotal / (double) array.length;
        return average;
    }

    // To find reverse of an array passed to function
    //
    public static int[] getReversedArray(int[] array) {
        int[] reversed = new int[array.length];
        for (int i = array.length; i > 0; i--) {
            reversed[array.length - i] = array[i - 1];
        }
        return reversed;
    }

    // Find an item from the array passed
    // Accepts item from user
    //
    public static boolean findNumber(int[] array, int numberToFind) {
        boolean found = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == numberToFind) {
                found = true;
                break;
            }
        }
        return found;
    }

    // Converts array list to integer array
    //
    public static int[] convertNow(List<Integer> intList) {
        int arr[] = new int[intList.size()];
        Iterator i1 = intList.iterator();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) i1.next();
        }
        return arr;
    }

    // This method asks for more options
    // Such as new array or return to main menu
    //
    static void getConvertmore(int[] myArr) {
        System.out.println('\n' + "=========================================");
        System.out.println("Do you want to countinue with" + '\n'
                + "1. Same Array." + '\n'
                + "2. New Array." + '\n'
                + "3. Return to main menu." + "\n"
                + "4. Exit.");
        int intUserOptionInput = myScanner.nextInt();
        switch (intUserOptionInput) {
            case 1:
                // this mehod is used for calling again with same array
                actionToPerformOnArray(myArr);
                break;
            case 2:
                // this mehod is used for calling again with new array
                arrayTools(true, null);
            case 3:
                start();
            default:
                break;
        }
    }
}
