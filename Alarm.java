
/**
 * This is an alarm class that uses the ClockDisplay12 class to add an 
 * alarm features to the clock
 *
 * @author Matthew Siu
 * @version 2019.09.20
 */
public class Alarm
{
    private ClockDisplay12 alarm;
    
    boolean alarmOn;
    boolean ON = true;
    boolean OFF = false;
    

    /**
     * Constructor for objects of class Alarm
     * sets time to 12:00 a.m.
     * sets alarm to off
     */
    public Alarm()
    {
        alarm = new ClockDisplay12();
        alarmOn = OFF;
    }
    
    /**
     * Contructor for objects of class alarm
     * allows clock to be set to a certain time, 
     * and also whether the alarm is on or not
     */
    
    public Alarm(int hour, int minute, String amPm, boolean onOff)
    {
        alarm = new ClockDisplay12(hour, minute, amPm);
        alarmOn = onOff;
    }
    
    /**
     * sets the time of the alarm
     */
    public void setTime(int hour, int minute, String amPm)
    {
        alarm.setTime(hour, minute, amPm);
    }
    
    /**
     * turns alarm on
     */
    public void turnOn()
    {
        alarmOn = ON;
    }
    
    /**
     * turns alarm off
     */
    public void turnOff()
    {
        alarmOn = OFF;
    }
    
    /**
     *  returns the time of the alarm
     */
    public String getTime()
    {
        return alarm.getTime();
    }
    
    /**
     * returns true if the alarm is set
     */
    public boolean isSet()
    {
        return alarmOn;
    }
    
    
}
