public class Large extends ElasticERL {
    
    //HashTable with Chaining
    
    private HashNode<Integer, String>[] table;
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

        while (existingNode != null)
        {
            //overwrite if key exists
            if (existingNode.key == key)
            {
                existingNode.value = value;
                return;
            }
                

            existingNode = existingNode.next;
        }
        
        existingNode = table[bucket];
        newNode.next = existingNode;
        if (existingNode != null)
        {
            existingNode.prev = newNode;
        }
        table[bucket] = newNode;

    }

    public void remove (int key)
    {
        int bucket = key % this.size;
        HashNode<Integer, String> h = get(key);
        HashNode<Integer, String> temp = h;

        while (h.next != null)
        {
            if (h.key == key)
            {
                break;
            }
            
            //else keep moving
            temp = h;

            h = h.next;
        }

        if (h != null)
        {
            
            System.out.println("removing: " + h.key + ", " + h.value);
            if (h.next != null && h.prev == null)
            {
                h = h.next;
                temp.next = null;
                table[bucket] = h;
                
            }
            else if (h.next != null)
            {
                temp = h.prev;
                h = h.next;

                temp.next = h;
            }
            else
            {
                h = h.prev;
                h.next = null;
                temp = null;
            }
        }

    }

    public HashNode<Integer, String> get(int key)
    {
        int bucket = key % this.size;
        HashNode<Integer, String> h = table[bucket];
        

        while (h != null) 
        {
            if (h.key == key )
            {
                return h;
            }
                
            h = h.next;
        }
        
        
        return null;
    }

    public String getValue(int key)
    {
        int bucket = key % this.size;
        HashNode<Integer, String> h = table[bucket];
        System.out.println(h.value);
        do 
        {
            if (h.key == key)
            {
                return h.value;
            }
        } 
        while (h.next != null); 
        {
            if (h.key == key)
            {
                return h.value;
            }
            h = h.next;
        }

        return "Not found";
    }

    public int nextKey(int key)
    {
        int bucket = key % this.size;
        HashNode<Integer, String> h = table[bucket];



        while (h.next != null)
        {
            if (h.key == key)
            {
                return h.next.key;
            }
            h = h.next;
        }

        return -2;
    }

    public int prevKey(int key)
    {
        int bucket = key % this.size;
        HashNode<Integer, String> h = table[bucket];

        if (h.key == key)
        {
            //first in the bucket, there is no previous
            return -1;
        }
            
        while (h != null)
        {
            if (h.key == key)
                return h.prev.key;
            
            h = h.next;
        }

        return -2;
    }

    public int[] rangeKey(int k1, int k2)
    {
        if (k1 % this.size != k2 % this.size)
            return null;
        else
        {
            HashNode<Integer, String> h = table[k1 % this.size];
            HashNode<Integer, String> first = null;
            HashNode<Integer, String> second = null;
            Small<Integer, String> list = new Small<>();

            //find which comes first
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
                //second.value;
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
    }

    public void listAll()
    {
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

    public void listSorted()
    {
        Small<Integer, String> list = new Small<>();
        for (HashNode<Integer, String> h: table)
        {
            if (h == null)
            {
                continue;
            }

            list.addLast(h.key, h.value);

            HashNode<Integer, String> temp = h;
            while (temp.next != null)
            {
                temp = temp.next;
                list.addLast(h.key, h.value);
                h = h.next;
            }
        }

        int[] a = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
        {
            a[i] = list.get(i).key;
        }
    }

    
    
}