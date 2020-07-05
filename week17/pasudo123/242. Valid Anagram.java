class Solution {
    public boolean isAnagram(String s, String t) {
        final Integer[] array = new Integer['z'-'a' + 1];
        
        Arrays.fill(array, 0);
        
        final char[] cArray1 = s.toCharArray();
        for(char c : cArray1) {
            array['z' - c]++;
        }
        
        final char[] cArray2 = t.toCharArray();
        for(char c : cArray2) {
            array['z' - c]--;
        }
        
        return 0 == new ArrayList<Integer>(Arrays.asList(array))
            .stream()
            .filter(element -> element != 0)
            .count();
    }
}
