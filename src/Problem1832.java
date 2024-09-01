import java.util.Arrays;

public class Problem1832 {

    public boolean checkIfPangram(String sentence) {
        boolean[] characters = new boolean[26];

        for(int i = 0; i < sentence.length(); i++){
            char character = sentence.charAt(i);
            if(!characters[character - 'a']){
                characters[character - 'a'] = true;
            }
        }
        for(boolean bool : characters){
            if(!bool){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Problem1832 problem1832 = new Problem1832();
        System.out.println(problem1832.checkIfPangram(
                "leetcode"));
    }

}
