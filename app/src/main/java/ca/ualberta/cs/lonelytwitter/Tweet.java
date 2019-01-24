/*
 * Class Name: Tweet
 *
 * Version: V 1.0
 *
 * Copyright 2019 TEAM 07
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 *  Represents a Tweet
 *
 * @author cjmiller
 * @version 1.0
 * @see importantTweet
 * @since 1.0
 *
 */

public abstract class Tweet {
    String message;       //main message of the tweet
    String message2;      //secondary message of the tweet
    Date date;            //date the Tweet was created

    /**
     * Initializes date to a null value and leaves message blank
     * @since 1.0
     */

    public void Tweet() {
        message = "";
        date = null;
    }

    /**
     * Saves the parameter tweetm as message
     * @param tweetm tweetm maybe be any string of UTF-8 characters or a null value
     * @since 1.0
     */

    public void setMessage(String tweetm) {

        message = tweetm;
    }

    /**
     * Returns the currently stored message in Tweet
     * @return message the string stored or a null value if message has no stored value
     * @since 1.0
     */

    public String getMessage() {

        return message;
    }

    /**
     * Returns the date currently stored in Tweet
     * @return date any date or a null value if date has no stored value
     * @since 1.0
     */

    public Date getDate(){

        return date;
    }

    /**
     * Turns the Tweet object into a string by returning the message held in it
     * @return message
     * @since 1.0
     */

    @Override
    public String toString() {

        return message;
    }
}

