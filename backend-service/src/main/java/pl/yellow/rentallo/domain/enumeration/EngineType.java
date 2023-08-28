package pl.yellow.rentallo.domain.enumeration;

public enum EngineType {
    ELECTRIC_MOTOR("Electric motor"),
    V10("V10"),
    V12("V12"),
    V8("V8");
    private final String description;
    EngineType(String description) {
        this.description = description;
    }
    public String description() {
        return description;
    }
}