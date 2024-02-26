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
}
