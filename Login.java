import java.util.LinkedList;

class LinkedNode{
    String password;
    String username;
    LinkedNode next;
    LinkedNode( String username,String password){
        this.username=username;
        this.password=password;
    }
}
public class Login {
    LinkedNode[] login;
    int n;
    Login(int n){
        this.n=n;
        login=new LinkedNode[n];
    }
    int key(String Password){
        char[] arr= Password.toCharArray();
        int sum =0;
        for (int i = 0; i < arr.length; i++) {
          sum+=(int)arr[i] ;
        }
        return sum%n;
    }
    void insert(String Username,String Password){
        int idx=key(Password);
        LinkedNode node=new LinkedNode(Username,Password);
        if(login[idx]==null){
            login[idx]=node;
        }
        else{
            LinkedNode curr=login[idx];
            while(curr.next!=null) {
                curr = curr.next;
            }
            curr.next=node;
        }
    }
    void delete(String Username,String Password) {

        int idx = key(Password);
        if (login[idx] == null) {
            return;
        }
        LinkedNode curr = login[idx];
        LinkedNode prev = null;
        while(curr!=null&&!curr.password.equals(Password)){
            prev = curr;
            curr = curr.next;
        }
        prev=curr.next;
        curr=null;
        login[idx]=prev;
        return;
    }
    void update(String Username,String Password){
     int idx = key(Password);
       LinkedNode curr = login[idx];
        while(curr.next != null && !curr.password.equals(Password)) {
            curr = curr.next;
        }
        if(curr==null){
            System.out.println("No Id Found");
        return;
        }
        else{
            curr.password=Password;
            curr.username=Username;
        }
    }
    void Search(String Username,String Password){
        int idx=key(Password);
        if(login[idx]!=null&&login[idx].username.equals(Username)&&login[idx].password.equals(Password)){
            System.out.println("Found");
        }
        else{
            System.out.println("No Found");
        }

    }
    public void printHashTable() {
        for(int i = 0 ; i < n ; i++) {
            LinkedNode current = login[i];
            while(current != null) {
                System.out.println("Name " + current.username);
                System.out.println("Password " + current.password);
                current = current.next;
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
Login li = new Login(5);
li.insert("Ayesha", "AyeshaLeet");
li.insert("Ash","ash123");
        li.insert("As","ash13");
       li.insert("Ah","as2");
        li.insert("h","h123");

   li.delete("Ash","ash123");
        li.printHashTable();
        li.update("Ash","ash123");
        li.printHashTable();
        li.Search("Ash","23");
    }
}
