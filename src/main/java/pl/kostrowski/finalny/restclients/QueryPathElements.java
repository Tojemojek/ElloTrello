package pl.kostrowski.finalny.restclients;

public enum QueryPathElements {

    ALL_BOARDS("/1/members/me/boards/"),
    ALL_LISTS_FROM_BOARD("/1/boards/[boardId]/lists"),
    ALL_CARDS_FROM_BOARD("/1/boards/[boardId]/cards"),

    SINGLE_BOARD("/1/boards/[boardId]"),
    ALL_CARDS_FROM_LIST("/1/lists/[listId]/cards"),
    ADD_SINGLE_CARD("/1/cards?idList=[listId]"),
    UPDATE_SINGLE_CARD("/1/cards/[cardId]");

    String pathParam;

    QueryPathElements(String pathParam) {
        this.pathParam = pathParam;
    }

    public String getPathParam() {
        return pathParam;
    }

    public String replaceBoardId(String boardId) {
        return this.pathParam.replace("[boardId]", boardId);
    }

    public String addBoardId(String boardId) {
        return this.pathParam.replace("[boardId]", boardId);
    }

    public String replaceListId(String listId) {
        return this.pathParam.replace("[listId]", listId);
    }

    public String replaceCardId(String cardId){
        return this.pathParam.replace("[cardId]", cardId);
    }


}
