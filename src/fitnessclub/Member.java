package fitnessclub;

/**
 * each member holds a profile, date of expiration, and a home location
 * @author Joon Song, Connor Powell
 */
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
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Member otherMember = (Member) obj;
        return this.profile.equals(otherMember.getProfile()) &&
                this.expire.equals(otherMember.getExpirationDate()) &&
                this.homeStudio.equals(otherMember.getLocation());
    }

    /**
     * compares 2 members
     * @param member the object to be compared.
     * @return int based on which is greater
     */
    public int compareTo(Member member){
        String className = this.getClass().getSimpleName();
        String otherClassName = member.getClass().getSimpleName();
        int typeComparison = className.compareTo(otherClassName);
        if (typeComparison != 0) {
            return typeComparison;
        }
        return this.profile.compareTo(member.profile);
    }

    /**
     * member to string
     * @return String
     */
    @Override
    public String toString(){
        return this.profile.toString() + ", Membership expired " + this.expire.toString() + ", Home Studio:" +
                this.homeStudio.getCity() + "," + this.homeStudio.getZipCode() + "," + this.homeStudio.getCounty();
    }


    /**
     * this method is used to obtain the next due amount
     * @return double amount
     */
    public double bill(){
        return 0.0;
    }


}

