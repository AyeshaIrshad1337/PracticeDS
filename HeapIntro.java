package Heap;

public class HeapIntro {
//    int arr[];
//    int size;
//    void create(int size){
//arr=new int[size];
//this.size=0;
////    }
//    void insertValue(int val){
//    arr[size++]=val;
//    size++;
//    heapify(size);
//    }
//    void heapify(int idx){
//        if(idx<=1){
//            return;
//        }
//        int parent=idx/2;
//        if(arr[idx]>arr[parent]){
//            sawp(idx,parent,arr);
//        }
//        heapify(parent);
//    }
    void insert(int[] arr){
        int n=arr.length;
        for (int i = n/2-1; i >= 0; i--) {
        heapifyBottomToTop(arr,  i);
        }
    }
    void heapifyBottomToTop(int[] arr,int idx){
        int left=2*idx+1,right=2*idx+2,larg=idx;
        if(left< arr.length && arr[left] >arr[larg] ) larg=left;
        if(right< arr.length && arr[right] >arr[larg] ) larg=right;
        if(larg!=idx) {sawp(idx,larg,arr);
        heapifyBottomToTop(arr,larg);
        }
    }
    void sawp(int a,int b,int[] arr){
        int tmp=arr[a];
        arr[a]=arr[b];
        arr[b]=tmp;
    }
    void print(int[] arr){
        for (int i = 0; i <arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    int extract(int[] arr){
        int size= arr.length;
        int data=arr[0];
        arr[0]=arr[arr.length-1];
        size--;
        heapiffyTopToBottom(1,arr,size);
        return data;

    }
    void heapiffyTopToBottom(int idx,int[] arr,int n){
        int left=2*idx,right=2*idx+1,sC=0;
        if(left>n) return;
        else if(n==left){
            if(arr[idx]>arr[left]){
                sawp(idx,left,arr);
            }
        }
        else{
            if(arr[left]>arr[right]) sC=left;
            else sC= right;
            if(arr[idx]<arr[sC]){
                sawp(idx,sC,arr);
            }
        }
        heapiffyTopToBottom(sC,arr,n);
    }
    public static void main(String[] args) {
    int arr[] = {40,50,70,10,15};
    HeapIntro heap = new HeapIntro();
    heap.insert(arr);
    heap.print(arr);
//    heap.create(5);
//    heap.insertValue(7);
//    heap.print();
    }

}
