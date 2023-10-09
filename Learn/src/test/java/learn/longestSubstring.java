package learn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class longestSubstring {

    public static int lengthOfLongestSubStringWithoutRepeatingCharacterWithMap(String str) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int n = str.length();
        int len = 0;
        while (right < n) {
            if (map.containsKey(str.charAt(right)))
                left = Math.max(map.get(str.charAt(right)) + 1, left);

            map.put(str.charAt(right), right);
            len = Math.max(len, right - left + 1);
            right++;
        }
        return len;
    }

    public static int lengthOfLongestSubStringWithoutRepeatingCharacterWithList(String str) {
        int start=0;
        int end=0;
        int max_len=0;
        List<Character> longSub=new ArrayList<>();
        for(int i=0;i<str.length();i++){
            if(!longSub.contains(str.charAt(i))){
                longSub.add(str.charAt(i));
                end++;
                max_len=Math.max(max_len,longSub.size());
            }else {
                longSub.remove(str.charAt(i));
                start++;

            }
        }

      return max_len;

    }
}
