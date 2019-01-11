package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public class Sad extends Mood{
    private Date date;

    public void Sad(){
        date = null;
    }

    public void Sad(Date DATE){
        date = DATE;
    }

    public void setDate(Date d) {
        date = d;
    }

    public Date getDate() {
        return date;
    }
}
