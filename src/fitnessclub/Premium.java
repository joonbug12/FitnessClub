package fitnessclub;

/**
 * extends member class and includes instance variable guestPass to keep track of num guests
 * @author Joon Song, Connor Powell
 */
public class Premium extends Member{
    private int guestPass;


    /**
     * constructor
     *
     * @param profile profile
     * @param expire expire date
     * @param homeStudio location
     */
    public Premium(Profile profile, Date expire, Location homeStudio) {
        super(profile, expire, homeStudio);
        guestPass = 3;
    }

    /**
     * getter method
     * @return guestPasses left
     */
    public int getGuestPass() {
        return guestPass;
    }

    /**
     * setter method
     */
    public void addAGuest() {
        this.guestPass -=1;
        System.out.println("Guest added");
    }

    /**
     * getter method
     */
    public int numGuests() {return this.guestPass;}

    /**
     * bill method for premium
     */
    public double bill(){
        return 59.99 * 11; /*every year with one month free*/
    }

    /**
     * Premium to String
     */
    @Override
    public String toString(){
        return super.toString() + ", (Premium) guest pass remaining: " + guestPass;
    }
}
