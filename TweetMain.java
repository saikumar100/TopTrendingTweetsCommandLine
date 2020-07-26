
import java.util.ArrayList;
import java.util.Scanner;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Standalone main class which takes tweets recursively & display top 10 trending tweets.
 * This class parses input tweet text into a tweet object and parses it accordingly @see{{@link Tweet}}
 */
class TweetMain {

    private static final Map<String,Integer> trendingTweets = new ConcurrentHashMap<>();
    private static final int NUMBER_OF_TOP_TWEETS_COUNT = 10;
    private static final String INPUT_HELPER_TEXT = "Please enter i/p tweet: ";

    public static void main(String... args) {
        Scanner hashTag = new Scanner( System.in );
        System.out.println(INPUT_HELPER_TEXT);

        while(hashTag.hasNextLine()) {
            String tweetText = hashTag.nextLine();

            // return pressed
            if (tweetText.length() == 0) {
                continue;
            }

            Tweet tweet = Tweet.getTweet(tweetText.toLowerCase());

            getTop10TrendingTweets(tweet);
        }

    }

    /**
     * This method takes latest entered tweet text and shows top 10 trending tweets list
     * @param tweet tweetObject
     */
    private static void getTop10TrendingTweets(Tweet tweet) {
        Set<String> uniqueHashTags = tweet.getUniqueHashTags();

        for(String ht: uniqueHashTags) {
            if(trendingTweets.containsKey(ht)) {
                Integer value = trendingTweets.get(ht) + 1;
                trendingTweets.put(ht,value);
            }else {
                trendingTweets.put(ht,1);
            }
        }
        if(trendingTweets.size() == 0){
            System.out.println(INPUT_HELPER_TEXT);
            return;
        }
        displayTopTweets();
    }

    /**
     * Displays all the tweets
     */
    private static void displayTopTweets() {
        System.out.println("Below are Top "+NUMBER_OF_TOP_TWEETS_COUNT+" Trending Tweets");
        System.out.println("============================");//start
        Set<Map.Entry<String, Integer>> set = trendingTweets.entrySet();

        List<Map.Entry<String, Integer>> list = new ArrayList<>(
                set);

        list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        if(list.size() < NUMBER_OF_TOP_TWEETS_COUNT)
        {
            for(Map.Entry<String, Integer> entry: list) {
                System.out.println(entry.getKey());
            }
        }
        else {
            for(Map.Entry<String, Integer> entry: list.subList(0, NUMBER_OF_TOP_TWEETS_COUNT)) {
                System.out.println(entry.getKey());
            }
        }
        System.out.println("============================");//end
        System.out.println(INPUT_HELPER_TEXT);

    }
}

/**
 * Standalone Tweet class which takes i/p tweet text & extract hashTag from the i/p text
 * and parses it. Parsing the tweet text using a special java class @see{@link StringTokenizer}
 */
class Tweet {
    private List<String> hashtags = new ArrayList<String>();
    private String text;

    private Tweet() {}

    /**
     * creates a tweet object from the i/p text and parses it.
     * @param tweetText tweetText
     * @return tweet object
     */
    public static Tweet getTweet(String tweetText) {
        Tweet tweet = new Tweet();
        tweet.text = tweetText;
        tweet.parse();
        return tweet;
    }

    /**
     * parses tweet object using stringtokenizer
     */
    private void parse() {
        StringTokenizer tokenizer = new StringTokenizer(this.text);
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (token.startsWith("#")) {
                hashtags.add(token);
            }
        }
    }

    /**
     *
     * @return set of unique hash tags from given i/p tweet text
     */
    public Set<String> getUniqueHashTags() {
        return new HashSet<>(hashtags);
    }
}