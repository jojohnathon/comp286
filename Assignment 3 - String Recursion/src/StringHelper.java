public class StringHelper {
    public static void main(String[] args) throws Exception {
        String test1 = "aaabbbacccdddeee";
        String test2 = "Hello, World!";
        System.out.println(test1);
        System.out.println(cleanString(test1));
        System.out.println(test2);
        System.out.println(cleanString(test2));
    }

    //recursive method that removes duplicate letters; keeps punctuation the same
    public static String cleanString(String input) {
        //base case
        if (input.length() <= 1) {
            return input;
        }

        char currentChar = input.charAt(0);
        char nextChar = input.charAt(1);
        if (checkChar(currentChar) && (currentChar == nextChar)) { //check for punctuation  //check next character if same
            return cleanString(input.substring(1));
        } else {
            return currentChar + cleanString(input.substring(1));
        }
    }

    //helper method to check if the character is a punctuation
    public static boolean checkChar(char a) {
        if (((a >= 65) && (a <= 90)) || ((a >= 97) && (a <= 122))) { //check ascii table to see if letter
            return true;
        }
        return false;
    }
}
