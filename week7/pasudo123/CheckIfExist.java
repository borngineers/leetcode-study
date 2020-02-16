package week07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CheckIfExist {

    public static void main(String[]args){


        System.out.println(checkIfExist(new int[]{-10,12,-20,-8,15}));
    }

    public static boolean checkIfExist(int[] arr) {

        final List<Integer> plusList = new ArrayList<>();
        final List<Integer> minusList = new ArrayList<>();

        for (int number : arr) {
            if (number < 0) {
                minusList.add(number);
                continue;
            }

            plusList.add(number);
        }

        final int plusSize = plusList.size();
        Collections.sort(plusList);
        for(int i = 0; i < plusSize; i++){
            for(int j = i + 1; j < plusSize; j++){
                if(plusList.get(i) * 2 == plusList.get(j)){
                    return true;
                }
            }
        }

        final int minusSize = minusList.size();
        Collections.sort(minusList);
        for(int i = 0; i < minusSize; i++){
            for(int j = i + 1; j < minusSize; j++){
                if(minusList.get(i) == minusList.get(j) * 2){
                    return true;
                }
            }
        }

        return false;
    }
}
