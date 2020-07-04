class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()) return false;
        
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        
        int[] check = new int[26];
        
        for(int i=0; i<sArr.length; i++) {
            check[sArr[i] - 'a']++;
            check[tArr[i] - 'a']--;
        }
        
        for(int a : check) {
            if(a != 0) return false;
        }
        
        return true;
    }
}

class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()) return false;
        
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        
        return Arrays.equals(sArr, tArr);
    }
}

class Solution {
    public boolean isAnagram(String s, String t) {
        
        int sLen = s.length();
        int tLen = t.length();
        
        if(sLen == 0 && tLen == 0) {
            return true;
        }
        
        if(sLen == 0 || tLen ==0) {
            return false;
        }
        
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        
        for(char sc : sArr) {
            if(sMap.containsKey(sc)) {
                sMap.put(sc, sMap.get(sc)+1);
            } else {
                sMap.put(sc, 1);
            }
        }
        
        for(char tc : tArr) {
            if(tMap.containsKey(tc)) {
                tMap.put(tc, tMap.get(tc)+1);
            } else {
                tMap.put(tc, 1);
            }
        }
        
        if(sMap.size() != tMap.size()) return false;
        
        for(Character c : sMap.keySet()) {
            if(!tMap.containsKey(c)) return false;
            
            if(!tMap.get(c).equals(sMap.get(c))) return false;
        }
        
        return true;
    }
}
