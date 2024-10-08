// Vivek Vemulakonda
// 05/17/2024
// CSE 122
//C2:Twitter Trends
// TA: Megana Kommareddy, Rucha Kher
//This class Initializes the tweetbot to be used for further actions, constructor
import java.util.*;
import java.io.*;

public class TweetBot {
    private List<Tweet> tweetList;
    private int currIndex;

    //Pre: Takes in a list of tweet and will throw IllegalArgumentException 
    //if the size of this is less than 1
    //Post:Will create a list of tweets from the given list
    public TweetBot(List<Tweet> tweets){
        if(tweets.size()<1){
            throw new IllegalArgumentException();
        }
        this.tweetList=new ArrayList(tweets);
        this.currIndex=-1;
    }

    //Post:Initializes TweetBot with an empty list
    public TweetBot(){
        this.tweetList=new ArrayList<>();
    }

    //Post:Will return the size of the list
    public int numTweets(){
        return tweetList.size();
    }
    
    //Pre:Takes in a tweet
    //Post:Will add that tweet to the list
    public void addTweet(Tweet tweet){
        tweetList.add(tweet);
    }

    //Post:Will return a tweet from the designated spot
    public Tweet nextTweet(){
        if(currIndex>tweetList.size()-2){
            currIndex=0;
        }else{
            currIndex++;
        }
        Tweet tweet=tweetList.get(currIndex);
        return tweet;
    }

    //Pre:Takes in a Tweet
    //Post:It will remove this tweet from the list
    public void removeTweet(Tweet tweet){
        if(tweetList.contains(tweet)){
            List<Tweet> remove= new ArrayList<>();
            remove.addAll(tweetList);
            if(remove.indexOf(tweet)<=currIndex){
                currIndex--;
            }
            remove.remove(tweet);
            tweetList.clear();
            tweetList.addAll(remove);
        }
    }

    //Post:Resets the iteration state of the TweetBot such that subsequent calls 
    //to nextTweet start back at the beginning.
    public void reset(){
        currIndex=-1;
    }
}   
