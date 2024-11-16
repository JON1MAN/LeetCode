package Java;

public class Problem243 {

    public int shortestDistance(String[] words, String word1, String word2){
        int result = Integer.MAX_VALUE;
        int first = -1;
        int second = -1;
        for(int i = 0; i < words.length; i++){
            if(words[i].equals(word1)){
                first = i;
            }
            if (words[i].equals(word2)){
                second = i;
            }
            if(first != -1 && second != -1){
                result = Math.min(second - first, result);
            }
        }

        return result;
    }

}
