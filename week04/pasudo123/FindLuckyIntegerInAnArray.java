class Solution {
    public int findLucky(int[] arr) {
        int[] localArray = new int[501]; // 0 ~ 500
        int maxInteger = -1;
        int max = -1;

        for(int element : arr){
            localArray[element]++;
            maxInteger = Math.max(maxInteger, element);
        }

        for(int i = 1; i <= maxInteger; i++){
            if(localArray[i] == i){
                max = Math.max(max, i);
            }
        }

        return max;
    }
}
