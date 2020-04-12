package leetcode.week02;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class S1405 {

    public static void main(String[] args) {

        System.out.println(longestDiverseString(0, 8, 11));
//        System.out.println(longestDiverseString(1, 1, 7));
//        System.out.println(longestDiverseString(2, 2, 1));
//        System.out.println(longestDiverseString(7, 1, 0));
    }

    public static String longestDiverseString(int a, int b, int c) {

        StringBuilder ret = new StringBuilder();
        int maxCount = Math.max(a, Math.max(b, c));
        if (maxCount == 0) { return ""; }

        PriorityQueue<Element> pq = new PriorityQueue<Element>();
        List<Element> list = new ArrayList<Element>();
        if (a != 0) { pq.add(new Element('a', a)); }
        if (b != 0) { pq.add(new Element('b', b)); }
        if (c != 0) { pq.add(new Element('c', c)); }

        while (true) {

            boolean isChange = false;

            while(!pq.isEmpty()) {
                Element element = pq.poll();
                if (isPossibleCharacter(element.ch, ret)) {
                    ret.append(element.ch);
                    element.count--;
                    if(element.count != 0) {
                        list.add(element);
                    }
                    isChange = true;
                    break;
                }  else {
                    list.add(element);
                }
            }

            while(!pq.isEmpty()){
                list.add(pq.poll());
            }

            pq.addAll(list);
            list.clear();

            if(!isChange){
                break;
            }
        }

        return ret.toString();
    }

    private static boolean isPossibleCharacter(char ch, StringBuilder builder){
        if(builder.length() == 0 || builder.length() == 1){
            return true;
        }
        int lastIndex = builder.length() - 1;
        int beforeLastIndex = builder.length() - 2;

        if(builder.charAt(lastIndex) == builder.charAt(beforeLastIndex)
                && builder.charAt(lastIndex) == ch){
            return false;
        } else {
            return true;
        }
    }

    static class Element implements Comparable<Element> {
        char ch;
        int count;

        public Element(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }

        @Override
        public int compareTo(Element o) {
            return o.count - count;
        }
    }
}
