package solved;

public class P1404 {

    class Solution {
        private int answer;

        Solution() {
            answer = 0;
        }

        public int numSteps(String s) {
            while (!s.equals("1")) {
                int lastIndex = s.length() - 1;
                if (s.charAt(lastIndex) == '0') {
                    s = divide(s);
                } else {
                    s = add(s);
                }
                answer++;
//                System.out.println(s);
            }
            return answer;
        }

        public String add(String s) {
            String ret = "";
            int pos = s.lastIndexOf('0');
            if (pos == -1) {
                ret = "1";
                for (int i = 0; i < s.length(); i++) {
                    ret += '0';
                }
            } else {
                ret = s.substring(0, pos) + "1";
                for (int i = pos + 1; i < s.length(); i++) {
                    ret += '0';
                }
            }
            return ret;
        }

        public String divide(String s) {
            return s.substring(0, s.length() - 1);
        }
    }

}