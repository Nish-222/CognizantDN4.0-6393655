class Task {
    String id,name,status;
    Task next;
    Task(String id,String name,String status) {
        this.id=id;
        this.name=name;
        this.status=status;
        this.next=null;
    }
    public String toString() {
        return id+" "+name+" "+status;
    }
}

public class TMS {
    static Task head=null;

    static void add(String id,String name,String status) {
        Task t=new Task(id,name,status);
        if(head==null) head=t;
        else {
            Task temp=head;
            while(temp.next!=null) temp=temp.next;
            temp.next=t;
        }
    }
    static Task search(String id) {
        Task temp=head;
        while(temp!=null) {
            if(temp.id.equals(id)) return temp;
            temp=temp.next;
        }
        return null;
    }

    static void traverse() {
        Task temp=head;
        while(temp!=null) {
            System.out.println(temp);
            temp=temp.next;
        }
    }
    static void delete(String id) {
        if(head==null) return;
        if(head.id.equals(id)) {
            head=head.next;
            return;
        }
        Task curr=head,prev=null;
        while(curr!=null && !curr.id.equals(id)) {
            prev=curr;
            curr=curr.next;
        }
        if(curr!=null) prev.next=curr.next;
    }
    public static void main(String[] args) {
        add("T1","Reading","Pending");
        add("T2","Writing","In Progress");
        add("T3","Testing","Pending");

        System.out.println("All Tasks:");
        traverse();

        System.out.println("\nSearch T2:");
        System.out.println(search("T2"));

        delete("T1");
        System.out.println("\nAfter Deleting T1:");
        traverse();
    }
}
