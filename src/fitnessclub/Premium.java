package fitnessclub;

public class Premium extends Member{
    private int guestPass;


    /**
     * constructor
     *
     * @param profile
     * @param expire
     * @param homeStudio
     */
    public Premium(Profile profile, Date expire, Location homeStudio) {
        super(profile, expire, homeStudio);
    }

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
