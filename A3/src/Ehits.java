public class Ehits {
    public static void main(String[] args) throws Exception {
        Large l = new Large(500000);
        System.out.println("helo");

        l.add(123, "123 VALUE");
        l.add(33240013, "33240013 VALUE");
        l.add(13240013, "13240013 VALUE");
        l.add(23240013, "23240013 VALUE");
        l.add(33240013, "33240013 VALUE 2");
        l.add(33240013, "33240013 VALUE 3");
        l.add(0, "FIRST VALUE");
        l.add(1, "FIRST VALUE");


        HashNode<Integer, String> h = l.get(0);
        //System.out.println("GOT: " + h.key + " " +  h.value);
        //l.remove(33240013);
        System.out.println("list all: ");
        l.listAll();
        String val = l.getValue(0);
        System.out.println("printing getValue: ");
        System.out.println(val);

        System.out.println("printing nextKey");
        int k = l.nextKey(13240013);
        System.out.println(k);
    }
}
