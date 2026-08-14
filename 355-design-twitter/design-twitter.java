class Tweet {
 int time;
 int tweetId;

 Tweet(int time, int tweetId) {
    this.time = time;
    this.tweetId = tweetId;
 }
}

class Twitter {

    // here we will have two maps
    // 1st map for storing userid with their tweets

    Map<Integer, List<Tweet>> tweets = new HashMap<>();
    // 2nd map for mapping follower id and followyy id
    Map<Integer, Set<Integer>> followerToFollowing = new HashMap<>();

    int time = 0;

    public Twitter() {
    
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!tweets.containsKey(userId)) {
            tweets.put(userId, new ArrayList<>());
        }

        tweets.get(userId).add(new Tweet(++time, tweetId));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Tweet> allTweets = new ArrayList<>();

        // if the user has posted any tweet
        if(tweets.containsKey(userId)) {
            allTweets.addAll(tweets.get(userId));
        }

        // if they follow anyone else
        if(followerToFollowing.containsKey(userId)) {
            for(int followee : followerToFollowing.get(userId)) {
                if(tweets.containsKey(followee)) {
                    allTweets.addAll(tweets.get(followee));
                }
            }
        }

        Collections.sort(allTweets, (a,b) -> b.time - a.time);

        List<Integer> tenRecentTweets = new ArrayList<>();

        for(int i = 0; i < Math.min(10, allTweets.size());++i) {
            tenRecentTweets.add(allTweets.get(i).tweetId);
        }

        return tenRecentTweets;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!followerToFollowing.containsKey(followerId)) {
            followerToFollowing.put(followerId, new HashSet<>());
        }

        followerToFollowing.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followerToFollowing.containsKey(followerId)) {
            followerToFollowing.get(followerId).remove(followeeId);
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