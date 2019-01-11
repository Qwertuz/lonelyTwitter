package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public class Happy extends Mood {
    private Date date;

    public void Happy(){
        date = null;
    }

    public void Happy(Date DATE){
        date = DATE;
    }

    public void setDate(Date d) {
        date = d;
    }

    public Date getDate() {
        return date;
    }

}
