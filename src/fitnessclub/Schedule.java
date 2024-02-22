package fitnessclub;
import java.util.Scanner;
import java.io.IOException;
import java.io.File;


public class Schedule{
    private FitnessClass[] classes;
    private int numClasses;


    /**
     * Loads classes from text file
     * @param file to be loaded
     * @throws IOException
     */
    public void load(File file) throws IOException {
        if(!file.exists() || !file.isFile()) {throw new IOException();}

        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine()){
            int index = 0;
            Offer offer = StudioManager.getOffer(scanner.next());
            Instructor instructor = StudioManager.getInstructor(scanner.next());
            Time time = StudioManager.getTime(scanner.next());
            Location location = StudioManager.getLocation(scanner.next());
            FitnessClass fitClass = new FitnessClass(offer,instructor,location,time,null,null);
            classes[index]=fitClass;
            numClasses++;
            scanner.nextLine();
        }

    }
}
