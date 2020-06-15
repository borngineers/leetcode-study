package week07;

import java.util.*;

public class TweetCounts {

    private final Map<String, List<Tweet>> map = new HashMap<>();

    private static final String MINUTE = "minute";
    private static final String HOUR = "hour";
    private static final String DAY = "day";
    private static final String SECOND = "second";

    public TweetCounts() {

    }

    public static void main(String[]args){
        TweetCounts tweetCounts = new TweetCounts();
        tweetCounts.recordTweet("tweet0",13);
//        tweetCounts.recordTweet("tweet3",0);
//        tweetCounts.recordTweet("tweet3",60);
//        tweetCounts.recordTweet("tweet3",10);
        tweetCounts.recordTweet("tweet3",16);
        tweetCounts.recordTweet("tweet3",66);

        System.out.println(Arrays.toString(tweetCounts.getTweetCountsPerFrequency("hour", "tweet3", 43, 1838).toArray()));
        System.out.println(Arrays.toString(tweetCounts.getTweetCountsPerFrequency("minute", "tweet3", 0, 59).toArray()));
        System.out.println(Arrays.toString(tweetCounts.getTweetCountsPerFrequency("minute", "tweet3", 0, 60).toArray()));
        System.out.println(Arrays.toString(tweetCounts.getTweetCountsPerFrequency("day", "tweet0", 89, 9471).toArray()));

        tweetCounts.recordTweet("tweet3",120);

        System.out.println(Arrays.toString(tweetCounts.getTweetCountsPerFrequency("hour", "tweet3", 0, 210).toArray()));
    }

    void recordTweet(String tweetName, int time) {

        if(map.containsKey(tweetName)){
            final List<Tweet> tweets = map.get(tweetName);
            tweets.add(new Tweet(tweetName, time));
            map.put(tweetName, tweets);
            return;
        }

        List<Tweet> tweets = new ArrayList<>();
        tweets.add(new Tweet(tweetName, time));
        map.put(tweetName, tweets);
    }

    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {

        final List<Integer> resultList = new ArrayList<>();

        List<Integer> timeInterval = new ArrayList<>();

        if(freq.equalsIgnoreCase(SECOND)) {
            timeInterval = getSecondInterval(startTime, endTime);
        }

        if(freq.equalsIgnoreCase(MINUTE)) {
            timeInterval = getMinuteInterval(startTime, endTime);
        }

        if(freq.equalsIgnoreCase(HOUR)){
            timeInterval = getHourInterval(startTime, endTime);
        }

        if(freq.equalsIgnoreCase(DAY)){
            timeInterval = getDayInterval(startTime, endTime);
        }

        if(timeInterval.size() == 0) {
            return null;
        }

        final List<Tweet> tweets = map.get(tweetName);
        Collections.sort(tweets);

        final int size = timeInterval.size() - 1;
        final int tweetSize = tweets.size();
        int newIndex = 0;
        int count = 0;

        // 해당 시간대에 몇개의 트윗이 있는지 여부 파악
        for(int ti = 0; ti <= size; ti += 2){

            int start = timeInterval.get(ti);
            int end = timeInterval.get(ti + 1);

            for(int i = newIndex; i < tweetSize; i++){

                final Tweet tweet = tweets.get(i);
                if (tweet.second >= start && end >= tweet.second) {
                    newIndex++;
                    count++;
                } else {
                    continue;
                }
            }

//            if(isCountInit) {
//                count = 0;
            resultList.add(count);
            count = 0;
//                isCountInit = false;
//            }
        }

        return resultList;
    }

    private List<Integer> getSecondInterval(final int startTime, final int endTime){

        final List<Integer> timeInterval = new ArrayList<>();

        for(int s = startTime; s <= endTime - 1; s++){
            timeInterval.add(s);
            timeInterval.add(s+1);
        }

        return timeInterval;
    }

    private List<Integer> getMinuteInterval(final int startTime, final int endTime) {

        final List<Integer> timeInterval = new ArrayList<>();

        for(int s = startTime; s <= endTime; s += 60){
            timeInterval.add(s);
            timeInterval.add(s + 59);
        }

        return timeInterval;
    }

    private List<Integer> getHourInterval(final int startTime, final int endTime) {

        final List<Integer> timeInterval = new ArrayList<>();

        for(int s = startTime; s <= endTime; s += 3600){
            timeInterval.add(s);
            timeInterval.add(s + 3599);
        }

        return timeInterval;
    }

    private List<Integer> getDayInterval(final int startTime, final int endTime) {

        final List<Integer> timeInterval = new ArrayList<>();

        for(int s = startTime; s <= endTime; s += 86400){
            timeInterval.add(s);
            timeInterval.add(s + 86399);
        }

        return timeInterval;
    }

    class Tweet implements Comparable<Tweet>{

        final String name;
        final int second;

        Tweet(final String name, final int second){
            this.name = name;
            this.second = second;
        }

        @Override
        public int compareTo(Tweet tweet) {
            return second - tweet.second;
        }
    }
}
