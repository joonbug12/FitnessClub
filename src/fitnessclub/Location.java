package fitnessclub;

/**
 *Enum class defining the studio locations
 * @author Joon Song, Connor Powell
 */
public enum Location {

    Bridgewater("Bridgewater","08807","Somerset County"),
    Edison("Edison" , "08837", "Middlesex County"),
    Franklin("Franklin", "08873", "Somerset County"),
    Piscataway("Piscataway", "08873", "Middlesex County"),
    Somerville("Somerville", "08876", "Somerset County");

    private final String city;
    private final String zipCode;
    private final String county;

    /**
     * constructor
     * @param city city
     * @param zipCode zip
     * @param county county
     */
    Location(String city, String zipCode, String county) {
        this.city = city;
        this.zipCode = zipCode;
        this.county = county;
    }

    /**
     * getter method
     * @return city
     */
    public String getCity() {return city;}

    /**
     * getter method
     * @return zipcode
     */
    public String getZipCode() {return zipCode;}

    /**
     * getter method
     * @return county
     */
    public String getCounty() {return county;}
}
