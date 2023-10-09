package learn;


import io.cucumber.java.eo.Se;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class ReplaceCharacter {

    public static String replaceSecondCharacter(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 't' && i < str.length() - 2) {
                if (str.charAt(i + 1) != 't') {
                    str = str.replace(str.charAt(i + 1), ' ');
                }
            }
        }
        return str.replace(" ", "");
        //while replacing character you can't use '' this will cause empty character
        // literal so you have to use space to replace character
        // str.replace(str.charAt(i + 1), '') - This won't work ->  use -> str.replace(str.charAt(i + 1), ' ')
    }


    public static boolean isAnagramSortApproach(String firstString, String secondString) {

        if (firstString.length() != secondString.length())
            return false;

        char[] ch1 = firstString.toCharArray();
        char[] ch2 = secondString.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        for (int i = 0; i < ch1.length; i++) {
            if (ch1[i] != ch2[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAnagramWithHashMapApproach(String firstString,String secondString){
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<firstString.length();i++){
            if(!map.containsKey(firstString.charAt(i))){
                map.put(firstString.charAt(i),1);
            }else
                map.put(firstString.charAt(i),map.get(firstString.charAt(1))+1);
        }

       for(int i=0;i<secondString.length();i++){
           if(map.containsKey(secondString.charAt(i)))
               map.put(secondString.charAt(i),map.get(secondString.charAt(i))-1);
           else
               return  false;
       }

          Set<Character> ch= map.keySet();
          for (Character c : ch ) {
              if (map.get(c) > 0)
                  return false;
          }

          return true;
    }

}

