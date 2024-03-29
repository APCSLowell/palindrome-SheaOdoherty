import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class PalindromeChecker {
public void tester()
{
  //String lines[] = loadStrings("palindromes.txt");
  String[] lines = new String[6]; 
    try{
        File myFile = new File("palindromes.txt");
        Scanner myReader = new Scanner(myFile);
        int counter = 0;
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            lines[counter] = data;
            counter++;
        }
        myReader.close();
    }
    catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
    }
}
public boolean palindrome(String word) {
    String baseWord = onlyLetters(noCapitals(noSpaces(word))); 
    String reversedWord = reverse(baseWord);
    return baseWord.equals(reversedWord);
}
public String reverse(String str) {
    String sNew = new String();
    for (int i = str.length(); i > 0; i--) {
        sNew = sNew + str.substring(i - 1, i); 
    }
    return sNew;
}
public String noCapitals(String word){
  String lWord = "";
  String temp ="";
  for(int i=0; i <word.length(); i ++){
    temp = word.substring(i,i+1);
    temp = temp.toLowerCase();
    lWord = lWord + temp;
  }
  return lWord;
}
public String noSpaces(String word){
  String noSpace= "";
  for( int i =0; i < word.length(); i ++){
    if(word.substring(i,i+1).equals(" ")){
    }else{
      noSpace = noSpace + word.substring(i,i+1);
    }
  }
  return noSpace;
}
public String onlyLetters(String sString){
  String theWord = "";
  for (int i = 0 ; i < sString.length(); i ++){
    if(Character.isLetter(sString.charAt(i))){
      theWord = theWord + sString.substring(i, i+1);
   }
  }
  return theWord;
}
}
