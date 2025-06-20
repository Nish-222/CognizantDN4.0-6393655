class Student {
    String name;
    String id;
    String grade;
    Student(String name,String id,String grade) {
        this.name=name;
        this.id=id;
        this.grade=grade;
    }
    void setName(String n){
    	name = n; }
    void setGrade(String g){
    	grade = g; }
    String getName(){
    	return name; }
    String getId(){
    	return id; }
    String getGrade(){
    	return grade; }
}
