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

    /**
     * bill method for family
     */
    @Override
    public double bill(){
        return 49.99 * 3; //every 3 months
    }

    public boolean isGuest() {
        return guest;
    }

    public void setGuest(boolean guest) {
        this.guest = guest;
    }

    /**
     * Family to String
     * @return family member as a string
     */
    @Override
    public String toString(){
        int guests;
        if(guest){
            guests=0;
        }else{
            guests=1;
        }
        return super.toString() + ", (Family) guest-pass remaining: " + guests;
    }
}
