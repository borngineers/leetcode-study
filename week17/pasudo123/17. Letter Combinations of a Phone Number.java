class Solution {
    final static Map<Integer, List<Character>> DIGIT_STORE = new HashMap<>();
    final List<String> list = new ArrayList<>();
    
    public List<String> letterCombinations(String digits) {
        DIGIT_STORE.clear();
        DIGIT_STORE.put(2, Arrays.asList('a', 'b', 'c'));
        DIGIT_STORE.put(3, Arrays.asList('d', 'e', 'f'));
        DIGIT_STORE.put(4, Arrays.asList('g', 'h', 'i'));
        DIGIT_STORE.put(5, Arrays.asList('j', 'k', 'l'));
        DIGIT_STORE.put(6, Arrays.asList('m', 'n', 'o'));
        DIGIT_STORE.put(7, Arrays.asList('p', 'q', 'r', 's'));
        DIGIT_STORE.put(8, Arrays.asList('t', 'u', 'v'));
        DIGIT_STORE.put(9, Arrays.asList('w', 'x', 'y', 'z'));
        
        if(digits.length() == 0) {
            return Collections.emptyList();
        }
        
        list.clear();
        search(0, "", digits);
        return list;
    }
    
    private void search(final int currentIndex, final String currentValue, final String digits){
        if(currentIndex == digits.length()){
            list.add(currentValue);
            return;
        }
        
        
        final int number = Integer.parseInt(digits.charAt(currentIndex) + "");
        final List<Character> charList = DIGIT_STORE.get(number);
        for(char c : charList) {
            search(currentIndex + 1, currentValue.concat(String.valueOf(c)), digits);
        }
    }
}
