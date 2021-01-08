public enum Manufactured {
    FOREIGN ("импортный"),
    DOMESTIC ("отечественный");
    String name;
    Manufactured(String name) {
        this.name = name;
    }
    String getName(){
        return name;
    }
}
