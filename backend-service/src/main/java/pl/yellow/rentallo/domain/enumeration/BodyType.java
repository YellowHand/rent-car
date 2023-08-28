package pl.yellow.rentallo.domain.enumeration;

public enum BodyType {
    HATCHBACK("Hatchback"),
    SEDAN("Sedan"),
    COMBI("Combi"),
    SUV("SUV"),
    PICKUP("Pickup"),
    VAN("VAN");
    private final String description;
    BodyType(String description) {
        this.description = description;
    }
    public String description() {
        return description;
    }
}
