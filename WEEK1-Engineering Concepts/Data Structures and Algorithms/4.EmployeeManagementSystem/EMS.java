class Employee {
    String id,name,pos;
    double sal;
    Employee(String id,String name,String pos,double sal) {
        this.id=id;
        this.name=name;
        this.pos=pos;
        this.sal=sal;
    }
    public String toString() {
        return id+" "+name+" "+pos+" ₹"+sal;
    }
}
public class EMS {
    static Employee[] empArr=new Employee[100];
    static int count=0;

    static void add(Employee e) {
        if(count<empArr.length) empArr[count++]=e;
    }
    static Employee search(String id) {
        for(int i=0;i<count;i++)
            if(empArr[i].id.equals(id))
                return empArr[i];
        return null;
    }
    static void traverse() {
        for(int i=0;i<count;i++)
            System.out.println(empArr[i]);
    }
    static void delete(String id) {
        for(int i=0;i<count;i++) {
            if(empArr[i].id.equals(id)) {
                for(int j=i;j<count-1;j++)
                    empArr[j]=empArr[j+1];
                empArr[--count]=null;
                break;
            }
        }
    }

    public static void main(String[] args) {
        add(new Employee("E1","Arya","HR",50000));
        add(new Employee("E2","Ayan","Dev",65000));
        add(new Employee("E3","Arun","Manager",80000));
        
        System.out.println("All Employees:");
        traverse();

        System.out.println("\nSearch E2:");
        System.out.println(search("E2"));

        delete("E1");
        System.out.println("\nAfter Deleting E1:");
        traverse();
    }
}
