class LightOnCommand implements Command {
    Light l;
    LightOnCommand(Light l){
        this.l = l;
    }
    public void execute(){
        l.on();
    }
}
