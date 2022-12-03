public class Large extends ElasticERL {
    
    //HashTable with Chaining
    
    private HashNode<Integer, String>[] table;
    private HashNode<Integer, String> tail;
    private HashNode<Integer, String> head;
    private int size = 0;
    
    public Large(int size){
        super();
        table = new HashNode[size];
        this.size = size;
    }

    public void add(int key, String value){
        HashNode<Integer, String> newNode = new HashNode<Integer,String>(key, value, null, null);
        int bucket = key % this.size;

        HashNode<Integer, String> existingNode = table[bucket];
        System.out.println("bucket: " + bucket);
        if (existingNode == null)
        {
            table[bucket] = newNode;
            tail = newNode;
            head = newNode;
            
        }
        else
        {
            HashNode<Integer, String> temp = tail;
            tail.next = newNode;
            tail.prev = temp;
            tail = tail.next;
        }
    }

    public void remove (int key)
    {
        int bucket = key % this.size;
        HashNode<Integer, String> h = get(key);
        HashNode<Integer, String> temp = h;

        while (h.next != null)
        {
            System.out.println("augh" + temp.key + " " + temp.value);
            if (h.key == key)
            {
                break;
            }
            
            //else keep moving
            temp = head;
            
            h = h.next;
            
        }

        if (h != null)
        {
            
            System.out.println("removing: " + temp.key + ", " + temp.value);
            if (h.prev != null)
            {
                h.next = head.next;
            }
            else
            {
                h = h.next;
                temp = null;
            }
            size--;
        }

    }

    public HashNode<Integer, String> get(int key)
    {
        int bucket = key % this.size;

        HashNode<Integer, String> h = table[bucket];
        if (h.key == key)
        {
            return h;
        }
        else
        {
            return null;
        }
    }

    public void listAll(){
        for (HashNode<Integer, String> h: table)
        {
            if (h == null)
            {
                continue;
            }

            System.out.println(h.key + " " + h.value);

            HashNode<Integer, String> temp = h;
            while (temp.next != null)
            {
                temp = temp.next;
                System.out.println(temp.key + " " + temp.value);
                h = h.next;
            }
        }
    }
}