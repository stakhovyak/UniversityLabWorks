package labs.tech.lab1;

import java.util.*;

public class FindBiggestString {

    public static void main(String[] args) {
        var in = new Scanner(System.in);
        System.out.println("Enter strings separated by space");
        String input = in.nextLine();
        String[] stringArray = input.split("\\s+");
        System.out.println("The array of strings: " + Arrays.toString(stringArray));
        String longest = Collections.max(Arrays.asList(stringArray), (first, second) ->
            Integer.compare(first.length(), second.length())
        );
        System.out.println("The longest string is: " + longest + "\nIt's length: " + longest.length());
    }
}
