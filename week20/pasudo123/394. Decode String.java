import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {    
    
    private static final Pattern PATTERN = Pattern.compile("(\\d*\\[[a-zA-Z]*\\])");

    public String decodeString(String s) {

        final StringBuilder builder = new StringBuilder();
        Matcher matcher = PATTERN.matcher(s);

        while(matcher.find()) {
            int beginIndex = matcher.start();
            int endIndex = matcher.end();

            final String foundString = s.substring(beginIndex, endIndex);
            final int length = foundString.length();
            String encodeString = "";
            String numString = "";

            boolean isOpen = false;

            // for
            for(int i = 0; i < length; i++) {
                char c = foundString.charAt(i);
                if(c == '[') {
                    isOpen = true;
                    continue;
                }

                if(c == ']') {
                    break;
                }

                if(isOpen) {
                    encodeString += c;
                    continue;
                }

                numString += c;
            }// for

            final int kSize = Integer.parseInt(numString);
            for(int i = 1; i <= kSize; i++) {
                builder.append(encodeString);
            }

            s = s.substring(0, beginIndex) + builder.toString() + s.substring(endIndex);
            matcher = PATTERN.matcher(s);
            builder.setLength(0);
        }

        return s;
    }
}
