class Solution {
    public int numTeams(int[] rating) {
        int size = rating.length;
        int count = 0;

        for(int i = 0; i < size - 2; i++){
            for(int j = i + 1; j < size - 1; j++){
                for(int k = j + 1; k < size; k++){
                    if(rating[i] < rating[j] && rating[j] < rating[k]){
                        count++;
                    } else if(rating[i] > rating[j] && rating[j] > rating[k]){
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
