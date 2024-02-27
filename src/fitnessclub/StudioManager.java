package fitnessclub;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;

public class StudioManager{

    private static MemberList members;

    /**
     * constructor
     */
    public StudioManager(){
        members = new MemberList();
    }


    /**
     * creates a basic member from input
     * @param input from input
     */
    public static Basic createBasic(String[] input){;
        String fname = input[0];
        String lname = input[1];
        String dob = input[2];
        String expire = input[3];
        Location location = getLocation(input[4]);
        String[] dateBirth = dob.split("/");
        int month = Integer.parseInt(dateBirth[0]);
        int day = Integer.parseInt(dateBirth[1]);
        int year = Integer.parseInt(dateBirth[2]);
        String[] date = expire.split("/");
        int month1 = Integer.parseInt(date[0]);
        int day1 = Integer.parseInt(date[1]);
        int year1 = Integer.parseInt(date[2]);
        Date dateOfBirth = new Date(month,day,year);
        Date expires = new Date(month1,day1,year1);
        Profile profile = new Profile(fname,lname,dateOfBirth);
        return new Basic(profile,expires,location);
    }

    /**
     * creates a family member from input
     * @param input from input
     */
    public static Family createFamily(String[] input){
        String fname = input[0];
        String lname = input[1];
        String dob = input[2];
        String expire = input[3];
        Location location = getLocation(input[4]);
        String[] dateBirth = dob.split("/");
        int month = Integer.parseInt(dateBirth[0]);
        int day = Integer.parseInt(dateBirth[1]);
        int year = Integer.parseInt(dateBirth[2]);
        String[] date = expire.split("/");
        int month1 = Integer.parseInt(date[0]);
        int day1 = Integer.parseInt(date[1]);
        int year1 = Integer.parseInt(date[2]);
        Date dateOfBirth = new Date(month,day,year);
        Date expires = new Date(month1,day1,year1);
        Profile profile = new Profile(fname,lname,dateOfBirth);
        return new Family(profile,expires,location);
    }

    /**
     * creates a premium member from input
     * @param input from input
     */
    public static Premium createPremium(String[] input){
        String fname = input[0];
        String lname = input[1];
        String dob = input[2];
        Location location = getLocation(input[3]);
        String[] dateBirth = dob.split("/");
        int month = Integer.parseInt(dateBirth[0]);
        int day = Integer.parseInt(dateBirth[1]);
        int year = Integer.parseInt(dateBirth[2]);
        Date dateOfBirth = new Date(month,day,year);
        
        Profile profile = new Profile(fname,lname,dateOfBirth);
        return new Premium(profile,expires,location);
    }


    /**
     * input the location as a string and turns it into Location from enum class
     * @param input String input
     * @return Location
     */
    public static Location getLocation(String input){
        if(input.equalsIgnoreCase("Bridgewater")) {return Location.Bridgewater;}
        if(input.equalsIgnoreCase("Edison")) {return Location.Edison;}
        if(input.equalsIgnoreCase("Franklin")) {return Location.Franklin;}
        if(input.equalsIgnoreCase("Piscataway")) {return Location.Piscataway;}
        if(input.equalsIgnoreCase("Somerville")) {return Location.Somerville;}
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
     * @return true if the member has a valid dob, false otherwise
     */
    private void invalidInput(Member member) {
        if(!member.getProfile().getDob().isValid()) {
            System.out.println("DOB: " + member.getProfile().getDob().toString() + " invalid calendar date!");
        }
        if(member.getProfile().getDob().todayOrAfter()) {
            System.out.println("DOB: " + member.getProfile().getDob().toString() + " cannot be today or a future date!");
        }
        if(!member.getProfile().getDob().over18()){
            System.out.println("DOB: " + member.getProfile().getDob().toString() + " must be 18 or older!");
        }
        if(member.getLocation()==null){
            System.out.println("invalid studio location!");
        }
        if(members.contains(member)){
            System.out.println(member.getProfile().getFirstName() + " " + member.getProfile().getLastName() + " is already in the member database");
        }
        String date = member.getProfile().getDob().toString();
        for(int i=0; i<date.length(); i++){
            if(!Character.isDigit(date.charAt(i)) && date.charAt(i) != '/') {
                System.out.println("This date contains characters");
                return;
            }
        }
    }

    /**
     * helper method to add basic, family, or premium
     */
    public void addMember(String[] string){
        String command = string[0];
        for(int i=0; i<string.length-1; i++){
            string[i] = string[i+1];
        }

        if(string.length<4){
            System.out.println("Missing data tokens");
            return;
        }

        switch(command){
            case "AB" -> {
                Basic basic = createBasic(string);
                boolean result = members.add(basic);
                if (!result) {invalidInput(basic);}
                else {System.out.println(string[0] + " " + string[1] + " added");}
            }
            case "AF" -> {
                Family family = createFamily(string);
                boolean result = members.add(family);
                if (!result) {invalidInput(family);}
                else {System.out.println(string[0] + " " + string[1] + " added");}
            }
            case "AP" -> {
                Premium premium = createPremium(string);
                boolean result = members.add(premium);
                if (!result) {invalidInput(premium);}
                else {System.out.println(string[0] + " " + string[1] + " added");}
            }
        }
    }
    
    /**
     * Print members and classes
     */
    public void printMAndC(){

        MemberList myObject = new MemberList();
        File file = new File("/Users/joonsong/Desktop/Software Methodology /FitnessClub/memberList.txt");
        try {myObject.load(file);}
        catch (IOException e) {}

        Schedule myObject1 = new Schedule();
        File file1 = new File("/Users/joonsong/Desktop/Software Methodology /FitnessClub/classSchedule.txt");
        try {myObject1.load(file1);}
        catch (IOException e){}
    }
     /**
     * Removes specified member from the database. Sends message if unsuccessful
     * @param inputs that are used to create the member to remove
     */
    public void removeMembership(String [] inputs) {
        if(inputs.length < 4) {
            System.out.println("Missing data tokens.");
            return;
        }
        String first = inputs[1];
        String second = inputs[2];
        String dob = inputs [3];
        for(int i = 0; i < dob.length(); i++) {
            if (!Character.isDigit(dob.charAt(i)) && dob.charAt(i) != '/') {
                System.out.println("The date contains characters.");
                return;
            }
        }
        String [] dateBirth = dob.split("/");
        int month = Integer.parseInt(dateBirth[0]);
        int day = Integer.parseInt(dateBirth[1]);
        int year = Integer.parseInt(dateBirth[2]);
        Date date = new Date(month,day,year);
        Profile profile = new Profile(first,second,date);
        Member member = new Member(profile, null, null);
        boolean result = members.remove(member);
        if(!result)
            System.out.println(first + " " + second + " is not in the member database.");
        else
            System.out.println(first + " " + second + " removed.");
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
                case "C" -> {removeMembership(tokens);}
                case "S" -> {/*display class schedule with the current attendees;*/}
                case "PM" -> {members.printByMember();}
                case "PC" -> {members.printByLocation();}
                case "PF" -> {members.printFees();}
                case "R" -> {/*take attendance of a member attending a class and add the member to the class*/}
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

