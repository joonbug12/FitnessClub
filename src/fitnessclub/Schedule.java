package fitnessclub;
import java.util.Scanner;
import java.io.IOException;
import java.io.File;


public class Schedule{
    private FitnessClass[] classes;
    private int numClasses;

    /**
     * default constructor
     */
    public Schedule() {
        int numClasses = 4;
        classes = new FitnessClass[numClasses];
    }
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
     * expands the array
     */
    private void growArray(){
        numClasses+=4;
        FitnessClass[] temp = new FitnessClass[numClasses];
        for(int i = 0; i < numClasses - 4; i++) {
            temp[i] = classes[i];
        }
        classes = temp;
    }

    /**
     * create class
     */
    public FitnessClass createClass(String[] string){
        Offer offer = StudioManager.getOffer(string[0]);
        Instructor instructor = StudioManager.getInstructor(string[1]);
        Time time = StudioManager.getTime(string[2]);
        Location location = StudioManager.getLocation(string[3]);
        return new FitnessClass(offer,instructor,location,time,null,null);
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
            if(tokens.length>=4){
                FitnessClass classy=createClass(tokens);
                classes[index]=classy;
                System.out.println(classy.toString());
                index++;
                growArray();
            }
        }while(scanner.hasNextLine());
        scanner.close();
        System.out.println("-end of class list-");
    }

}
