package fitnessclub;

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
        if (this.fname.compareToIgnoreCase(profile.fname) > 0) {return 1;}
        if (this.fname.compareToIgnoreCase(profile.fname) < 0) {return -1;}
        if (this.lname.compareToIgnoreCase(profile.lname) > 0) {return 1;}
        if (this.lname.compareToIgnoreCase(profile.lname) < 0) {return -1;}
        if(this.dob.compareTo(profile.dob)>0) {return 1;}
        if (this.dob.compareTo(profile.dob) < 0) {return -1;}
        return 0;

    }

    /**
     * checks if profiles are equal
     * @return true if equal, false if not
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Profile profile) {
            return this.compareTo(profile) == 0;
        }
        return false;
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

