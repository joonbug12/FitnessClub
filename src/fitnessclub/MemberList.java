
package fitnessclub;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

/**
 *array-based implementation of a linear data structure to hold a list of member
 * objects. An instance of this class is a growable list with an initial array capacity of 4, and it automatically
 * increases the capacity by 4 whenever it is full. The list does not decrease in capacity. An instance of this
 * class can hold a list of members with different types of membership.
 * @author Joon Song, Connor Powell
 */
public class MemberList {
    private Member[] members;
    private int size;
    private static final int NOT_FOUND = -1;

    /**
     * Default constructor for Member
     */
    public MemberList() {
        members = new Member[4];
        size=0;
    }


    /**
     * finds member
     * @param member to find
     * @return int place in the array, -1 if not found
     */
    private int find(Member member){
        for(int i=0; i<size; i++){
            if(members[i].compareTo(member)==0){
                return i;
            }
        }
        return NOT_FOUND;
    }

    /**
     * expands the array
     */
    private void grow(){
        Member[] temp = new Member[members.length+4];
        for(int i = 0; i < members.length; i++) {
            temp[i] = members[i];
        }
        members = temp;
    }

    /**
     * checks to see if array contains member
     * @param member to be checked
     * @return true if member exists in the array, false otherwise
     */
    public boolean contains(Member member) {
        return find(member) != NOT_FOUND;
    }

    public int getSize() {return size;}
    public Member [] getMembers() {return members;}

    public Member getMember(Member member) {
        if(contains(member))
            return members[find(member)];
        return null;
    }
    /**
     * adds a member to the end of the array
     * @param member to be added
     * @return true if added, false otherwise
     */
    public boolean add(Member member) {
        Date dob = member.getProfile().getDob();
        if (!dob.isValid()) {System.out.println("Invalid DOB"); return false;}
        if (!member.getProfile().getDob().over18()) {System.out.println("Not over 18"); return false;}
        if (contains(member)) {System.out.println("Member already in class");return false;}
        if (member.getProfile() == null || member.getLocation() == null || member.getExpirationDate()==null) {
            System.out.println("Missing information");
            return false;
        }
        if (size == members.length) {
            grow();
        }
        members[size] = member;
        size++;
        return true;
    }


    /**
     * removes an element from the array. Shift up to remove
     * @param member to be removes
     * @return true if removed, false otherwise
     */
    public boolean remove(Member member){
        int index = find(member);
        if(index==NOT_FOUND) {return false;}
        for (int i = index; i < members.length - 1; i++) {
            members[i] = members[i + 1];
        }
        members[members.length - 1] = null;
        size--;
        return true;
    }

    /**
     * puts the member into the array based on their membership
     * @param input tokens
     * @param index index array
     */
    public void addTheMember(String[] input,int index){
        String command = input[0];
        String fname = input[1];
        String lname = input[2];
        String dob = input[3];
        String expire = input[4];
        Location location = StudioManager.getLocation(input[5]);
        String[] dateBirth = dob.split("/");
        int month = Integer.parseInt(dateBirth[0]);
        int day = Integer.parseInt(dateBirth[1]);
        int year = Integer.parseInt(dateBirth[2]);
        String[] date = expire.split("/");
        int month1 = Integer.parseInt(date[0]);
        int day1 = Integer.parseInt(date[1]);
        int year1 = Integer.parseInt(date[2]);
        Date dateOfBirth = new Date(month, day, year);
        Date expires = new Date(month1, day1, year1);
        Profile profile = new Profile(fname, lname, dateOfBirth);
        switch(command){
            case "B" -> {
                Basic basic = new Basic(profile,expires,location);
                members[index] = (basic);
                System.out.println(basic);
            }
            case "F" -> {
                Family family = new Family(profile,expires,location);
                members[index] = (family);
                System.out.println(family);
            }
            case "P" -> {
                Premium premium = new Premium(profile,expires,location);
                members[index] = (premium);
                System.out.println(premium);
            }
        }
        grow();
        size++;
    }
    /**
     * Loads the list of members from text file
     * @param file to be loaded
     * @throws IOException error
     */
    public void load(File file) throws IOException{
        if(!file.exists() || !file.isFile()) {throw new IOException();}
        System.out.println("-list of members loaded-");
        Scanner scanner = new Scanner(file);
        int index=0;
        if(size==members.length) {grow();}
        do{
            String line = scanner.nextLine();
            String[] tokens = line.split("\\s");
            addTheMember(tokens, index);
            index++;
        }while(scanner.hasNextLine());
        System.out.println("-end of list-");
    }


    /**
     * sort by county, then zipcode
     */
    public void printByLocation(){
        if(members.length==0){
            System.out.println("Member database is empty");
        }
        if(size==1){
            System.out.println(members[0]);
            return;
        }
        int n=size;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n - i - 1; j++) {
                Member m1 = members[i];
                Member m2 = members[j];
                if (m1.getLocation().getCounty().compareTo(m2.getLocation().getCounty()) > 0) {
                    members[i] = m2;
                    members[j] = m1;
                } else if (m1.getLocation().getCounty().compareTo(m2.getLocation().getCounty()) == 0) {
                    if (m1.getLocation().getZipCode().compareTo(m2.getLocation().getZipCode()) > 0) {
                        members[i] = m2;
                        members[j] = m1;
                    }
                }
            }
        }
        for (int i = 0; i < size; i++) {
            System.out.println(members[i].toString());
        }
    }


    /**
     * sort by member profile. Last name first, then first name, then dob.
     */
    public void printByMembers(){
        if(size==0){
            System.out.println("Member database is empty");
            return;
        }
        if(size==1){
            System.out.println(members[0]);
            return;
        }
        int n = size;
        for (int i = 0; i < n -1 ; i++) {
            for (int j = i + 1; j < n - i - 1; j++) {
                Member m1 = members[i];
                Member m2 = members[j];
                if (m1.getProfile().getLastName().compareTo(m2.getProfile().getLastName()) > 0) {
                    members[i] = m2;
                    members[j] = m1;
                }else if (m1.getProfile().getLastName().compareTo(m2.getProfile().getLastName()) == 0) {
                    if (m1.getProfile().getFirstName().compareTo(m2.getProfile().getFirstName()) > 0) {
                        members[i] = m2;
                        members[j] = m1;
                    }else if (m1.getProfile().getFirstName().compareTo(m2.getProfile().getFirstName()) == 0) {
                        if (m1.getProfile().getDob().compareTo(m2.getProfile().getDob()) > 0) {
                            members[i] = m2;
                            members[j] = m1;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < size; i++) {
            System.out.println(members[i].toString());
        }
    }


    /**
     * print the array as is with the next due amounts
     */
    public void printFees(){
        for (int i=0; i<size; i++) {
            System.out.println(members[i] + " [next due: $" + members[i].bill() + "]");
        }
    }

}
