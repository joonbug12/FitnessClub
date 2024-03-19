package fitnessclub;
public enum Time{
    MORNING(9,30) ,
    AFTERNOON (14,0),
    EVENING(18,30);

    private final int hour;
    private final int minutes;

    /**
     * constructor
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

    /**
     * Creates a string for the time.
     * @return String representation of the time
     */
    @Override
    public String toString() {
        if(this.minutes == 0) {
            return this.hour + ":00";
        }
        return this.hour + ":" + this.minutes;
    }
}