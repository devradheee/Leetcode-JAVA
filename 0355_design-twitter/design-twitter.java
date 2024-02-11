// package 0355_design-twitter;

class Twitter {

    HashMap<Integer, Integer> postedTweets = new HashMap<>();
    List<Integer> follower = new ArrayList<>();
    List<Integer> followee = new ArrayList<>();
    List<Integer> allTweets = new ArrayList<>();

    public Twitter() {

    }

    public void postTweet(int userId, int tweetId) {
        // Since I have a unique tweetId, I can use it as key and the user that posted
        // it as value
        postedTweets.put(tweetId, userId);
        allTweets.add(tweetId);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        List<Integer> validFollowers = new ArrayList<>();
        for (int i = 0; i < follower.size(); i++) {
            if (follower.get(i) == userId) {
                validFollowers.add(followee.get(i));
            }
        }
        int counter = 0;
        for (int i = allTweets.size() - 1; i >= 0; i--) {

            int tweetPoster = postedTweets.get(allTweets.get(i));
            if (tweetPoster == userId || validFollowers.contains(tweetPoster)) {
                if (counter < 10) {
                    res.add(allTweets.get(i));
                    counter++;
                }
            }
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {
        follower.add(followerId);
        followee.add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        for (int i = 0; i < follower.size(); i++) {
            if (follower.get(i) == followerId && followee.get(i) == followeeId) {
                follower.remove(i);
                followee.remove(i);
            }
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