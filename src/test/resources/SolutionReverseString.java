import java.util.Scanner;

public class SolutionReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputParameter = scanner.nextLine();
        String outputParameter = reverseString(inputParameter);
        System.out.print(outputParameter);
    }


    private static String reverseString(String string) {
            int leftPointer = 0;
            int rightPointer = string.length() - 1;

            char[] charArray = string.toCharArray();
            while(rightPointer > leftPointer){
                char temp = charArray[rightPointer];
                charArray[rightPointer] = charArray[leftPointer];
                charArray[leftPointer] = temp;
                leftPointer++;
                rightPointer--;
            }
            return String.valueOf(charArray);
    }
}
