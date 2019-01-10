package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public abstract class Tweet {

    String message;
    String message2;

    Date date;

    public void Tweet() {
        message = "";
        date = null;
    }

    public void setMessage(String tweetm)
    {
        message = tweetm;
    }

    public String getMessage() {
        return message;
    }

    public abstract String getSomething();
}

