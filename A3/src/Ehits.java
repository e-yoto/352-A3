public class Ehits {
    public static void main(String[] args) throws Exception {
        Large l = new Large(500000);
        System.out.println("helo");

        l.add(33240013, "FIRST VALUE");
        l.add(33240013, "SECOND VALUE");
        l.add(33240013, "THIRD VALUE");
        l.add(0, "FIRST VALUE");
        l.add(1, "FIRST VALUE");

        HashNode<Integer, String> h = l.get(0);
        System.out.println("GOT: " + h.key + " " +  h.value);

        l.listAll();
    }
}
