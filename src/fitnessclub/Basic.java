package fitnessclub;

/**
 * extends member class and includes instance variable numClasses to keep track of the number of classes attended so far
 * @author Joon Song, Connor Powell
 */
public class Basic extends Member{
    private int numClasses;

    /**
     * constructor
     *
     * @param profile profile
     * @param expire expire date
     * @param homeStudio location
     */
    public Basic(Profile profile, Date expire, Location homeStudio) {
        super(profile, expire, homeStudio);
        int numClasses = 0;
    }

    /**
     * getter method
     * @return number classes
     */
    public int getNumClasses() {
        return numClasses;
    }

    /**
     * setter method
     * @param numClasses classes left
     */
    public void setNumClasses(int numClasses) {
        this.numClasses = numClasses;
    }

    /**
     * bill method for basic member
     */
    @Override
    public double bill(){
        double amount = 39.99;
        int exceedFour = 0;
        if(numClasses>4){
            exceedFour=numClasses-4;
        }
        return amount + (exceedFour*10.00);
    }

    public int getNumClasses() {
        return numClasses;
    }

    public void setNumClasses(int numClasses) {
        this.numClasses = numClasses;
    }

    /**
     * Basic to string
     * @return basic member as a string
     */
    @Override
    public String toString(){
        return super.toString() + ", (Basic) number of classes attended: " + this.numClasses;
    }
}
