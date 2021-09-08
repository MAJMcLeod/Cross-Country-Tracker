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
public class Race {
    private int dist, raceID;
    private Calendar raceDate;
    private SimpleDateFormat form = new SimpleDateFormat("yyyy/MM/dd");
    
    //Race Object constructor overloaded with inputs for all private varibles 
    public Race(int inDist, int inRaceID, Calendar inCal){
        dist = inDist;
       raceID = inRaceID;
       raceDate = inCal;
        
    }
   
    //Returns private int dist
    public int getDist() {
        return dist;
    }

    //returns private int raceID
    public int getRaceID() {
        return raceID;
    }

    //Returns private calendar raceDate
    public Calendar getRaceDate() {
        return raceDate;
    }

    //Returns private SimpleDateFormat form
    public SimpleDateFormat getForm() {
        return form;
    }

    @Override
    //Returns a String describing the Race object
    public String toString() {
        return raceID + ", " + dist + "km, " + form.format(raceDate.getTime());
    }
    
    
}
