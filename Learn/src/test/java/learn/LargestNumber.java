package learn;

import java.util.Arrays;

public class LargestNumber {

    public static int secondLargestNumber(int[] number) {
        Arrays.sort(number);
        return (number[number.length-2]);
    }

    public static int secondLargestNumberWithoutInBuiltFunction(int[] number) {
        int max=number[0];
        int secondMax=0;
        for(int i=0;i<number.length-1;i++){
            if(number[i+1]>max){
                secondMax=max;
                max=number[i+1];
            }
        }
        return secondMax;
    }
}
