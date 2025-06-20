class RealImage implements Image {
    String filename;
    RealImage(String name) {
        filename=name;
        loadFromServer();
    }
    void loadFromServer(){
        System.out.println("Loading "+filename+" from server...");
    }
    public void display(){
        System.out.println("Displaying "+filename);
    }
}
