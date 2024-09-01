/*In this approach I am using two pointers pattern,*/
/*we can go both form start and end of string*/
/*in loop we check */
/*        if vowels has character of string[left] if not left++*/
/*        then same for right pointer*/
/*        at the end performing swapping*/

public class Problem345 {

    public String reverseVowels(String s) {
        char[] string = s.toCharArray();
        String vowels = "aeiouUOIEA";

        int left = 0;
        int right = s.length() - 1;
        while(left < right){
            while(left < right && vowels.indexOf(string[left]) == -1){
                left++;
            }

            while(left < right && vowels.indexOf(string[right]) == -1){
                right--;
            }

            char temp = string[left];
            string[left] = string[right];
            string[right] = temp;

            left++;
            right--;
        }

        return new String(string);
    }

    public static void main(String[] args) {
        Problem345 problem345 = new Problem345();
        System.out.println(problem345.reverseVowels("hello"));
    }

}
