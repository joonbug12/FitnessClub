package fitnessclub;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;

/**
 * class used to run the project
 * @author Joon Song, Connor Powell
 */
public class StudioManager{

    private MemberList members;
    private Schedule classes;

    /**
     * Initialize members and schedule
     */
    public StudioManager() {
        members = new MemberList();
        classes = new Schedule();
    }


    /**
     * gets type of member
     *
     */
    private Member getMembership(String membership, Profile profile, Location location){
        Member member;
        switch (membership) {
            case "AB":
                Date expire = Date.basicExpire();
                member = new Basic(profile, expire, location);
                break;
            case "AF":
                Date expire2 = Date.familyExpire();
                member = new Family(profile, expire2,location);
                break;
            case "AP":
                Date expire3 = Date.premiumExpire();
                member = new Premium(profile, expire3, location);
                break;
            default:
                System.out.println("Invalid membership type");
                return null;
        }
        return member;
    }

    /**
     * creates a family member from input
     * @param input from input
     */
    public void addMember(String[] input){
        if(input.length<5){
            System.out.println("not enough data tokens");
            return;
        }
        String membership = input[0];
        String fname = input[1];
        String lname = input[2];
        String dob = input[3];
        Location location = getLocation(input[4]);
        if(location==null){
            System.out.println(input[4] + " invalid location");
            return;
        }
        String[] dateBirth = dob.split("/");
        int month, day, year;
        try {
            month = Integer.parseInt(dateBirth[0]);
            day = Integer.parseInt(dateBirth[1]);
            year = Integer.parseInt(dateBirth[2]);
        } catch (NumberFormatException e) {
            System.out.println(dob + " Contains characters");
            return;
        }
        Date dateOfBirth = new Date(month,day,year);
        Profile profile = new Profile(fname,lname,dateOfBirth);
        Member member = getMembership(membership,profile,location);
        if(member==null) return;
        boolean result = members.add(member);
        if(!result) {
            invalidAddInput(member);
        }
        else{
            System.out.println(fname + " " + lname + " has been added");
        }
    }

    /**
     * creates a basic member from input
     * @param input from input
     */
    public void removeMember(String[] input){
        if(input.length<4){
            System.out.println("not enough data tokens");
            return;
        }
        String fname = input[1];
        String lname = input[2];
        String dob = input[3];
        String[] dateBirth = dob.split("/");
        int month, day, year;
        try {
            month = Integer.parseInt(dateBirth[0]);
            day = Integer.parseInt(dateBirth[1]);
            year = Integer.parseInt(dateBirth[2]);
        } catch (NumberFormatException e) {
            System.out.println(dob + " Contains characters");
            return;
        }
        Date dateOfBirth = new Date(month,day,year);
        Profile profile = new Profile(fname, lname, dateOfBirth);
        Member member = new Member(profile, null, null);
        boolean result = members.remove(member);
        if(!result){
            System.out.println(fname + " " + lname + " is not in the database");
        }else{
            System.out.println(fname +" "+lname + " removed from database");
        }
    }

    /**
     * input the location as a string and turns it into Location from enum class
     * @param input String input
     * @return Location
     */
    public static Location getLocation(String input){
        if(input.equalsIgnoreCase("BRIDGEWATER")) {return Location.Bridgewater;}
        if(input.equalsIgnoreCase("EDISON")) {return Location.Edison;}
        if(input.equalsIgnoreCase("FRANKLIN")) {return Location.Franklin;}
        if(input.equalsIgnoreCase("PISCATAWAY")) {return Location.Piscataway;}
        if(input.equalsIgnoreCase("SOMERVILLE")) {return Location.Somerville;}
        return null;
    }

    /**
     * input the offer as a string and convert it to Offer from enum class
     * @param input String input
     * @return Offer
     */
    public static Offer getOffer(String input){
        if(input.equalsIgnoreCase("Cardio")) {return Offer.Cardio;}
        if(input.equalsIgnoreCase("Pilates")) {return Offer.Pilates;}
        if(input.equalsIgnoreCase("Spinning")) {return Offer.Spinning;}
        return null;
    }

