package fitnessclub;
/**
 * class
 */
public class FitnessClass{
    private Offer classInfo;
    private Instructor instructor;
    private Location studio;
    private Time time;
    private MemberList members;
    private MemberList guests;

    /**
     * constructor
     */
    public FitnessClass(Offer classInfo, Instructor instructor, Location studio, Time time,
                        MemberList members, MemberList guests){
        this.classInfo=classInfo;
        this.instructor=instructor;
        this.studio=studio;
        this.time=time;
        this.members=members;
        this.guests=guests;
    }

    /**
     * getter method
     * @return class info
     */
    public Offer getClassInfo() {return this.classInfo;}

    /**
     * getter method
     * @return instructor
     */
    public Instructor getInstructor() {return this.instructor;}

    /**
     * getter method
     * @return studio
     */
    public Location getStudio() {return this.studio;}

    /**
     * getter method
     * @return time
     */
    public Time getTime() {return this.time;}

    /**
     * getter method
     * @return members
     */
    public MemberList getMembers() {return this.members;}

    /**
     * getter method
     * @return guests
     */
    public MemberList getGuests() {return this.guests;}

    /**
     * class to string
     * @return string class
     */
    @Override
    public String toString(){
        return this.classInfo.toString().toUpperCase() + "-" + this.instructor.toString().toUpperCase() + ", " +
                this.time +  ", " + this.studio.getCity().toUpperCase();
    }

    /**
     * print to string but without classinfo
     */
    public String printClass(){
        return this.instructor.toString().toUpperCase() + ", " + this.time +  ", " + this.studio.getCity().toUpperCase()
                +", " + this.studio.getZipCode() + ", " +  this.studio.getCounty().toUpperCase();
    }

    /**
     * Determines whet
     * @param fclass the class to compare to.
     * @return true if the instructor, the classinfo, and the location are the same, false otherwise
     */
    public boolean equals(FitnessClass fclass) {
        return fclass.getInstructor() == this.getInstructor() && fclass.getClassInfo() == this.classInfo
                && fclass.getStudio() == this.getStudio();
    }
}