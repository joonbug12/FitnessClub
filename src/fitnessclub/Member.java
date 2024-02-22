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
     * getter method
     * @return homeStudio, and homeStudio will be null if an invalid input is entered
     */
    public Location getLocation() {return this.homeStudio;}

    /**
     * getter method
     * @return expire date
     */
    public Date getExpirationDate() {return this.expire;}

    /**
     * getter method
     * @return profile
     */
    public Profile getProfile() {return this.profile;}

    /**
     * checks to see if 2 members are the same member
     * @param obj member to be compared
     * @return true if same, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Member member) {
            return this.profile.equals(member.profile) && this.expire.equals(member.expire)
                    &&this.homeStudio.equals(member.homeStudio);
        }
        return false;
    }

    /**
     * compares 2 members
     * @param member the object to be compared.
     * @return
     */
    public int compareTo(Member member){
        if(this.profile.compareTo(member.profile)>0) {return 1;}
        if(this.profile.compareTo(member.profile)<0) {return -1;}
        return 0;
    }



    /**
     * this method is used to obtain the next due amount
     * @return double amount
     */
    public double bill(){
        return 0.0;
    }


}