    /**
     * input the instructor as a string and get Instructor from enum class
     * @param input String input
     * @return instructor
     */
    public static Instructor getInstructor(String input){
        if(input.equalsIgnoreCase("Jennifer")) {return Instructor.Jennifer;}
        if(input.equalsIgnoreCase("Kim")) {return Instructor.Kim;}
        if(input.equalsIgnoreCase("Denise")) {return Instructor.Denise;}
        if(input.equalsIgnoreCase("Davis")) {return Instructor.Davis;}
        if(input.equalsIgnoreCase("Emma")) {return Instructor.Emma;}
        return null;
    }

    /**
     * input time of day as a string and get Time from enum class
     * @param input String input
     * @return Time
     */
    public static Time getTime(String input){
        if(input.equalsIgnoreCase("Morning")) {return Time.MORNING;}
        if(input.equalsIgnoreCase("Afternoon")) {return Time.AFTERNOON;}
        if(input.equalsIgnoreCase("Evening")) {return Time.EVENING;}
        return null;
    }

    /**
     * Helper method that checks whether a member is valid to add
     * @param member to be tested if it is valid
     */
    private void invalidAddInput(Member member) {
        if(member.getProfile().getDob().todayOrAfter()) {
            System.out.println("DOB: " + member.getProfile().getDob().toString() + " cannot be today or a future date!");
            return;
        }
        if(!member.getProfile().getDob().isValid()) {
            System.out.println("DOB: " + member.getProfile().getDob().toString() + " invalid calendar date!");
            return;
        }
        if(!member.getProfile().getDob().over18()){
            System.out.println("DOB: " + member.getProfile().getDob().toString() + " must be 18 or older!");
            return;
        }
        if(member.getLocation()==null){
            System.out.println(member.getLocation() + " invalid studio location!");
            return;
        }
        if(members.contains(member)){
            System.out.println(member.getProfile().getFirstName() + " " + member.getProfile().getLastName() + " is already in the member database");
        }
    }

    /**
     * Print members and classes
     */
    public void printMAndC(){
        File file = new File("/Users/joonsong/Desktop/Software Methodology /FitnessClub/memberList.txt");
        try {members.load(file);}
        catch (IOException e) {}

        File file1 = new File("/Users/joonsong/Desktop/Software Methodology /FitnessClub/classSchedule.txt");
        try {classes.load(file1);}
        catch (IOException e){}
    }


    /**
     * helper method for R
     */
    public void commandR(String[] input){
        if(input.length<7){System.out.println("missing data tokens");return;}
        Offer typeClass = getOffer(input[1]);
        if(typeClass==null){System.out.println("Class doesn't exist"); return;}
        Instructor instructor = getInstructor(input[2]);
        if(instructor==null){System.out.println("instructor doesn't exist"); return;}
        Location city = getLocation(input[3]);
        if(city==null){
            System.out.println("Location doesn't exist"); return;
        }
        String fname = input[4];
        String lname = input[5];
        String dob = input[6];
        String [] dateBirth = dob.split("/");
        int month = Integer.parseInt(dateBirth[0]);
        int day = Integer.parseInt(dateBirth[1]);
        int year = Integer.parseInt(dateBirth[2]);
        Date date = new Date(month,day,year);
        Profile profile = new Profile(fname,lname,date);
        Member member = new Member(profile,date,city);
        if(!members.contains(member)){
            System.out.println("member isn't in the database"); return;
        }

    }



    /**
     * run the project
     */
    public void run (){
        printMAndC();
        Scanner scanner = new Scanner(System.in);
        System.out.println("StudioManager is up and running.");
        outerLoop: do{
            String line = scanner.nextLine();
            String[] tokens = line.split("\\s");
            String command = tokens[0];
            switch(command){
                case "AB","AF","AP" -> addMember(tokens);
                case "C" -> removeMember(tokens);
                case "S" -> classes.printSchedule();
                case "PM" -> members.printByMembers();
                case "PC" -> members.printByLocation();
                case "PF" -> members.printFees();
                case "R" -> commandR(tokens);
                case "U" -> {/*remove a member from a class*/}
                case "RG" -> {/*take attendance of a guest attending a class and add the guest to the class*/}
                case "UG" -> {/*remove guest from class*/}
                case "Q" -> {break outerLoop;}
                default -> System.out.println(command + " is an Invalid Command!");
            }
        }while(scanner.hasNextLine());
        scanner.close();
        System.out.println("StudioManager terminated.");
    }
}

