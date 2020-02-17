// Runtime: 1 ms
// Memory Usage: 39.3 MB

class Solution {
    public boolean checkIfExist(int[] arr) {
        HashMap<Integer, Integer> cache = new HashMap<>();
        int arr_size = arr.length;

        boolean check_forward = false;
        boolean check_backward = false;

        for (int i = 0; i < arr_size; i++) {
            check_forward = check_double(arr[i], cache);
            if (check_forward) {
                break;
            }
        }

        cache = new HashMap<>();
        if (!check_forward) {
            for (int i = arr_size - 1; i > -1; i--) {
                check_backward = check_double(arr[i], cache);
                if (check_backward) {
                    break;
                }
            }
        }

        return (check_forward || check_backward);
    }
    public boolean check_double(int num, HashMap<Integer, Integer> cache) {
        if (cache.containsKey(num)) {
            return true;
        }
        else {
            if (num % 2 == 0) {
                cache.put((num / 2), 0);
            }
        }
        return false;
    }
}
