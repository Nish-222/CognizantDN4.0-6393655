class Book {
    String id,title,author;

    Book(String id,String title,String author) {
        this.id=id;
        this.title=title;
        this.author=author;
    }

    public String toString() {
        return id+" "+title+" "+author;
    }
}

public class LMS {
    static Book[] books={
        new Book("B1","Mathematics","Petr"),
        new Book("B2","English","Henry"),
        new Book("B3","Physics","Stephen"),
        new Book("B4","Social","James")
    };

    static Book linearSearch(String key) {
        for(Book b:books)
            if(b.title.equalsIgnoreCase(key))
                return b;
        return null;
    }

    static void sortBooks() {
        for(int i=0;i<books.length-1;i++) {
            for(int j=0;j<books.length-i-1;j++) {
                if(books[j].title.compareToIgnoreCase(books[j+1].title)>0) {
                    Book temp=books[j];
                    books[j]=books[j+1];
                    books[j+1]=temp;
                }
            }
        }
    }

    static Book binarySearch(String key) {
        int l=0,r=books.length-1;
        while(l<=r) {
            int m=(l+r)/2;
            int cmp=books[m].title.compareToIgnoreCase(key);
            if(cmp==0) return books[m];
            if(cmp<0) l=m+1;
            else r=m-1;
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println("Linear Search for 'Social':");
        Book b1=linearSearch("Social");
        System.out.println(b1!=null?b1:"Not Found");

        sortBooks();
        System.out.println("\nBinary Search for 'Social':");
        Book b2=binarySearch("Social");
        System.out.println(b2!=null?b2:"Not Found");
    }
}
