import java.util.Arrays;

public class ArrayTools {
    public static void main(String[] args) {
        int[] myArr = { 1, 2, 4, 5 };
        int[] rev = getReversedArray(myArr);
        double avg = getAverageFromArray(myArr);
        System.out.println(Arrays.toString(rev));
        System.out.println(avg);
        boolean found = findNumber(myArr, 3);
        System.out.println(found);

        String result = cypher("This is ^ aman", 2);
        System.out.println(result);
        String decyp = cypher("Vjku ku ` cocp", -2);
        System.out.println(decyp);
    }

    void tools() {

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
}