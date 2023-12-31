import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaxHeap {

    List<Integer> heap;

    public MaxHeap() {
        heap = new ArrayList<>();
    }

    public MaxHeap(List<Integer> array) {
        buildHeap(array);
    }

    public void buildHeap(List<Integer> array) {
        heap = array;
        for (int i = getParent(heap.size() - 1); i >= 0; i--) {
            shifDown(i);
        }
    }

    private void shifDown(int currIndex) {
        int endIndex = heap.size() - 1;
        int leftIndex = getLeftChild(currIndex);

        while (leftIndex <= endIndex) {
            int rightIndex = getRightChild(currIndex);
            int indexToShift;
            if (rightIndex <= endIndex && heap.get(rightIndex) > heap.get(leftIndex)) {

                indexToShift = rightIndex;
            } else {
                indexToShift = leftIndex;

            }
            if (heap.get(currIndex) < heap.get(indexToShift)) {
                Collections.swap(heap, currIndex, indexToShift);
                leftIndex = getLeftChild(currIndex);
            } else {
                return;
            }
        }
    }

    private void shifUp(int currIndex) {
        int parentIndex = getParent(currIndex);

        while (parentIndex >= 0 && heap.get(parentIndex) < heap.get(currIndex)) {
            Collections.swap(heap, parentIndex, currIndex);
            currIndex = parentIndex;
            parentIndex = getParent(parentIndex);
        }

    }

    public int peek() {
        if (!heap.isEmpty()) {
            return heap.get(0);
        } else {
            return -1;
        }
    }

    public int removeElement() {
        int removed;
        if (!heap.isEmpty()) {
            Collections.swap(heap, 0, heap.size() - 1);
            
           removed = heap.remove(heap.size() - 1);
            shifDown(0);
            return removed;
        } else {
            System.out.println("empty heap");
        }
        return -1;
    }

    public void insert(int value) {
        heap.add(value);
        shifUp(heap.size() - 1);
    }

    public void display() {
        for (int i = 0; i < heap.size(); i++) {
            System.out.print(heap.get(i) + " ");
        }
    }

    private int getParent(int i) {
        return (i - 1) / 2;
    }

    private int getLeftChild(int i) {
        return (i * 2) + 1;
    }

    private int getRightChild(int i) {
        return (i * 2) + 2;
    }
    

  //__________________________________________________
  public List <Integer> heapSort(List<Integer> array){
    buildHeap(array);
    heapify();

    return array;
    
  }
  public void heapify() {
        if (!heap.isEmpty()) {
            Collections.swap(heap, 0, heap.size() - 1);
            shifDown(0);
            
        } else {
            System.out.println("empty heap");
        }
        
    }
     
    
    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>(Arrays.asList(5, 3, 8, 4, 2, 9, 1, 6, 7));
        MaxHeap heap1 = new MaxHeap();
        heap1.heapSort(array);
        heap1.display();

        
        // System.out.println(heap1.removeElement());

    }

}
