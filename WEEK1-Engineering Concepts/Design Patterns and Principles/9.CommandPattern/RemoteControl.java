class RemoteControl {
    Command cmd;
    void setCommand(Command c){
        cmd = c;
    }
    void pressButton(){
        cmd.execute();
    }
}
