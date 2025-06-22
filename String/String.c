#include <stdio.h>
#include <string.h>
#include <ctype.h>

// Convert string to uppercase
void toUpperCase(char str[]) {
    for (int i = 0; str[i] != '\0'; i++) {
        str[i] = toupper(str[i]);
    }
}

// Convert string to lowercase
void toLowerCase(char str[]) {
    for (int i = 0; str[i] != '\0'; i++) {
        str[i] = tolower(str[i]);
    }
}

// Reverse string (swapping)
void reverseString(char str[]) {
    int len = strlen(str);
    for (int i = 0; i < len / 2; i++) {
        char temp = str[i];
        str[i] = str[len - 1 - i];
        str[len - 1 - i] = temp;
    }
}

int main() {
    char str1[100], str2[100];
    int choice;

    while (1) {
        printf("\n--- String Operations ---\n");
        printf("1. strlen\n2. strcpy\n3. strcat\n4. strcmp\n5. To Uppercase\n6. To Lowercase\n7. Reverse\n8. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        if (choice == 8) {
            break;
        }

        switch (choice) {
            case 1:
                printf("Enter a string: ");
                scanf("%s", str1);
                printf("Length = %lu\n", strlen(str1));
                break;

            case 2:
                printf("Enter source string: ");
                scanf("%s", str2);
                strcpy(str1, str2);
                printf("Copied string: %s\n", str1);
                break;

            case 3:
                printf("Enter first string: ");
                scanf("%s", str1);
                printf("Enter second string: ");
                scanf("%s", str2);
                strcat(str1, str2);
                printf("Concatenated string: %s\n", str1);
                break;

            case 4:
                printf("Enter first string: ");
                scanf("%s", str1);
                printf("Enter second string: ");
                scanf("%s", str2);
                if (strcmp(str1, str2) == 0) {
                    printf("Strings are equal.\n");
                } else {
                    printf("Strings are not equal.\n");
                }
                break;

            case 5:
                printf("Enter a string: ");
                scanf("%s", str1);
                toUpperCase(str1);
                printf("Uppercase: %s\n", str1);
                break;

            case 6:
                printf("Enter a string: ");
                scanf("%s", str1);
                toLowerCase(str1);
                printf("Lowercase: %s\n", str1);
                break;

            case 7:
                printf("Enter a string: ");
                scanf("%s", str1);
                reverseString(str1);
                printf("Reversed: %s\n", str1);
                break;

            default:
                printf("Invalid choice.\n");
        }
    }

    return 0;
}
