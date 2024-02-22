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
     * compares 2 profiles
     * @return one/ zero, or -1
     */
    @Override
    public int compareTo(Profile profile){
        int value = 0;
        return value;
    }

    /**
     * checks if profiles are equal
     * @return true if equal, false if not
     */
    @Override
    public boolean equals(Obj obj){
        if(obj instanceof Profile) {
            Profile profile = (Profile) obj;
            return this.profile.equals(obj);
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

