//Johnathon Zheng
class WarmUp {
    public static void fizzBuzz(int x) {
        if (x % 5 == 0 && x % 3 == 0) {
            System.out.println("Fizz Buzz");
        } else if (x % 3 == 0) {
            System.out.println( "Fizz");
        } else if (x % 5 == 0) {
            System.out.println("Buzz");
        } else {
            System.out.println(x);
        }
    }

    public static void main(String args[]) {
        Integer[] arr = {9, 1, 10, 15};
        for (int x:arr) {
            fizzBuzz(x);
        }
    }
}