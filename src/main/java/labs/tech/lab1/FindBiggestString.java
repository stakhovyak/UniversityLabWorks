package labs.tech.lab1;
/**
 * TODO Extract some methods maybe?
 */

import java.util.*;

public class FindBiggestString {

    public static void main(String[] args) {
        var in = new Scanner(System.in);
        System.out.println("Enter strings separated by space");
        String input = in.nextLine();
        String[] stringArray = input.split("\\s+");

        System.out.println("The array of strings: " + Arrays.toString(stringArray));

        String longest = Collections.max(Arrays.asList(stringArray), Comparator.comparingInt(str -> str.length()));

        // Arrays.sort(stringArray, Comparator.comparingInt(str -> str.length()));
        // System.out.println(Arrays.toString(stringArray));

        System.out.println("The longest string is: " + longest + "\nIt's length: " + longest.length());
    }
}
