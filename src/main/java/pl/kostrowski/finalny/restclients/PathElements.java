package pl.kostrowski.finalny.restclients;

public enum PathElements {

    ALL_BOARDS("/1/members/me/boards/"),
    SINGLE_BOARD("/1/boards/"),
    SINGLE_LIST("/1/lists/"),
    ADD_SINGLE_CARD("1/cards");

    String pathParam;

    PathElements(String pathParam) {
        this.pathParam = pathParam;
    }

    public String getPathParam() {
        return pathParam;
    }
}
