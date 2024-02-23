package fitnessclub;

public enum Location {
    Bridgewater,
    Edison,
    Franklin,
    Piscataway,
    Somerville();
    private final String city;
    private final String zipCode;
    private final String county;

    Location(String city, String zipCode, String county) {
        this.city = city;
        this.zipCode = zipCode;
        this.county = county;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCounty() {
        return county;
    }
}
