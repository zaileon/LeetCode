import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Twitter {
	private static int timestamp = 0;
	private Map<Integer, User> userMap;
	
	public Twitter() {
		userMap = new HashMap<>();
	}
	
	public void postTweet(int userId, int tweetId) {
		userMap.putIfAbsent(userId, new User(userId));
		userMap.get(userId).post(tweetId);
	}
	
	public List<Integer> getNewsFeed(int userId) {
		List<Integer> result = new ArrayList<>();
		if (!userMap.containsKey(userId)) return result;
		Set<Integer> users = userMap.get(userId).followed;
		PriorityQueue<Tweet> heap = new PriorityQueue<>(users.size(), (t1, t2) -> t2.time - t1.time);
		for (int id : users) {
			Tweet head = userMap.get(id).tweet_head;
			if (head != null) heap.add(head);
		}
		int k = 10;
		while (k-- > 0 && !heap.isEmpty()) {
			Tweet t = heap.poll();
			if (t.next != null) heap.add(t.next);
			result.add(t.id);
		}
		return result;
	}
	
	public static void main(String[] args) {
		Twitter twitter = new Twitter();
		twitter.postTweet(1,5);
//		twitter.getNewsFeed(1);
//		twitter.follow(1, 2);
//		twitter.postTweet(2, 6);
//		twitter.getNewsFeed(1);
//		twitter.unfollow(1, 2);
//		twitter.getNewsFeed(1);
		twitter.unfollow(1, 1);
		twitter.getNewsFeed(1);
	}
	
	public void follow(int followerId, int followeeId) {
		userMap.putIfAbsent(followerId, new User(followerId));
		userMap.putIfAbsent(followeeId, new User(followeeId));
		userMap.get(followerId).follow(followeeId);
	}
	
	public void unfollow(int followerId, int followeeId) {
		if (!userMap.containsKey(followerId) || followerId == followeeId) return;
		userMap.get(followerId).unfollow(followeeId);
	}

	public class Tweet {
		public int id;
		public int time;
		public Tweet next;
		public Tweet(int id) { this.id = id; this.time = timestamp++; this.next = null; }
	}
	
	public class User {
		public int id;
		public Set<Integer> followed;
		public Tweet tweet_head;
		public User(int id) { this.id = id; followed = new HashSet<>(); followed.add(id); tweet_head = null; }
		
		public void follow(int id) {
			followed.add(id);
		}
		
		public void unfollow(int id) {
			followed.remove(id);
		}
		
		public void post(int id) {
			Tweet tweet = new Tweet(id);
			tweet.next = tweet_head;
			tweet_head = tweet;
		}
	}
}
