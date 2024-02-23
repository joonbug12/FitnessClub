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
}
