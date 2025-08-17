import java.util.Scanner;

public class StringOperations {

    // Convert string to uppercase
    public static String toUpperCase(String str) {
        return str.toUpperCase();
    }

    // Convert string to lowercase
    public static String toLowerCase(String str) {
        return str.toLowerCase();
    }

    // Reverse string
    public static String reverseString(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = "", str2 = "";
        int choice;

        while (true) {
            System.out.println("\n--- String Operations ---");
            System.out.println("1. strlen");
            System.out.println("2. strcpy");
            System.out.println("3. strcat");
            System.out.println("4. strcmp");
            System.out.println("5. To Uppercase");
            System.out.println("6. To Lowercase");
            System.out.println("7. Reverse");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            if (choice == 8) {
                break;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter a string: ");
                    str1 = sc.nextLine();
                    System.out.println("Length = " + str1.length());
                    break;

                case 2:
                    System.out.print("Enter source string: ");
                    str2 = sc.nextLine();
                    str1 = str2;  // copy
                    System.out.println("Copied string: " + str1);
                    break;

                case 3:
                    System.out.print("Enter first string: ");
                    str1 = sc.nextLine();
                    System.out.print("Enter second string: ");
                    str2 = sc.nextLine();
                    str1 = str1 + str2;
                    System.out.println("Concatenated string: " + str1);
                    break;

                case 4:
                    System.out.print("Enter first string: ");
                    str1 = sc.nextLine();
                    System.out.print("Enter second string: ");
                    str2 = sc.nextLine();
                    if (str1.equals(str2)) {
                        System.out.println("Strings are equal.");
                    } else {
                        System.out.println("Strings are not equal.");
                    }
                    break;

                case 5:
                    System.out.print("Enter a string: ");
                    str1 = sc.nextLine();
                    System.out.println("Uppercase: " + toUpperCase(str1));
                    break;

                case 6:
                    System.out.print("Enter a string: ");
                    str1 = sc.nextLine();
                    System.out.println("Lowercase: " + toLowerCase(str1));
                    break;

                case 7:
                    System.out.print("Enter a string: ");
                    str1 = sc.nextLine();
                    System.out.println("Reversed: " + reverseString(str1));
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
        sc.close();
    }
}
