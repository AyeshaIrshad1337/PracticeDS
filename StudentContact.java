import java.util.Arrays;

public class StudentContact {
    int n;
    long[] ContactBook;
    StudentContact(int n ){
        this.n=n;
        ContactBook=new long[n];
        Arrays.fill(ContactBook,-1);
    }
    int key(int id){
        return id%n;
    }
void insert(int id,long contactNo){
    int key =key(id);
    if(ContactBook[key]==-1) ContactBook[key]=contactNo;
    else
        LinearProbabing(key,contactNo);
    }
    void LinearProbabing(int key,long contactNo){
        if(ContactBook[key]==-1) ContactBook[key]=contactNo;
        else
            LinearProbabing((key+1)%n,contactNo);
    }
    void search(int id,long number){
    int key = id%n;
    if(ContactBook[key]==-1){
        return;
    }
    if(ContactBook[key]==number) System.out.print("Found!!");
    else{
        for(int i =0;i <n;i++){
            if(ContactBook[i]==number){
                System.out.print("Found!!");
             return;
            }
        }
        System.out.println("Not Found");
    }
    }
    public static void main(String[] args) {
  StudentContact sC = new StudentContact(5);
        sC.insert(520,231346787);
        sC.insert(40,231346636);
        sC.insert(70,231346363);
        sC.insert(50,231346454);
        sC.insert(20,231346878);
        sC.search(40,231346636);
    }
}
