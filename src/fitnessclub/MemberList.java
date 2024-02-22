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
        //dont add if nonvalid date
        //date is today or after
        //under 18
        //invalid city member.getLocation()==null
        //member already in database, use find
        //not enough data tokens to add
        Date dob = member.getProfile().getDob();
        boolean added = false;
        added = dob.isValid();
        added = dob.over18(dob);
        added = member.getLocation() != null;
        added = !members.contains(member);
        if(added){
            members[size]=member;
        }
        return added;
    }

    /**
     * removes an element from the array. Shift up to remove
     * @param member to be removes
     * @return true if removed, false otherwise
     */
    public boolean remove(Member member){
        return false;
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
     * sort by county then zipcode
     */
    public void printByCounty(){

    }

    /**
     * sort by member profile
     */
    public void printByMember(){

    }

    /**
     * print the array as is with the next due amounts
     */
    public void printFees(){

    }


}

