public class Main {
    public static void main(String[] args) {
        Student s=new Student("Arya","001","A");
        StudentView v=new StudentView();
        StudentController c=new StudentController(s,v);
        c.updateView();
        c.setGrade("B");
        c.updateView();
    }
}
