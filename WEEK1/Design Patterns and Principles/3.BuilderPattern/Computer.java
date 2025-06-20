class Computer{
    String cpu,ram,storage;
    private Computer(Builder b) {
        cpu=b.cpu;
        ram=b.ram;
        storage=b.storage;
    }
    static class Builder{
        String cpu,ram,storage;
        Builder setCpu(String c) {
            cpu=c;
            return this;
        }
        Builder setRam(String r){
            ram=r;
            return this;
        }
        Builder setStorage(String s){
            storage=s;
            return this;
        }

        Computer build() {
            return new Computer(this);
        }
    }
    void show(){
        System.out.println("CPU: "+cpu);
        System.out.println("RAM: "+ram);
        System.out.println("Storage: "+storage);
    }
}
