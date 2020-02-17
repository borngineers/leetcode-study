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
        tweetCounts.recordTweet("tweet0",0);
        tweetCounts.recordTweet("tweet3",60);
        tweetCounts.recordTweet("tweet4",56);

        System.out.println(Arrays.toString(tweetCounts.getTweetCountsPerFrequency("minute", "tweet3", 0, 59).toArray()));
        System.out.println(Arrays.toString(tweetCounts.getTweetCountsPerFrequency("minute", "tweet3", 0, 60).toArray()));
        System.out.println(Arrays.toString(tweetCounts.getTweetCountsPerFrequency("day", "tweet0", 89, 9471).toArray()));

        tweetCounts.recordTweet("tweet3",120);
    }

    public void recordTweet(String tweetName, int time) {

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

        if(freq.equalsIgnoreCase(HOUR) || freq.equalsIgnoreCase(DAY)){
            timeInterval = getHourInterval(startTime, endTime);
        }

        if(timeInterval.size() == 0) {
            return null;
        }

        final List<Tweet> tweets = map.get(tweetName);
        Collections.sort(tweets);

        final int size = timeInterval.size() - 1;
        final int tweetSize = tweets.size();
        boolean isCountInit = false;
        int count = 0;

        for(int i = 0; i < tweetSize; i++) {

            final Tweet tweet = tweets.get(i);

            for (int j = 0; j <= size; j += 2) {

                int start = timeInterval.get(j);
                int end = timeInterval.get(j + 1);

                if (tweet.second >= start && end >= tweet.second) {
                    count++;
                } else {
                    isCountInit = true;
                    break;
                }
            }

            resultList.add(count);
            if(isCountInit){
                count = 0;
                isCountInit = false;
            }
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
