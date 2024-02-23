package fitnessclub;

public class Family extends Member{
    private boolean guest;


    /**
     * constructor
     *
     * @param profile
     * @param expire
     * @param homeStudio
     */
    public Family(Profile profile, Date expire, Location homeStudio) {
        super(profile, expire, homeStudio);
    }
}
