package fitnessclub;

/**
 * hold first, last name, and date of birth
 * @author Joon Song, Connor Powell
 */
public class Profile implements Comparable<Profile>{
    private String fname;
    private String lname;
    private Date dob;

    /**
     * constructor
     */
    public Profile(String fname,String lname,Date dob){
        this.fname=fname;
        this.lname=lname;
        this.dob=dob;
    }

    /**
     * getter method
     * @return first name
     */
    public String getFirstName() {return this.fname;}

    /**
     * getter method
     * @return last name
     */
    public String getLastName() {return this.lname;}

    /**
     * getter method
     * @return date of bith
     */
    public Date getDob() {return this.dob;}


    /**
     * compares 2 profiles
     * @param profile to be compared
     * @return one/ zero, or -1
     */
    @Override
    public int compareTo(Profile profile){
        int lastNameComparison = lname.toLowerCase().compareTo(profile.lname.toLowerCase());
        if (lastNameComparison != 0) {
            return lastNameComparison;
        }
        int firstNameComparison = fname.toLowerCase().compareTo(profile.fname.toLowerCase());
        if (firstNameComparison != 0) {
            return firstNameComparison;
        }
        return this.dob.compareTo(profile.dob);

    }

    /**
     * checks if profiles are equal
     * @return true if equal, false if not
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Profile profile)) return false;
        return fname.equalsIgnoreCase(profile.fname) &&
                lname.equalsIgnoreCase(profile.lname) &&
                dob.compareTo(profile.dob) == 0;
    }

    /**
     * Profile to string
     * @return string
     */
    @Override
    public String toString(){
        return (this.fname + ":" + this.lname + ":" + this.dob);
    }
}

