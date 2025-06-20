abstract class NotifierDecorator implements Notifier {
    Notifier notifier;
    NotifierDecorator(Notifier n){
        notifier=n;
    }
}
