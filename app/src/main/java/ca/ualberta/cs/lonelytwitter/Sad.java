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

import java.util.Date;

/**
 *  Represents the mood of sadness
 *
 * @author cjmiller
 * @version 1.0
 * @see Mood
 * @since 1.0
 *
 */
public class Sad extends Mood{
    private Date date;

    /**
     * Sets date as a null value
     * @since 1.0
     */
    public void Sad(){
        date = null;
    }

    /**
     * Initializes the date to the set
     *
     * @param DATE the date to be set
     * @since 1.0
     */
    public void Sad(Date DATE){
        date = DATE;
    }

    public void setDate(Date d) {
        date = d;
    }

    public Date getDate() {
        return date;
    }

    /**
     * Returns the value Sad when called
     *
     * @return the string "Sad"
     * @since 1.0
     */
    public String EmoteS(){
        return "Sad";
    }
}
