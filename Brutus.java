import java.util.Arrays;

public class Brutus {

    static String alphabet = "abcdefghijklmnopqrstuvwxyz";
    static String upperalphabeString ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final double[] english = {
        0.0855, 0.0160, 0.0316, 0.0387, 0.1210, 0.0218, 0.0209, 0.0496, 0.0733,
        0.0022, 0.0081, 0.0421, 0.0253, 0.0717, 0.0747, 0.0207, 0.0010, 0.0633,
        0.0673, 0.0894, 0.0268, 0.0106, 0.0183, 0.0019, 0.0172, 0.0011
    };

 /**
  *  To rotate a single characte
  *
  * @param shift the integer to shift
  * @param ch the character to rotate
  * @return the rotated single character
  */   
    public static char rotate (int shift, char ch){

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
  * @param shift the integer of the given shift
  * @param pText the given plain text as a string
  * @return the cipherText as a string 
  */   
    public static String rotate (int shift, String pText){

        String cText = "";

        for (int i =0;i <pText.length();i++){
            char x = pText.charAt(i);
            char cipher = rotate(shift, x);
            cText = cText + cipher; 
        }
        return cText;
    }

 /**
  * To count the times of character appear in text
  *
  * @param text The string of the given text
  * @return everytime the word appear,add 1 to the array
  */   
    public static int[] count (String text){

        String lowertext = text.toLowerCase();
        int[] arraycount = new int[26]; 
        
        for ( int i = 0; i<lowertext.length(); i++){
            char ch = lowertext.charAt(i);
            if (Character.isLetter(ch)){
                int charIndex = alphabet.indexOf(ch);
    
                arraycount[charIndex] =  arraycount[charIndex] + 1;
            }
        }
        return arraycount;

    }

 /**
 * To compute of the string
 * 
 * @param text The string of the given text
 * @return the value of frequency of character
 */
    public static double[] frequency (String text){
        double[] frequencyCount = new double[26];
        int[] tmp = count(text);
        for ( int i = 0; i<26; i++){
            double x = (float)tmp[i] / (float)text.length();
            frequencyCount[i] = x;
        }
        return frequencyCount;
    }

 /**
 *  To find the value of how close two array are
 * 
 * @param inputFreq * the first double array for the frequency input
 * @param englishFreq * the english frequency given
 * @return the answer of chisquared 
 */
    public static double chiSquared (double[] inputFreq, double[] englishFreq){
        double ans = 0;
        for (int i=0; i < inputFreq.length; i++){
            double tmp = Math.pow((inputFreq[i] - englishFreq[i]), 2.0) / englishFreq[i];
            ans += tmp;
        }
        return ans;
    }

 /**
  * A main method to run the program 
  *
  * @param args argument for parameters
  */   
    public static void main(String[] args){
        if (args.length>1){
            System.out.printf("Too many parameters!\nUsage: java Brutus \"cipher text\" ");
        }
        else if (args.length<1){
            System.out.printf("Too few parameters!\nUsage: java Brutus \"cipher text\"");
        }
        else{

            double low = 1000.00;
            int move = 0;
            for(int i=0; i<26; i++){

                String rotatedString = rotate(i, args[0]);

                double chiScore =  chiSquared(frequency(rotatedString), english);
                if (chiScore < low){
                    low = chiScore;
                    move = i;
                }
            }
    
            System.out.print(rotate(move, args[0]));
            
        }
    }
}
