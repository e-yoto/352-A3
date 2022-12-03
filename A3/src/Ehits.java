public class Ehits {
    public static void main(String[] args) throws Exception {
        Large l = new Large(500000);
        System.out.println("helo");

        l.add(123, "123 VALUE");
        l.add(33240013, "33240013 VALUE");
        l.add(13240013, "13240013 VALUE");
        l.add(23240013, "23240013 VALUE");
        l.add(0, "FIRST VALUE");
        l.add(1, "FIRST VALUE");
        

        HashNode<Integer, String> h = l.get(0);
        //System.out.println("GOT: " + h.key + " " +  h.value);
        l.remove(23240013);
        l.listAll();
    }
}
