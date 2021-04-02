public enum Command {

    GET_ALL_CONTACTS("GET ALL CONTACTS"),
    ADD_CONTACT("ADD CONTACT"),
    SEARCH("SEARCH"),
    SEARCH_ALL("SEARCH ALL");
    

    private String message;

    Command (String message){
        this.message = message;
    }
    
}
