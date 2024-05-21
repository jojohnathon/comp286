/*
 * Even odd class
 */

public class VowelConsonant {

   public VowelConsonant() {

   }

   public void isConsonant(char ch) {
      if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
         System.out.println(ch + " is a vowel");
      } else {
         System.out.println(ch + " is a consonant");
      }
   }
}