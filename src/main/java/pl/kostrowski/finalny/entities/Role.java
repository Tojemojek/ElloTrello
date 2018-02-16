package pl.kostrowski.finalny.entities;

public enum Role {

    TECHNICAL_GROUP_LEADER("Kierownik Zespołu Projektowego"),
    SENIOR_TECHNICIAN("Starszy projektant"),
    TECHNICIAN("Projektant"),
    SALESMAN("Handlowiec");

    private String description;

    Role(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}