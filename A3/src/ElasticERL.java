import java.util.Random;

public class ElasticERL {

    private int size;
    
    private int ERL_TYPE;
    final int SIZE_SMALL = 1;
    final int SIZE_MEDIUM = 2;
    final int SIZE_LARGE = 3;

    Small<Integer, String> smallErl;
    Medium mediumErl;
    Large largeErl;
    
    public ElasticERL(){
    }

    public ElasticERL(int size){
        SetEINThreshold(size);
    }
    
    public void SetEINThreshold(int size){
        this.size = size;
        if (size >= 0 && size < 100)
        {
            //small
            ERL_TYPE = SIZE_SMALL;
            smallErl = new Small<>(size);
        }
        else if(size >= 100 && size < 500000)
        {
            //medium
            ERL_TYPE = SIZE_MEDIUM;
            mediumErl = new Medium(size);
        }
        else if (size >= 500000)
        {
            ERL_TYPE = SIZE_LARGE;
            largeErl = new Large(size);
        }
        else
            System.out.println("Invalid size.");
    }

    public void generate(){
        Random rand = new Random();

        int k = rand.nextInt(9000000) + 1000000;

        while (allKeys(this) == null)
        {
            k = rand.nextInt(9000000) + 1000000;
        }
        
        System.out.println("Unique key generated: " + k);
    }

    public int[] allKeys(ElasticERL e){
        switch(e.ERL_TYPE) 
        {
            case SIZE_SMALL:
                // code block
                break;
            case SIZE_MEDIUM:
                // code block
                break;
            case SIZE_LARGE:
                // code block
                break;
        }
        return null;
    }

    public void add(ElasticERL e, int key, String value){
        switch(e.ERL_TYPE) 
        {
            case SIZE_SMALL:
                // code block
                break;
            case SIZE_MEDIUM:
                // code block
                break;
            case SIZE_LARGE:
                largeErl.add(key, value);
                break;
        }
    }

    public void remove(ElasticERL e, int key){
        switch(e.ERL_TYPE) 
        {
            case SIZE_SMALL:
                // code block
                break;
            case SIZE_MEDIUM:
                // code block
                break;
            case SIZE_LARGE:
                largeErl.remove(key);
                break;
        }
    }

    public String getValues(ElasticERL e, int key){
        switch(e.ERL_TYPE) 
        {
            case SIZE_SMALL:
                // code block
                break;
            case SIZE_MEDIUM:
                // code block
                break;
            case SIZE_LARGE:
                return largeErl.getValue(key);
        }

        return null;
    }

    public int nextKey(ElasticERL e, int key){
        int k = -1;
        switch(e.ERL_TYPE) 
        {
            case SIZE_SMALL:
                // code block
                break;
            case SIZE_MEDIUM:
                // code block
                break;
            case SIZE_LARGE:
                k =largeErl.nextKey(key);
                break;
        }
        return k;
    }

    public int prevKey(ElasticERL e, int key){
        int k = -1;
        switch(e.ERL_TYPE) 
        {
            case SIZE_SMALL:
                // code block
                break;
            case SIZE_MEDIUM:
                // code block
                break;
            case SIZE_LARGE:
                k = largeErl.prevKey(key);
                break;
        }
        return k;
    }

    public int[] rangeKey(int key1, int key2){
        
        switch(this.ERL_TYPE) 
        {
            case SIZE_SMALL:
                // code block
                break;
            case SIZE_MEDIUM:
                // code block
                break;
            case SIZE_LARGE:
                return largeErl.rangeKey(key1, key2);
        }
        return null;
    }

    public void listAll(ElasticERL e){
        switch(this.ERL_TYPE) 
        {
            case SIZE_SMALL:
                // code block
                break;
            case SIZE_MEDIUM:
                // code block
                break;
            case SIZE_LARGE:
                largeErl.listAll();
                break;
        }
    }
}