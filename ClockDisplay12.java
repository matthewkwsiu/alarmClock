
/**
 * The ClockDisplay12 class implements a digital clock display for a
 * 12 hour clock. The clock shows hours and minutes. The 
 * range of the clock is 12:00 a.m. (midnight) to 11:59 p.m. (one minute 
 * before midnight).
 * 
 * The clock display receives "ticks" (via the timeTick method) every minute
 * and reacts by incrementing the display. This is done in the usual clock
 * fashion: the hour increments when the minutes roll over to zero.
 * 
 * @author Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */
public class ClockDisplay12
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String displayString;    // simulates the actual display
    private String clockAmPm; // represents am or pm
    private String AM = "a.m.";
    private String PM = "p.m.";
    
    /**
     * Constructor for ClockDisplay objects. This constructor 
     * creates a new clock set at 12:00 a.m.
     */
    public ClockDisplay12()
    {
        hours = new NumberDisplay(12);
        minutes = new NumberDisplay(60);
        clockAmPm = AM;
        updateDisplay();
    }

    /**
     * Constructor for ClockDisplay objects. This constructor
     * creates a new clock set at the time specified by the 
     * parameters.
     * 
     */
    public ClockDisplay12(int hour, int minute, String amPm)
    {
        hours = new NumberDisplay(12);
        minutes = new NumberDisplay(60);
        setTime(hour, minute, amPm);
    }

    /**
     * This method should get called once every minute - it makes
     * the clock display go one minute forward.
     * 
     * This method also changes the hour value and switchAmPm as 
     * necessary
     */
    public void timeTick()
    {
        minutes.increment();
        if(minutes.getValue() == 0) {  // it just rolled over!
            hours.increment();
            if(hours.getValue() == 0)
            {
                switchAmPm();
            }
        }
        
        updateDisplay();
    }
    
    /**
     * Switches the value of clockAmPm from AM to PM and PM to AM
     */
    private void switchAmPm(){
        if(clockAmPm.equals(AM))
        {
            clockAmPm = PM;
        }
        else
        {
            clockAmPm = AM;
        }
    }
    
    /**
     * performs error checking on the string
     * if the string is "p.m.", will return "p.m."
     * otherwise, will return "a.m."
     */
    
    /**
     * Set the time of the display to the specified hour and
     * minute.
     * 
     * Note that the display cannot be set to a.m. or p.m.
     * the value will remain the same as before
     */
    public void setTime(int hour, int minute, String amPm)
    {
        if(hour == 12)
        {
            hour = 0;
        }
        
        hours.setValue(hour);
        minutes.setValue(minute);
        
        /*
         * This part checks if the String parameter is "p.m.", and will set
         * it to p.m. if that is the case. Otherwise, it will set it to a.m.
         */
        clockAmPm = AM;
        if(amPm.equals(PM))
        {
            clockAmPm = PM;
        }
        
        updateDisplay();
    }

    /**
     * Return the current time of this display in the format HH:MMam
     */
    public String getTime()
    {
        return displayString;
    }
    
    /**
     * Update the internal string that represents the display.
     * the code has been updated to remove the zero by parseing to an int
     */
    private void updateDisplay()
    {
        String tempHour = hours.getDisplayValue();
        if (tempHour.equals("00"))
        {
            tempHour = "12";
        }
        int temp = Integer.parseInt(tempHour);        
        
        displayString = temp + ":" + 
            minutes.getDisplayValue() + clockAmPm;
    }
}
