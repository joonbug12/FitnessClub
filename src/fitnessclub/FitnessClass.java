package fitnessclub;

/**
 * includes offer, instructor, location, time, members, and guests in a class
 * @author Joon Song, Connor Powell
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
     * add method
     */
    public void addPerson(Member member){
        members.add(member);
    }

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
               this.time.getHour() + ":" + this.time.getMinute() + ", " + this.studio.getCity().toUpperCase();
    }

}

