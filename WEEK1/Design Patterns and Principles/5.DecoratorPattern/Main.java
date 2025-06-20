public class Main{
    public static void main(String[] args){
        Notifier n1=new EmailNotifier();
        Notifier n2=new SMSNotifierDecorator(n1);
        Notifier n3=new SlackNotifierDecorator(n2);
        n3.send();
    }
}
