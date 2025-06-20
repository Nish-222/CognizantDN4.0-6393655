public class Main{
    public static void main(String[] args){
        Computer c1=new Computer.Builder()
                        .setCpu("i6")
                        .setRam("16GB")
                        .setStorage("512GB SSD")
                        .build();

        c1.show();
    }
}
