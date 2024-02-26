package fitnessclub;
import java.util.Scanner;
import java.io.IOException;
import java.io.File;


public class Schedule{
    private FitnessClass[] classes;
    private int numClasses;

    /**
     * constructor
     * @param classes classes
     * @param numClasses number classes in
     */
    public Schedule(FitnessClass[] classes, int numClasses) {
        this.classes = classes;
        this.numClasses=numClasses;
    }


    /**
     * Loads classes from text file
     * @param file to be loaded
     * @throws IOException
     */
    public void load(File file) throws IOException {
        if(!file.exists() || !file.isFile()) {throw new IOException();}

        System.out.println("-fitness classes loaded-");
        Scanner scanner = new Scanner(file);
        int index = 0;
        do{
            String line = scanner.nextLine();
            String[] tokens = line.split("\\s");
            Offer offer = StudioManager.getOffer(tokens[0]);
            Instructor instructor = StudioManager.getInstructor(tokens[1]);
            Time time = StudioManager.getTime(tokens[2]);
            Location location = StudioManager.getLocation(tokens[3]);
            FitnessClass fitClass = new FitnessClass(offer,instructor,location,time,null,null);
            classes[index]=fitClass;
            index++;
            numClasses++;
        }while(scanner.hasNextLine());
        scanner.close();

        for(FitnessClass theClass:classes){
            if (theClass != null) {
                System.out.println(theClass.toString());
            }
        }
        System.out.println("-end of class list-");
    }

    public static void main(String[] args){
        Schedule myObject = new Schedule(null,0);
        File file = new File("/Users/joonsong/Desktop/Software Methodology /FitnessClub/classSchedule.txt");
        try {
            myObject.load(file);
            System.out.println("File loaded and printed successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while loading the file: " + e.getMessage());
        }
    }
}
