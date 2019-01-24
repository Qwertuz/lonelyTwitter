/*
 * Copyright 2019 TEAM 07
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package ca.ualberta.cs.lonelytwitter;

/**
 *  Represents a Tweet that is important
 *
 * @author cjmiller
 * @version 1.0
 * @see Tweet
 * @since 1.0
 *
 */
public class importantTweet extends Tweet{

    /**
     * stores the parameter as the main message of important tweet.
     *
     * @param s the string to be stored as the main message
     * @since 1.0
     */
    public void importantTweet(String s){

        this.message = s;
    }

    /**
     * Set message and secondary message of the important tweet.
     *
     * @param first  the value that becomes the main message
     * @param second the value that becomes the secondary message
     * @since 1.0
     */
    public void setMessage(String first, String second){
        message = first;
        message2 = second;
    }

}
