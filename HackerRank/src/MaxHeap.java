import java.io.*;
import java.util.*;
import java.util.stream.*;

// https://www.hackerrank.com/challenges/qheap1/problem

// Note: this hasn't passed a couple tests

public class MaxHeap {

    public static void start() {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        
        ArrayList<Integer> heap = new ArrayList<Integer>();
                
        for(int i = 0; i < t; i++) {
            int type = scan.nextInt();
            
            
            if(type == 1) {
                insert(heap, scan.nextInt());
            } else if(type == 2){
                delete(heap, scan.nextInt());
            } else {
                System.out.println(heap.get(0));
            }

            
        }

        scan.close();
    }
    
    public static void insert(List<Integer> heap, int val) {
        heap.add(val);
        int i = heap.size() - 1; 
        int parent = (i - 1) / 2;
        while (i != 0 && heap.get(parent) > heap.get(i)) { 
            int temp = heap.get(i); 
            heap.set(i, heap.get(parent)); 
            heap.set(parent, temp);
            i = parent; 
            parent = (i - 1) / 2;
        }
    }
    
    public static void heapify(List<Integer> heap, int i) {
        int l = 2*i + 1;
        int r = 2*i + 2;
        int smallest = i;
        if(l < heap.size() && heap.get(l) < heap.get(i)) smallest = l;
        if(r < heap.size() && heap.get(r) < heap.get(i)) smallest = r;
        if(smallest != i) {
            int temp = heap.get(i);
            heap.set(i, heap.get(smallest));
            heap.set(smallest, temp);
            heapify(heap, smallest);
        }
    }
    
    public static void delete(List<Integer> heap, int val) {
        int i = heap.indexOf(val);
        heap.remove(i);
        heapify(heap, 0);
    }
}