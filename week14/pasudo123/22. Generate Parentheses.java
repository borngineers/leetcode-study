package leetcode.week07;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class S022 {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(generateParenthesis(1).toArray()));
//        System.out.println(Arrays.toString(generateParenthesis(2).toArray()));
//        System.out.println(Arrays.toString(generateParenthesis(3).toArray()));
        System.out.println(Arrays.toString(generateParenthesis(4).toArray()));
//        System.out.println(Arrays.toString(generateParenthesis(4).toArray()));
//        System.out.println(Arrays.toString(generateParenthesis(5).toArray()));
//        System.out.println(Arrays.toString(generateParenthesis(6).toArray()));
    }

    private static List<List<String>> ret = new ArrayList<>();

    public static List<String> generateParenthesis(int n) {
        ret.clear();

        if (n == 1) {
            return Collections.singletonList("()");
        }

        ret.add(new ArrayList<>());
        ret.add(Arrays.asList("()"));
        for(int i = 2; i <= n; i++){
            ret.add(new ArrayList<>());
        }

        recursive(n, 1, n - 1);

        return ret.get(n).stream()
                .distinct()
                .collect(Collectors.toList());
    }

    private static void recursive(final int targetIndex, final int startIndex, final int lastIndex) {
            if(startIndex > targetIndex || lastIndex < 1){
                return;
            }

            if(ret.get(targetIndex).size() == 0) {
                recursive(targetIndex - 1, 1, lastIndex - 1);
            }

            final List<String> list1 = ret.get(startIndex);
            final List<String> list2 = ret.get(lastIndex);
            final List<String> newList = mergeTwoList(list1, list2);
            ret.get(targetIndex).addAll(newList);
            ret.get(targetIndex).addAll(coverList(ret.get(targetIndex-1)));

            ret.set(targetIndex, ret.get(targetIndex).stream().distinct().collect(Collectors.toList()));
            recursive(targetIndex, startIndex + 1, lastIndex - 1);
    }

    private static List<String> mergeTwoList(final List<String> list1, final List<String> list2){
        final List<String> newList = new ArrayList<>();
        for(String element1 : list1){
            for(String element2 : list2){
                newList.add(element1 + element2);
                newList.add(element2 + element1);
            }
        }

        return newList;
    }

    private static List<String> coverList(final List<String> list){
        return list.stream()
                .map(element -> "(" + element + ")")
                .collect(Collectors.toList());
    }
}

/**
 * ["(((())))","((()()))",
 * "((())())","((()))()",
 * "(()(()))","(()()())",
 * "(()())()",               "(())(())",
 * "(())()()","()((()))",
 * "()(()())","()(())()",
 * "()()(())","()()()()"]
 * **/
