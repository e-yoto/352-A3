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

    public int get(int index) 
    {
        
        Node<Integer, String> current = head;
        int i = 0;
        while (i < index)
        {
            current = current.next;
            i++;
        }
        return current.key;
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
    

    public int size() {
        return size;
    }

}
