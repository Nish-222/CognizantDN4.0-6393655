class StudentController {
    Student s;
    StudentView v;
    StudentController(Student s,StudentView v) {
        this.s = s;
        this.v = v;
    }
    void setName(String n){
    	s.setName(n);
    }
    void setGrade(String g){
    	s.setGrade(g);
    }
    void updateView(){
        v.displayDetails(s.getName(),s.getId(),s.getGrade());
    }
}
