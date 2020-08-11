import java.util.Scanner;

public class Crypto {
    public static void main(String[] args) {
        String t = " ";
        Scanner input = new Scanner(System.in);

        System.out.print("Please Type in your Text : ");
        String s = input.nextLine();
        System.out.println(t = normalizeText(s));

        System.out.print("Enter shift Value: ");
        int sValue = input.nextInt();
        System.out.println(t = ceaserify(t,sValue));

        System.out.print("Enter Size of each group of letters: ");
        int numGroup = input.nextInt();
        String groupedCode = groupify(t,numGroup);
        System.out.println(groupedCode);

        System.out.println("Encrypting your text......");
        String encrypted = encryptString(s, sValue, numGroup);
        System.out.println(encrypted);
        System.out.println("Encryption finished.....");

        System.out.println("--------------------------------------------------");

        System.out.println("Degrouping.......");
        System.out.println(ungroupify(groupedCode));

        System.out.println("Decrypting......");
        System.out.println("Decrypting Finished....");
        System.out.println(decrypt(encrypted, sValue));


    }
    public static String normalizeText(String s) {
        String temp = "";
        temp = s.replaceAll("[\\s.,:;'!?()\"]", "");
        temp = temp.toUpperCase();
        return temp;
    }
    public static String ceaserify(String t, int shift) {
        String temp = "";
        for ( int i = 0; i < t.length(); i++) {
            int charNum = 0;
            charNum = (int) t.charAt(i);
            charNum += shift;
            if(charNum < ((int) 'A')) {
                charNum += 26;
            } else if (charNum > ((int) 'Z')) {
                charNum -= 26;
            }
            temp += ((char) charNum);
        }
        return temp;
    }
    public static String groupify(String t , int numGroup) {
        String temp = "";
        for (int i = 0; i < t.length(); i++ ) {
            if( i % numGroup == 0 && i != 0) {
                temp = temp + " ";
            }
            temp = temp + t.charAt(i);
        }
        int count = 0;
        for (int i = temp.lastIndexOf(" "); i < temp.length(); i++) {
            ++count;
        }
        for ( int i = numGroup - count; i >= 0; i--) {
            temp += "x";
        }
        return temp;
    }
    public static String encryptString(String t, int sValue, int numGroup) {
        String temp = "";
        temp = normalizeText(t);
        temp = ceaserify(temp, sValue);
        temp = groupify(temp, numGroup);
        return temp;
    }
    public static String ungroupify(String s) {
        String temp = s.replaceAll(" ", "");
        temp = temp.replaceAll("x", "");
        return temp;
    }
    public static String decrypt(String t , int shift) {
        t = t.replaceAll(" ", "");
        t = t.replaceAll("x", "");
        String temp = "";
        for ( int i = 0; i < t.length(); i++) {
            int charNum = 0;
            charNum = (int) t.charAt(i);
            charNum -= shift;
            if(charNum < ((int) 'A')) {
                charNum += 26;
            } else if (charNum > ((int) 'Z')) {
                charNum -= 26;
            }
            temp += ((char) charNum);
        }
        return temp;
    }
}
