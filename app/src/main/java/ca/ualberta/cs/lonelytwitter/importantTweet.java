package ca.ualberta.cs.lonelytwitter;

public class importantTweet extends Tweet{

    public void importantTweet(){

    }

    public void importantTweet(String s){
        this.message = s;
    }
    public void setMessage(String first, String second){
        message = first;
        message2 = second;
    }

    @Override
    public String getSomething() {
        return null;
    }
}
