package com.lia.Design;

import java.util.*;

/**
 * Design a simplified version of Twitter where users can post tweets, follow/unfollow another user and is able to see the 10 most recent tweets in the user's news feed. Your design should support the following methods:

 postTweet(userId, tweetId): Compose a new tweet.
 getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
 follow(followerId, followeeId): Follower follows a followee.
 unfollow(followerId, followeeId): Follower unfollows a followee.
 Example:

 Twitter twitter = new Twitter();

 // User 1 posts a new tweet (id = 5).
 twitter.postTweet(1, 5);

 // User 1's news feed should return a list with 1 tweet id -> [5].
 twitter.getNewsFeed(1);

 // User 1 follows user 2.
 twitter.follow(1, 2);

 // User 2 posts a new tweet (id = 6).
 twitter.postTweet(2, 6);

 // User 1's news feed should return a list with 2 tweet ids -> [6, 5].
 // Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
 twitter.getNewsFeed(1);

 // User 1 unfollows user 2.
 twitter.unfollow(1, 2);

 // User 1's news feed should return a list with 1 tweet id -> [5],
 // since user 1 is no longer following user 2.
 twitter.getNewsFeed(1);

 * Created by liqu on 10/20/16.
 */
public class Twitter {

    private static int nthTweet = -1;
    private Map<Integer, Set<Integer>> friends; // <user_id, following>
    private Map<Integer, LinkedList<Tweet>> timeline; // <user_id, tweets> user's timeline
    private static final Comparator<Tweet> newsFeedComparator = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            Tweet t1 = (Tweet) o1;
            Tweet t2 = (Tweet) o2;
            return t2.time - t1.time;
        }
    };

    class Tweet {
        public int id;
        public int time;
        public Tweet(int id) {
            this.id = id;
            this.time = ++nthTweet;
        }
    }

    /** Initialize your data structure here. */
    public Twitter() {
        this.friends = new HashMap<>();
        this.timeline = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!timeline.containsKey(userId)) {
            timeline.put(userId, new LinkedList<>());
        }
        timeline.get(userId).addFirst(new Tweet(tweetId)); /* add tweet to user's timeline in desc order */
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> newsFeedList = new ArrayList<>();
        PriorityQueue<Tweet> pq = new PriorityQueue<Tweet>(1, newsFeedComparator); // news feed cache for userId

        /* add user's own timeline to news feed */
        if (timeline.containsKey(userId)){
            LinkedList<Tweet> tweets = timeline.get(userId);
            for (int i = 0; i < tweets.size() && i < 10; i++){
                pq.add(tweets.get(i)); // add the latest 10 tweets to news feed
            }
        }

        /* add user's followee's timeline to news feed */
        if (friends.containsKey(userId)) { // usreId following someone
            for (int followee : friends.get(userId)) { // get followee one by one
                if (timeline.containsKey(followee)) { // if the followee have post tweets
                    LinkedList<Tweet> tweets = timeline.get(followee);
                    for (int i = 0; i < tweets.size() && i < 10; i++){
                        pq.add(tweets.get(i));
                    }
                }
            }
        }

        for (int i = 0; i < 10; i++) {
            if (pq.peek() != null) {
                newsFeedList.add(pq.poll().id);
            }
        }

        return newsFeedList;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
       if (!friends.containsKey(followerId)) {
           friends.put(followerId, new HashSet<>());
       }
       if (followerId != followeeId) friends.get(followerId).add(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (friends.containsKey(followerId)) {
            friends.get(followerId).remove((Integer)followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */