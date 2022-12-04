public interface MyList<Integer, String> {
    public int get(int key);
    public void set(int index, int key, String value);
    public void add(int index, int key, String value);
    public int size();
}
