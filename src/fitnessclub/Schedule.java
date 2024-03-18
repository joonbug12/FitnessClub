
package fitnessclub;
import java.util.Scanner;
import java.io.IOException;
import java.io.File;

/**
 * this class holds an arraylist of classes and loads classes in from an input file
 * @author Joon Song, Connor Powell
 */
public class Schedule{
    private FitnessClass[] classes;
    private int numClasses;
    private static final int NOT_FOUND = -1;

    /**
     * default constructor
     */
    public Schedule() {
        classes = new FitnessClass[4];
        numClasses=0;
    }
    public int find (FitnessClass fclass) {
        for(int i = 0; i < numClasses;i++) {
            if(classes[i].equals(fclass))
                return i;
        }
        return NOT_FOUND;
    }

    public boolean contains(FitnessClass fclass) {
        return find(fclass) != NOT_FOUND;
    }

    /**
     * expands the array
     */
    private void growArray(){
        FitnessClass[] temp = new FitnessClass[classes.length+4];
        for(int i = 0; i < numClasses; i++) {
            temp[i] = classes[i];
        }
        classes = temp;
    }

    /**
     * create class
     */
    public void addClass(String[] tokens, int index){
        Offer offer = StudioManager.getOffer(tokens[0]);
        Instructor instructor = StudioManager.getInstructor(tokens[1]);
        Time time = StudioManager.getTime(tokens[2]);
        Location location = StudioManager.getLocation(tokens[3]);
        FitnessClass theClass = new FitnessClass(offer,instructor,location,time,new MemberList(), new MemberList());
        classes[index] = theClass;
        //System.out.println(classes[index]);
        numClasses++;
        if(numClasses == classes.length)
            growArray();
    }

    /**
     * getter method
     */
    public FitnessClass[] getFitnessClasses(){
        return classes;
    }

    /**
     * getter method
     */
    public int getNumClasses(){return numClasses;}

    /**
     * Loads classes from text file
     * @param file to be loaded
     * @throws IOException error
     */
    public void load(File file) throws IOException {
        if(!file.exists() || !file.isFile()) {throw new IOException();}
        System.out.println("-fitness classes loaded-");
        Scanner scanner = new Scanner(file);
        int index = 0;
        if(numClasses==classes.length) {growArray();}
        do{
            String line = scanner.nextLine();
            String[] tokens = line.split("\\s");
            if(tokens.length>=4){
                addClass(tokens, index);
            }
            index++;
        }while(scanner.hasNextLine());
        printSchedule();
        scanner.close();
        System.out.println("-end of class list-");
    }


    public void printSchedule(){
        for(int i=0; i<numClasses;i++){
            System.out.println(classes[i]);
            if(classes[i].getMembers().getSize() > 0) {
                System.out.println("[attendees]");
                classes[i].getMembers().printByLocation();
            }
            if(classes[i].getGuests().getSize() > 0) {
                System.out.println("[guests]");
                classes[i].getGuests().printByLocation();
            }
        }
    }
}
