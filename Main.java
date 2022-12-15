import java.util.Arrays;

//Hashing Introduction Practice
public class Main {
    int size;
    int[] arr;
    Main(int size){
        this.size=size;
        arr=new int[size];
        Arrays.fill(arr,0);
    }
    int key(int value){
        return value%size;
    }
    void insert(int value){
        int key =key(value);
        if(arr[key]==0){
            arr[key]=value;
        }
        else{
        collisiion(value,key);
        }
    }

void collisiion(int value, int key) {
    key = key + 1 % size;
    if (arr[key] == 0) {
        arr[key] = value;
          }
    else
        collisiion(value, key + 1);

}
    void print(){
        for (int i = 0; i < size; i++) {
            if(arr[i]!=0)
            System.out.print(arr[i]+"->");
        }
    }
    
    public static void main(String[] args) {
        Main o = new Main(7);
        o.insert(700);
        o.insert(50);
        o.insert(85);
        o.insert(92);
        o.insert(76);
        o.print();
    }
}