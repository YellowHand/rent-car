package pl.yellow.rentallo.domain.enumeration;


public enum FuelType {
    GAS("Gas fuel"),
    OIL("Oil fuel"),
    GASOLINE("Gasoline fuel"),
    ELECTRIC("Electricity"),
    HYBRID("Hybrid");
    FuelType(String fuelDesc) {
        this.fuelDesc = fuelDesc;
    }
    public String fuelDescription() {
        return fuelDesc;
    }
    private String fuelDesc;
}
