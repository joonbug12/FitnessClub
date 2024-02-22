package fitnessclub;

import java.util.Scanner;

public class StudioManager {

    /**
     * creates a member from input
     * @param input from input
     */
    private void createMember(String input){
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
     * input the location as a string and turns it into Location
     * @param input String input
     * @return Location
     */
    private Location getLocation(String input){
        if(input.equalsIgnoreCase("Bridgewater")){
            return Location.Bridgewater;
        }
        if(input.equalsIgnoreCase("Edison")){
            return Location.Edison;
        }
        if(input.equalsIgnoreCase("Franklin")){
            return Location.Franklin;
        }
        if(input.equalsIgnoreCase("Piscataway")){
            return Location.Piscataway;
        }
        if(input.equalsIgnoreCase("Somerville")){
            return Location.Somerville;
        }
        return null;
    }





    public void run () {
        Scanner scan = new Scanner(System.in);
        System.out.println("Studio Manager is up and running.");
        while(true) {
            String input = scan.nextLine();
            String command = "";
            if(input.indexOf(',') != -1) {
                command = input.substring(0, input.indexOf(","));
                input = input.substring(input.indexOf(",") + 1);
            }
            else
                command = input;
            //System.out.println(command);
            if(command.equals("AB")) {
                removeAlbum(input);
            }
            else if(command.equals("A")) {
                Album album = createAlbum(input);
                if(isValidAlbum(album)) {
                    if (collection.add(album))
                        System.out.println(album.getTitle() + " (" + album.getArtist().toString() + ") added to the collection.");
                    else
                        System.out.println(album.getTitle() + " (" + album.getArtist().toString() + ") is already in the collection.");
                }
            }
            else if(command.equals("R")) {
                createRating(input);
            }
            else if(command.equals("PD"))
                collection.printByDate();
            else if(command.equals("PG"))
                collection.printByGenre();
            else if(command.equals("PR"))
                collection.printByRating();
            else if(command.equals("Q"))
                break;
            else
                System.out.println("Invalid Command!");
        }
        scan.close();
        System.out.println("Collection Manager terminated.");
    }
}

