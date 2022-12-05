public class Small<Integer, String> extends ElasticERL{

    //LinkedList

    private Node<Integer, String> head;
    private Node<Integer, String> tail;
    private int size;
    
    public Small() {
        head = null;
        tail = null;
    }

    public Small(int size) {
        head = null;
        tail = null;
        this.size = size;
        
    }

    public Node<Integer, String> get(int index) 
    {
        
        Node<Integer, String> current = head;
        int i = 0;
        while (i < index)
        {
            current = current.next;
            i++;
        }
        return current;
    }

    public int getNext(int index) 
    {
        
        Node<Integer, String> current = head;
        int i = 0;
        while (i < index)
        {
            current = current.next;
            i++;
        }
        return current.next.key;
        
    }

    public int getPrev(int index) 
    {
        
        Node<Integer, String> current = head;
        Node<Integer, String> trail = head;
        int i = 0;
        while (i < index)
        {
            trail = current;
            current = current.next;
            i++;
        }
        return trail.key;
    }

    public int[] rangeKey(int k1, int k2)
    {
        Node<Integer, String> h = head;
        Node<Integer, String> first = null;
        Node<Integer, String> second = null;
        Small<Integer, String> list = new Small<>();
        while (h != null)
        {
            if (h.key == k1 || h.key == k2)
            {
                first = h;
                break;
            }
            h = h.next; 
        }

        second = first.next;

        while (second != null)
        {
            if (second.key == k2)
                break;
            list.addLast(second.key, second.value);
            second = second.next;
        }

        int[] a = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
        {
            a[i] = list.get(i).key;
        }

        return a;
    }

    public void set(int index, int key, String value) {
        Node<Integer, String> current = head;
        for (int i = 0; i < index; i++)
        {
            current = current.next;
        }
        current.key = key;
        current.value = value;     
    }

    public void add(int index, int key, String value) {
        if(index <= 0)
        {
            addFirst(key,value);
        }
        else if (index >= size)
        {
            addLast(key,value);
        } 
        else
        {
            Node<Integer, String> current = head;
            
            for (int i = 1; i < index; i++)
            {
                current = current.next;
            }
            Node<Integer, String> tmp = current.next;
            current.next = new Node<Integer, String>(key, value);
            (current.next).next = tmp;
            size++;
        }
    }

    public void remove(int index) 
    {
        if (index <  0 || index >= size)
        {
            throw new IndexOutOfBoundsException();
        }
        else if(index == 0)
        {
            removeFirst();
        }
        else if(index == size-1)
        {
            removeLast();
        }
        else
        {
            Node<Integer, String> previous = head;
            for(int i = 1;i < index; i++)
            {
                previous = previous.next;
            }
            Node<Integer, String> current = previous.next;
            previous.next = current.next;
            size--;
            
        }
    }

    public void removeFirst()
    {
        //if (size != 0)
        if (! isEmpty())
        {
            head = head.next;
            size--;
            if (head == null)
            {
                tail = null;
            }
        }
        else
        {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
    }

    public void removeLast()
    {
        if (isEmpty())
        {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
        
        if (size == 1) 
        {
            head = tail = null;
            size--;
        } 
        
        else if (! isEmpty())
        {
            Node<Integer, String> current = head;
            
            while(current != tail)
            {
                current = current.next;
            }
            
            tail = current;
            tail.next = null;
            size--;
        }
    }

    public boolean isEmpty() 
    {
       return size == 0;
    }


    public void addFirst(int key, String value)
    {
        Node<Integer, String> newNode = new Node<>(key, value);
        newNode.next = head;
        head = newNode;
        size++;
        if (tail == null)
        {
            tail = head;
        }
    }

    public void addLast(int key, String value)
    {
        Node<Integer, String> newNode = new Node<Integer, String>(key, value);
        if (tail == null)
        {
            head = tail = newNode;
        }
        else
        {
            tail.next = newNode;
            tail = tail.next;
            
        }
        size++;
    }

    public void listAll()
    {
        Node<Integer, String> h = head;
        while (h.next != null)
        {
            System.out.print(h.key + " - " + h.value + " | ");
            h = h.next;
        }
    }
    

    public int size() {
        return size;
    }

}
