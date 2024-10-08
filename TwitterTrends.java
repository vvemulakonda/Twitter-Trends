// Vivek Vemulakonda
// 05/17/2024
// CSE 122
//C2:Twitter Trends
// TA: Megana Kommareddy, Rucha Kher
//This class will find the most frequent word out of all the tweets, while also finding 
//trending vs. non-trending posts based off of likes
import java.util.*;
import java.io.*;

public class TwitterTrends {
    private TweetBot bot;

    //Pre:Takes in the tweetbot
    //Post:Initializes the bot with the given TweetBot object for tweet-analysis
    public TwitterTrends(TweetBot bot){
        this.bot=bot;
    }

    //Post:Will return the most frequent word among all of the analyzed tweets
    public String getMostFrequentWord(){
        Map<String, Integer> mostCommon= new HashMap<>();
        for(int i=0; i<bot.numTweets();i++){
            String caption= bot.nextTweet().getCaption().toLowerCase();
            Scanner scanner=new Scanner(caption);
            while(scanner.hasNext()){
                String word=scanner.next();
                if(mostCommon.containsKey(word)){
                    mostCommon.put(word, mostCommon.get(word)+1);
                }else{
                    mostCommon.put(word,1);
                }
            }
        }
        String mostComm="";
        int max=0;
        for(String word:mostCommon.keySet()){
            int count=mostCommon.get(word);
            if(count>max){
                max=count;
                mostComm=word;
            }
        }
        return mostComm;
    }

    //Post:Will return a tweet as a string that seems to have the most amount of likes, 
    //therfore making it the most trending
    public String trending(){
        int maxLikes=0;
        String post="";
        for(int i=0;i<bot.numTweets();i++){
            Tweet tweet=bot.nextTweet();
            int likes=tweet.getLikes();
            if(likes>maxLikes){
                maxLikes=likes;
                post=tweet.toString();
            }
        }
        return post;
    }

    //Post:Will return a tweet as a String that has the least amount of likes, 
    //therefore making it not trending
    public String notTrending(){
        int minLikes=0;
        String post="";
        for(int i=0;i<bot.numTweets();i++){
            Tweet tweet=bot.nextTweet();
            int likes=tweet.getLikes();
            if(likes<minLikes){
                minLikes=likes;
                post=tweet.toString();
            }
        }
        return post;
        }

}
