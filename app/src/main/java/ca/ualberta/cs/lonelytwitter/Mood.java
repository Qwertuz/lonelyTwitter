package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public abstract class Mood {
    String currentmood;
    public abstract Date getDate();
    public abstract void setDate(Date d);
}
