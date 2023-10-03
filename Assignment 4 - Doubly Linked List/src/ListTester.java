import java.util.List;

public class ListTester{
	public static void main(String[] args) {

		System.out.println();

		System.out.println("Testing doubly linked list...");
		DLinkedList<Integer> numberList = new DLinkedList<>();
		testListWithIntegers(numberList);

		DLinkedList<String> strList = new DLinkedList<>();
		testListWithStrings(strList);
		System.out.println("...end of double link tests");

	}

	public static void testListWithIntegers(List<Integer> numList){
		numList.add(12);
		numList.add(3);
		numList.add(0, 15);

		try {
			numList.add(5, 45);
			System.out.println("ERROR - exception missed");
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Correctly caught add out of bounds exception");
		}

		System.out.println(numList);
		System.out.println("Expected list: 15, 12, 3");

		System.out.println();
	}

	public static void testListWithStrings(List<String> wordList){

		wordList.add("house");
		wordList.add("window");
		wordList.add("door");
		wordList.add(1, "roof");

		if ( wordList.size() != 4 ){
			System.out.println("ERROR - incorrect size");
		}

		System.out.println(wordList);
		System.out.println("Expected list: house, roof, window, door");

		String test = wordList.get(2);
		if ( !test.equals("window")){
			System.out.println("Error - Unexpected element at index 2");
		}
		
		System.out.println(wordList);
		System.out.println("Expected list: house, roof, window, door");

	}
}