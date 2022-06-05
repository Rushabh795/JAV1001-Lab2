/*  Student ID           :- A00240755
    Student Name         :- Rushabh Shah
    Program & Assignment :- MAPD / 
    Program Defination   :- 
    Program Description  :-  */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.lang.model.util.ElementScanner6;

public class ArrayTools {
    
    public static void main(String[] args) {            
      tools(true,null);
    }

   static void tools(boolean myValue , int [] myArr) {
        if(myValue){

            System.out.println("How many elements you want to enter in the Array ?");
            Scanner getElementNumber = new Scanner(System.in);        int intUserInput = getElementNumber.nextInt();
            System.out.println("Pelese Enter " + intUserInput + " elements"); 
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0 ; i < intUserInput; i++) {
                Scanner getElementArray = new Scanner(System.in);
                int intUserInputArray = getElementArray.nextInt();
                list.add(intUserInputArray);
            }
            myArr = convertNow(list);
                cal(myArr);
                System.out.println("Array " +Arrays.toString(myArr)+ '\n');
            }else{
                cal(myArr);
                System.out.println("Array " +Arrays.toString(myArr)+ '\n');
            }
    }

    static void cal (int [] myArr) {
        System.out.println("What do you want to do with this Aray ? Please select option" + '\n' 
        +"1. Reverse Array." + '\n'
        + "2. Average Array."+'\n'
        + "3. Find element in array.");      
        Scanner getOption = new Scanner(System.in);
        int intUserOptionInput = getOption.nextInt();
        int[] getconvertArray = myArr;
            switch (intUserOptionInput) {
                        case 1:
                            //   this mehod is used for reverse array
                        
                            int[] rev = getReversedArray(myArr);
                            System.out.println("Reverse array is " +(Arrays.toString(rev)));
                            getConvertmore(getconvertArray);
                            break;

                            case 2:
                            // this mehod is used for getting average from user
                            double avg = getAverageFromArray(myArr);
                            System.out.println("Average of array is " +avg);
                            getConvertmore(getconvertArray);

                            case 3:
                            // this mehod is used for chcek value is available or not
                            System.out.println("Plese enter the element which you want to find.");
                            Scanner getValue = new Scanner(System.in);
                            int getArrayValue = getValue.nextInt();

                            boolean found = findNumber(myArr, getArrayValue);         
                            if(found)
                            {
                                System.out.println("Element " + getArrayValue + " is found in " +Arrays.toString(myArr));
                                getConvertmore(getconvertArray);
                            }else{
                                System.out.println("Element " + getArrayValue + "is not found in " + Arrays.toString(myArr));
                                getConvertmore(getconvertArray);

                            }

                            break;
                            default:
                            System.out.println('\n' + "*****************************************");
                            System.out.println("Oops..!! Something is going wrong,Let's try again ");
                            System.out.println("*****************************************");
                        }
    }   
  
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

    public static double getAverageFromArray(int[] array) {
        int arrayTotal = 0;
        for (int i = 0; i < array.length; i++) {
            arrayTotal += array[i];
        }
        double average = (double) arrayTotal / (double) array.length;
        return average;
    }

    public static int[] getReversedArray(int[] array) {
        int[] reversed = new int[array.length];
        for (int i = array.length; i > 0; i--) {
            reversed[array.length - i] = array[i - 1];
        }
        return reversed;
    }

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

   public static int [] convertNow(List<Integer> intList)
   {
        int arr [] = new int [intList.size()];
        Iterator i1 = intList.iterator();
            for (int i = 0 ; i < arr.length ; i++){
                    arr[i] =(int)  i1.next();
            }
            return arr;
}
  
static void getConvertmore(int [] myArr) {
    System.out.println('\n' + "=========================================");
    System.out.println("Do you want to countinue with" + '\n' 
    +"1. Same Array." + '\n'
    + "2. New Array."+'\n'
    + "3. Exit.");        
    Scanner getOption = new Scanner(System.in);
    int intUserOptionInput = getOption.nextInt();
        switch (intUserOptionInput) {
            case 1:
                //   this mehod is used for calling again with same array
                cal(myArr);
                break;

                case 2:
                tools(true , null);
                //  this mehod is used for calling again with new array
                default:
                break;
            }
}
}
