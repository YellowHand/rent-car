package pl.yellow.rentallo.domain.enumeration;


public enum FuelType {
    GAS("gas fuel"),
    OIL("oil fuel"),
    GASOLINE("gasoline fuel"),
    ELECTRIC("electricity"),
    HYBRID("hybrid");
    FuelType(String fuelDesc) {
        this.fuelDesc = fuelDesc;
    }
    public String getFuelDesc() {
        return fuelDesc;
    }
    private String fuelDesc;
}
