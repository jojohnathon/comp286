/*
 * Johnathon Zheng
 * 3/18/24
 */


public class mainClass { 
    public static void main (String args[]) {
        int iAnswer = 0;
        int i1 = 10;
        int i2 = 20;
        int i3 = 30;

        double dAnswer = 0;
        double d1 = 1.1;
        double d2 = 2.2;
        double d3 = 3.3;

        iAnswer = i2/i1;
        System.out.println(" iAnswer = i2/i1: " +iAnswer);    // 1) iAnswer = 2, because 20 divided by 10 is 2
        iAnswer = i1/i3; 
        System.out.println(" iAnswer = i1/i3: " + iAnswer );  // 2) iAnswer = 0, because 10 divided by 30 is 0.33 by integer division truncates decimals
        dAnswer = i2/i1;
        System.out.println(" dAnswer = i2/i1: " + dAnswer );  // 3) dAnswer is 2.0, because 20 divided by 10 is 2, and storing into dAnswer makes the integer gets automatically casted into a double
        dAnswer = i1/i2;
        System.out.println(" dAnswer = i1/i2: " + dAnswer );  // 4) output is 0.0 because the integer gets automatically casted into a double
        dAnswer = d1/d2;
        System.out.println( "dAnswer = d1/d2: " + dAnswer );  // 5) output is 0.5 because 2.2 divided by 1.1 is 0.5 and both are doubles so nothing is lost
        iAnswer = i2 / d3;
        System.out.println( "iAnswer = i2/d3: " + dAnswer );  // 6) type error, because the double can't be auto downcast into an integer
        dAnswer = i1/d3;
        System.out.println( "dAnswer = i1/d3: " + dAnswer );  // 7) when dividing integer by a double, the integer gets upcast into a double, so 10.0 / 3.3 = 3.03 repeating
    }
}
