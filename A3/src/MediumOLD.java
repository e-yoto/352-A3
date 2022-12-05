import java.util.NoSuchElementException;

public class MediumOLD extends ElasticERL{

    //Heap

    private Small<Integer, String> heap;
    private int heapSize;

    public MediumOLD(int size)
    {
        heap = new Small<>(size);
        heapSize = 0;
        //heap = new int[ size+1];
        for (int i = 0; i < size; i++)
            heap.addFirst(-1 , "");
    }
    
    public boolean isEmpty()
    {
        return heapSize == 0;
    }

    public boolean isFull()
    {
        return heapSize == heap.size();
    }

    private int parent(int i)
    {
        return (i-1)/2;
    }

    private int kthChild(int i,int k)
    {
        return 2 * i + k;
    }

    public String getValue(int key)
    {
        Node<Integer, String> temp;
        for (int i = 0; i < heapSize; i++)
        {
            temp = heap.get(i);
            System.out.println("CURRENT: " + temp.key + " " + temp.value);
            
            if (temp.key == key)
            {
                return temp.value;
            }
        }

        return null;
    }

    public void add(int key, String value)
    {
        System.out.println(key + " " + value);
        if(isFull())
        {
            throw new NoSuchElementException("Full heap");
        }
        
        //heap[heapSize++] = n;
        heap.set(heapSize++, key, value);
        Node<Integer, String> n = heap.get(heapSize+1);
        //System.out.println("MEDIUM added: " + n.key + " " + n.value);
        heapifyUp(heapSize-1);
    }

    public int delete(int x)
    {
        if(isEmpty())
        {
            throw new NoSuchElementException("Heap is already empty");
        }
            
        //int key = heap[x];
        int key = heap.get(x).key;
        
        
        //heap[x] = heap[heapSize -1];
        heapSize--;
        heapifyDown(x);
        return key;
    }

    private void heapifyUp(int i) 
    {
        Node<Integer, String> temp = heap.get(i);
        while(i > 0 && temp.key > heap.get(parent(i)).key)
        {
            heap.set(i, heap.get(parent(i)).key, heap.get(parent(i)).value);
            i = parent(i);
        }
        heap.get(i).key = temp.key;
    }

    private void heapifyDown(int i)
    {
        Node<Integer, String> child;
        Node<Integer, String> temp = heap.get(i);

        while(kthChild(i, 1) < heapSize)
        {
            child = maxChild(i);
            if(temp.key < child.key)
            {
                heap.set(i, child.key, child.value);
            }
            else 
                break; 

            i = child.key; 
        }
        
        heap.set(i, temp.key, temp.value);
    } 
            
    private Node<Integer, String> maxChild(int i) 
    { 
        int leftChild = kthChild(i, 1);
        int rightChild = kthChild(i, 2); 
        
        if (heap.get(leftChild).key > heap.get(rightChild).key)
        {
            return heap.get(leftChild);
        }
        else
        {
            return heap.get(rightChild);
        }
    }

    public void printHeap()
    {
        System.out.print("nHeap = ");

        for (int i = 0; i < heapSize; i++)
            System.out.print(heap.get(i) +" ");
    }

    public Node<Integer, String> findMax()
    {
        if(isEmpty())
        {
            throw new NoSuchElementException("Heap is empty.");
        }
        
        return heap.get(0);
    }

    public void printAll()
    {
        for (int i =0; i < heapSize; i++)
        {
            Node<Integer, String> temp;
            temp = heap.get(i);
            System.out.println("AUGH: " + temp.key + " " + temp.value);
            
    }
    }
}
