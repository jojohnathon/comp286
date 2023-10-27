import java.util.HashMap;
import java.util.Map;

public class PracticeHashMap {
    public static void main(String[] args) throws Exception {
        HashMap<String, String> Dictionary = new HashMap<>();
        Dictionary.put("algorithm", "a process or set of rules to be followed in calculations or other problem-solving operations, especially by a computer.");
        Dictionary.put("computer", "an electronic device for storing and processing data, typically in binary form, according to instructions given to it in a variable program.");
        Dictionary.put("binary", "relating to, composed of, or involving two things.");
        Dictionary.put("house", "a building for human habitation, especially one that is lived in by a family or small group of people.");
        Dictionary.forEach((k, v) -> System.out.println(k + ": " + v)) ;

        HashMap<String, HashMap<String, String>> languageDictionary = new HashMap<>();
        languageDictionary.put("English", Dictionary);
        HashMap<String, String> notEnglish = new HashMap<>();
        notEnglish.put("二进制", "与两件事有关、由两件事组成或涉及两件事。");
        languageDictionary.put("Chinese", notEnglish);


    }
}
