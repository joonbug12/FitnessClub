package fitnessclub;

public class Member implements Comparable <Member>{
    private Profile profile;
    private Date expire;
    private Location homeStudio;

    /**
     * constructor
     */
    public Member(Profile profile, Date expire, Location homeStudio){
        this.profile = profile;
        this.expire = expire;
        this.homeStudio=homeStudio;
    }

    /**
     * this method is used to obtain the next due amount
     * @return double amount
     */
    public double bill(){
        return 0.0;
    }


}

