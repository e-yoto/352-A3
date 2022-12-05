public class Ehits {
    public static void main(String[] args) throws Exception {

        // ElasticERL l = new ElasticERL(500000);
        // //Large l = new Large(500000);

        // l.add(l, 123, "123 VALUE");
        // l.add(l, 33240013, "33240013 VALUE");
        // l.add(l, 13240013, "13240013 VALUE");
        // l.add(l, 23240013, "23240013 VALUE");
        // l.add(l, 43240013, "43240013 VALUE");
        // l.add(l, 73240013, "73240013 VALUE");
        // l.add(l, 33240013, "33240013 SECOND VALUE");
        // l.add(l, 0, "0 VALUE");
        // l.add(l, 1, "1 VALUE");


        // //l.remove(33240013);

        // System.out.println("list all: ");
        
        // String val = l.getValues(l, 0);
        // System.out.println("printing getValue: ");
        // System.out.println(val);

        // System.out.println("printing nextKey");
        // int k = l.nextKey(l, 13240013);
        // System.out.println(k);

        // System.out.println("printing range");
        // int[] a = l.rangeKey(33240013, 73240013);
        // for (int i: a)
        //     System.out.println(i);

        ElasticERL m = new ElasticERL(1000);
        m.add(m, 123, "123 VALUE");
        m.add(m, 33240013, "33240013 VALUE");
        m.add(m, 13240013, "13240013 VALUE");
        m.add(m, 23240013, "23240013 VALUE");
        m.add(m, 43240013, "43240013 VALUE");
        m.add(m, 73240013, "73240013 VALUE");
        m.add(m, 33240013, "33240013 SECOND VALUE");
        m.add(m, 0, "0 VALUE");
        m.add(m, 1, "1 VALUE");
        
        
        
        String val = m.getValues(m, 13240013);
        System.out.println("\nprinting getValue: ");
        System.out.println(val);
        

        System.out.println("printing nextKey");
        int k = m.nextKey(m, 13240013);
        System.out.println(k);

        System.out.println("printing range");
        int[] a = m.rangeKey(33240013, 73240013);
        for (int i: a)
            System.out.println(i);
        
        
    }
}