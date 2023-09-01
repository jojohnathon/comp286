import java.util.ArrayList;

public class TestDriver {
    public static void main (String args[]) {

        //initialize an arraylist of Communicators
        ArrayList<Communicator> testList = new ArrayList<Communicator>();

        //add 1 FaxMachine and 2 CellPhones to testList
        testList.add(new FaxMachine(234987));
        testList.add(new CellPhone("Iphone", "steve jobs", 123456789, true));
        testList.add(new CellPhone("Android", "johnathon", 987654321, true));

        //loop through every element in testList and call communicate() on each element
        for (Communicator c : testList) {
            c.communicate();
        }
    }
}
