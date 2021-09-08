/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicMain;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author maxaj
 */
public class Results {
    private int raceID, sID;
    private Calendar raceTime;
    private SimpleDateFormat form = new SimpleDateFormat("HH:mm:ss");

     //Results Object constructor overloaded with inputs for all private varibles
    public Results(int r, int s, Calendar inCal) {
        raceID = r;
        sID = s;
        raceTime = inCal;
        
    }
    
    //Returns private int raceID
    public int getRaceID() {
        return raceID;
    }

    //Returns privet int sID
    public int getsID() {
        return sID;
    }

    //Returns private Calendar raceTime
    public Calendar getRaceTime() {
        return raceTime;
    }

    //Returns private SimpleDateFormat form;
    public SimpleDateFormat getForm() {
        return form;
    }

    @Override
     //Returns a String describing the Results object
    public String toString() {
        return sID + ", " + raceID + ", " + form.format(raceTime.getTime());
    }
    
    
    
    

}

