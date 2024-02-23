package fitnessclub;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class MemberList {
    private Member[] members;
    private int size;
    private static final int NOT_FOUND = -1;

    /**
     * Default constructor for Member
     */
    public MemberList() {
        int size = 4;
        members = new Member[size];
    }

    /**
     * finds member
     * @param member to find
     * @return int place in the array, -1 if not found
     */
    private int find(Member member){
        for(int i=0; i<members.length; i++){
            if(members[i].equals(member)){
                return i;
            }
        }
        return NOT_FOUND;
    }

    /**
     * expands the array
     */
    private void grow(){
        size+=4;
        Member[] temp = new Member[size];
        for(int i = 0; i < size - 4; i++) {
            temp[i] = members[i];
        }
        members = temp;
    }

    /**
     * checks to see if array contains member
     * @param member to be checked
     * @return true if member exists in the array, fqlse otherwise
     */
    public boolean contains(Member member) {
        return find(member) != NOT_FOUND;
    }


    /**
     * adds a member to the end of the array
     * @param member to be added
     * @return true if added, false otherwise
     */
    public boolean add(Member member){
        Date dob = member.getProfile().getDob();
        if(!dob.isValid()) {return false;}
        if(contains(member)) {return false;}
        if(member.getProfile()==null || member.getLocation()==null || member.getExpirationDate()==null){
            return false;
        }
        for(int i=0; i<size; i++){
            if(members[i]==null){
                members[i]=member;
            }
        }
        int temp = size;
        grow();
        Member[] tempo = members;
        return true;
        }

    /**
     * removes an element from the array. Shift up to remove
     * @param member to be removes
     * @return true if removed, false otherwise
     */
    public boolean remove(Member member){
        if(find(member)==NOT_FOUND) {return false;}
        int index = find(member);
        members[index] = null;
        for(int i=index+1; i<members.length; i++){
            members[i-1] = members[i];
        }
        members[members.length-1]=null;
        return true;
    }

    /**
     * Loads the list of members from text file
     * @param file to be loaded
     * @throws IOException
     */
    public void load(File file) throws IOException{
        if(!file.exists() || !file.isFile()) {throw new IOException();}

        Scanner scanner = new Scanner(file);
        while(!scanner.hasNextLine()){
            int index=0;
            String line = scanner.nextLine();
            Member member = StudioManager.createMember(line);
            members[index]=member;
            grow();
            index++;
        }
    }

    /**
     * sort by county, then zipcode
     */
    public void printByCounty(){
        for(int i=0; i<members.length-1; i++){
            for(int j=i+1; j<members.length; j++){
                Member m1 = members[i];
                Member m2 = members[j];
                if(m1.getLocation().getCounty().compareTo(m2.getLocation().getCounty())>0){
                    members[i]=m2;
                    members[j]=m1;
                }else if(m1.getLocation().getCounty().compareTo(m2.getLocation().getCounty())==0){
                    if(m1.getLocation().getZipCode().compareTo(m2.getLocation().getZipCode())>0){
                        members[i]=m2;
                        members[j]=m1;
                    }
                }
            }
            for(Member member:members) {System.out.println(member);}
        }
    }

    /**
     * sort by member profile. Last name first, then first name, then dob.
     */
    public void printByMember(){
        for(int i=0; i<members.length-1; i++){
            for(int j=i+1; j<members.length;j++){
                Member m1 = members[i];
                Member m2 = members[j];
                if(m1.getProfile().getLastName().compareTo(m2.getProfile().getLastName())>0){
                    members[i]=m2;
                    members[j]=m1;
                }else if(m1.getProfile().getLastName().compareTo(m2.getProfile().getLastName())==0){
                    if(m1.getProfile().getFirstName().compareTo(m2.getProfile().getFirstName())>0){
                        members[i]=m2;
                        members[j]=m1;
                    }else if(m1.getProfile().getFirstName().compareTo(m2.getProfile().getFirstName())==0){
                        if(m1.getProfile().getDob().compareTo(m2.getProfile().getDob())>0){
                            members[i]=m2;
                            members[j]=m1;
                        }
                    }
                }
            }
        }
        for(Member member:members) {System.out.println(member);}
    }

    /**
     * print the array as is with the next due amounts
     */
    public void printFees(){

    }


}

