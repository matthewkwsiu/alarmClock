
/**
 * AlarmClock uses the ClockDisplay12 class
 *
 * @author Matthew Siu
 * @version 2019.09.20
 */
public class AlarmClock
{
    private ClockDisplay12 clock; 
    private Alarm alarm;
    
    /**
     * contructor for AlarmClock. Sets the clock and alarm to midnight
     * sets the alarm to off
     */
    public AlarmClock()
    {
        clock = new ClockDisplay12();
        alarm = new Alarm();
    }
    
    /**
     * constructor for AlarmClock. Sets clock and alarm to the variables
     * given by the user. Variables should be error checked in the
     * ClockDisplay12 and Alarm
     */
    public AlarmClock(int clockHour, int clockMinute, String clockAmPm, 
    int alarmHour, int alarmMinute, String alarmAmPm, boolean onOff)
    {
        clock = new ClockDisplay12(clockHour,clockMinute,clockAmPm);
        alarm = new Alarm(alarmHour,alarmMinute,alarmAmPm,onOff);
    }
    
    /**
     * sets the time of the clock with the hour, minute, and amPm
     */
    public void setTime(int clockHour, int clockMinute, String clockAmPm)
    {
        clock.setTime(clockHour,clockMinute,clockAmPm);
    }
    
    /**
     * sets the time of the clock with the hour, minute, amPm, and onOff
     */
    public void setAlarmTime(int alarmHour, int alarmMinute, String alarmAmPm)
    {
        alarm.setTime(alarmHour,alarmMinute,alarmAmPm);
    }
    
    /**
     * checks if the time of the clock is equivalent to the time of the alarm
     * if so, the system will set off the alarm and output the string of 
     * "RING RING RING"
     * Also turns off the alarm
     */
    public void clockTick()
    {
        clock.timeTick();
        if(clock.getTime().equals(alarm.getTime()) && isAlarmSet())
        {
            System.out.println("RING RING RING");
        }
        unsetAlarm();
    }
    
    /**
     * turns the alarm on
     */
    public void setAlarm()
    {
        alarm.turnOn();
    }
    
    /**
     * turns the alarm off
     */
    public void unsetAlarm()
    {
        alarm.turnOff();
    }
    
    /**
     * returns the value of the clock 
     */
    public String getTime()
    {
        return clock.getTime();
    }
    
    /**
     * return the value of the alarm
     */
    public String getAlarmTime()
    {
        return alarm.getTime();
    }
    
    /**
     * returns true if the alarm is set, false otherwise
     */
    public boolean isAlarmSet()
    {
        return alarm.isSet();
    }
    
    
    
}
