import java.util.Arrays;
import java.util.Scanner;
class Node{
    int id;
    String name;
    long Number;
    Node next;
    Node(int id, String name, long Number){
        this.id = id;
        this.name = name;
        this.Number = Number;
    }

    @Override
    public String toString() {
        return  (this.id+" "+this.name+' '+this.Number);
    }
}
public class ContactBook {
    Node[] Book;
    int n;
    public ContactBook(int n) {
        this.n = n;
        Book = new Node[n];
           }
    void createRecord(){
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter ID: ");
    int id = sc.nextInt();
    System.out.print("\nEnter Name: ");
    String name=sc.next();
    System.out.print("\nEnter Phone Number: ");
    long Number = sc.nextLong();
    Node node = new Node(id, name, Number);
    int  key = id%n;
    if(Book[key]==null){
        Book[key]=node;
    }else{
        Node current=Book[key];
        while(current.next!= null){
            current=current.next;
        }
        current.next=node;
        current=current.next;
    }

}
    void display() {
  Node node=null;
        for (int i = 0; i < n; i++) {
        if(Book[i]!=null){
            node = Book[i];

        }
            while(node!=null){
                System.out.println(node.toString());
                node=node.next;
            }
        }
    }
    void Delete(int id){
        int key=id%n;
        Book[key]=null;
    }
    void Update(int id){
        int key=id%n;
        //System.out.print(Book[key].toString());
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Name : ");
       String name=sc.next();
        System.out.println("Enter the Contact Number  : ");
        long Number=sc.nextLong();
        Node node = new Node(id, name, Number);
        Book[key]=node;
    }

    public static void main(String[] args) {
        ContactBook c=new ContactBook(1);
        c.createRecord();
        c.createRecord();
        c.display();
        c.Delete(1);
       // c.display();
        c.Update(0);
        c.display();
    }
}