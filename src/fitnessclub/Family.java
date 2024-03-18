package fitnessclub;

/**
 * extends member class and includes instance variable guest to check if family member has guest
 * @author Joon Song, Connor Powell
 */
public class Family extends Member{
    private boolean guest;


    /**
     * constructor
     *
     * @param profile profile
     * @param expire expire date
     * @param homeStudio location
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


    /**
     * checks if person is guest
     * @return true if guest, false otherwise
     */
    public boolean isGuest() {
        return guest;
    }

    /**
     * getter method
     */
    public boolean containsGuest(){return guest;}

    /**
     * setter method
     */
    public void addNewGuest() {
        this.guest = true;
        System.out.println("Guest Added");
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
