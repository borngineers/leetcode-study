package week02;

import java.io.*;

/**
 * Created by pasudo123 on 2020-01-11
 * Email: oraedoa@gmail.com
 **/
public class SimplifyPath {

    private static InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    private static BufferedReader reader = new BufferedReader(inputStreamReader);

    private static OutputStreamWriter outputStreamWriter = new OutputStreamWriter(System.out);
    private static BufferedWriter writer = new BufferedWriter(outputStreamWriter);

    private static final String SLASH_PATTERN = "\\/+";
    private static final Character SLASH = '/';
    private static final Character DOT = '.';

    public static void main(String[]args) throws IOException {

        SimplifyPath processor = new SimplifyPath();

        writer.write(processor.simplifyPath("/home/"));
        writer.newLine();

        writer.write(processor.simplifyPath("/../"));
        writer.newLine();

        writer.write(processor.simplifyPath("/home//foo/"));
        writer.newLine();

        writer.write(processor.simplifyPath("/a/./b/../../c/"));
        writer.newLine();

        writer.write(processor.simplifyPath("/a/../../b/../c//.//"));
        writer.newLine();

        writer.write(processor.simplifyPath("/a//b////c/d//././/.."));
        writer.newLine();

        writer.write(processor.simplifyPath("/..."));           // "/..."
        writer.newLine();

        writer.write(processor.simplifyPath("/..hidden"));      // "/..hidden"
        writer.newLine();

        writer.write(processor.simplifyPath("/.aa/....hidden"));      // "/..hidden"
        writer.newLine();

        writer.flush();
    }

    public String simplifyPath(String path){

        /**
         * 코드정리하기...
         */

        final int size = path.length();
        String result = "";

        for(int i = 0; i < size; i++) {

            char ch = path.charAt(i);

            int dotCount = 0;
            int subIndex = i;

            // 점 확인 => 현재 위치, 상위 디렉토리, 그 외 판단
            while(isDot(ch) && subIndex < size) {
                ch = path.charAt(subIndex++);

                if(isDot(ch)){
                    dotCount++;
                }
            }

            if(dotCount == 1
                    && (i + 1) < size
                    && !isDot(path.charAt(i + 1))
                    && !isSlash(path.charAt(i + 1))){

                dotCount += 1;
            }

            // 현재 위치
            if(dotCount == 1) {
                result = result.replaceAll(SLASH_PATTERN, String.valueOf(SLASH));
                result = result.substring(0, result.length() - 1);
                continue;
            }

            if(dotCount == 2
                    && (i + 2) < size
                    && !isDot(path.charAt(i + 2))
                    && !isSlash(path.charAt(i + 2))){

                dotCount += 1;
            }

            // 상위 디렉토리
            if(dotCount == 2) {
                result = result.replaceAll(SLASH_PATTERN, String.valueOf(SLASH));
                result = result.substring(0, result.length() - 1);

                int backIndex = result.length() - 1;

                while(backIndex >= 0){
                    ch = result.charAt(backIndex);
                    result = result.substring(0, result.length() - 1);
                    backIndex--;

                    if(isSlash(ch)){
                        break;
                    }
                }

                i += 1;

                continue;
            }

            if(subIndex != i) {
                result += path.substring(i, subIndex);
                i = subIndex - 1;
                continue;
            }

            result += ch;
        }// for

        result = result.replaceAll(SLASH_PATTERN, String.valueOf(SLASH));

        if(result.length() != 1 && result.endsWith(String.valueOf(SLASH))){
            return result.substring(0, result.length() - 1);
        }

        if(result.length() == 0){
            return String.valueOf(SLASH);
        }

        return result;
    }

    private boolean isDot(final char ch){
        return (ch == DOT);
    }

    private boolean isSlash(final char ch){
        return (ch == SLASH);
    }
}
