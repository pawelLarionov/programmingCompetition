import java.util.Scanner;

public class SolutionDoubleString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputParameter = scanner.nextLine();
        String outputParameter = doubleString(inputParameter);
        System.out.print(outputParameter);
    }


    private static String doubleString(String string) {
        return string + " " + string;
    }
}