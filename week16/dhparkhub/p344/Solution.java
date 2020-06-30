package p344;

class Solution {
    public void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            int leftIndex = i;
            int rightIndex = s.length - i - 1;
            swap(s, leftIndex, rightIndex);
        }// O(N)
    }

    private void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }// O(1)
}