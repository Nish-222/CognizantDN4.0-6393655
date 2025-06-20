class SlackNotifierDecorator extends NotifierDecorator {
    SlackNotifierDecorator(Notifier n){
        super(n);
    }
    public void send(){
        notifier.send();
        System.out.println("Slack message sent");
    }
}
