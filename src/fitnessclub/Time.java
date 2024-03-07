package fitnessclub;

/**
 * enum class for time
 * @author Joon Song, Connor Powell
 */
public enum Time{
    MORNING(9,30) ,
    AFTERNOON (14,0),
    EVENING(18,30);

    private final int hour;
    private final int minutes;

    /**
     * constructor
     * @param hour hour
     * @param minutes minute
     */
     Time(int hour, int minutes){
         this.hour=hour;
         this.minutes=minutes;
     }

    /**
     * getter method
     * @return hour
     */
    public int getHour() {return this.hour;}

    /**
     * getter method
     * @return minute
     */
    public int getMinute() {return this.minutes;}
}
