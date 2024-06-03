
public class Caesar {

    static String alphabet = "abcdefghijklmnopqrstuvwxyz";
    static String upperalphabeString ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";

/**
 * To rotate a single character 
 * 
 * This is done by checking if the input is a character,then
 * if the character is lower case, find the index of character in the alphabet and add the shift 
 * 
 * @param shift the integer to shift
 * @param ch the character to rotate
 * @return the rotated single character
 */    
    public static char rotate(int shift, char ch){

        if (Character.isLetter(ch) == false){
            return ch;
        }
        char cipherChar;

        if (Character.isLowerCase(ch)){
            int charIndex = alphabet.indexOf(ch);
            int newIndex = (charIndex + shift)%26;
            if (newIndex<0){
                newIndex = newIndex + 26;}
            cipherChar = alphabet.charAt(newIndex); 
        

        }
        else {
            int charIndex = upperalphabeString.indexOf(ch);
            int newIndex = (charIndex + shift)%26;
            if (newIndex<0){
                newIndex = newIndex + 26;}
            cipherChar = upperalphabeString.charAt(newIndex);

        }
        return cipherChar;
    }
    
 /**
  * To rotate the whole string by the given shift
  *
  * This is done by knowing the ptext character,then
  * use the method rotate from above to rotate whole string and add it to cText
  *
  * @param shift the integer of the given shift
  * @param pText the given plain text as a string
  * @return the cipherText as a string 
  */   
    public static String rotate(int shift,String pText){

        String cText = "";

        for (int i =0;i <pText.length();i++){
            char x = pText.charAt(i);
            char cipher = rotate(shift, x);
            cText = cText + cipher; 
        }
        return cText;
    }
    

/**
 * A main method to run the program
 * 
 * @param args arguments for parameters
 */   
     public static void main(String[] args){
    if (args.length>2){
        System.out.printf("Too many parameters!\nUsage: java Caesar n \"cipher text\" ");
    }
    else if (args.length<2){
        System.out.printf("Too few parameters!\nUsage: java Caesar n \"cipher text\"");
    }
    else{

        System.out.print(rotate(Integer.parseInt(args[0]), args[1]));   
    }
}
}
