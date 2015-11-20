import java.util.Arrays;

/**
 * Created by Alexander Kovalevsky on 19.11.2015.
 */
public class WordPlay {
    public boolean isVowel(char ch) {
        return ch == 'a' || ch == 'A' ||
                ch == 'e' || ch == 'E' ||
                ch == 'i' || ch == 'I' ||
                ch == 'o' || ch == 'O' ||
                ch == 'u' || ch == 'U';
    }

    public String replaceVowels(String phrase, char ch) {
        char[] chars = phrase.toCharArray();
        String result = "";
        for (char aChar : chars) {
            if (isVowel(aChar)) {
                result += "*";
            } else result += aChar;
        }
        return result;
    }

    public String emphasize (String phrase, char ch) {
        char[] chars = phrase.toCharArray();
        String result = "";
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ch || Character.toLowerCase(chars[i]) == ch) {
                if (i%2 == 0) {
                    result += "*";
                } else result += "+";
            } else result += chars[i];
        }
        return result;
    }
}
