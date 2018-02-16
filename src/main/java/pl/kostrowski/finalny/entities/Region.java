package pl.kostrowski.finalny.entities;

public enum Region {

    NORTH("Północ - Gdańsk, Bygdoszcz"),
    SOUTH("Południe - Siemianowice Śląskie"),
    EAST("Wschód - Zielonka"),
    WEST("Zachód - Wrocław");

    private String description;

    Region(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}