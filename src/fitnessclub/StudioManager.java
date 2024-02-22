package fitnessclub;

import java.util.Scanner;

public class StudioManager {

    /**
     * creates a member from input
     * @param input from input
     */
    public static Member createMember(String input){
        Scanner scanner = new Scanner(input);
        String ignore = scanner.next();
        String fname = scanner.next();
        String lname = scanner.next();
        String expire = scanner.next();
        Location location = getLocation(scanner.next());
        String[] date = expire.split("/");
        int month = Integer.parseInt(date[0]);
        int day = Integer.parseInt(date[1]);
        int year = Integer.parseInt(date[2]);
        Date expires = new Date(month,day,year);
        Profile profile = new Profile(fname,lname,expires);
        Member member = new Member(profile,expires,location);
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
}

