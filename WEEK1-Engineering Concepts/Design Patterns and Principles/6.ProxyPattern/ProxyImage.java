class ProxyImage implements Image {
    String filename;
    RealImage realImg;
    ProxyImage(String name) {
        filename = name;
    }
    public void display() {
        if (realImg == null)
            realImg = new RealImage(filename);
        else
            System.out.println("Using cached "+filename);
        realImg.display();
    }
}
