import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ehits {
    public static void main(String[] args) throws Exception {
        testSmall();
        System.out.println("----------------");
        testMedium();
        System.out.println("----------------");
        testLarge();
        
    }

    public static void testSmall()
    {
        ElasticERL s = new ElasticERL(15);
        s.add(s, 11484288, "11484288 VALUE");
        s.add(s, 33240013, "33240013 VALUE");
        s.add(s, 13240013, "13240013 VALUE");
        s.add(s, 23240013, "23240013 VALUE");
        s.add(s, 43240013, "43240013 VALUE");
        s.add(s, 73240013, "73240013 VALUE");
        s.add(s, 33224905, "33224905 VALUE");
        s.add(s, 33223370, "33223370 VALUE");

        String val = s.getValues(s, 13240013);
        System.out.println("\nprinting getValue: ");
        System.out.println(val);

        System.out.println("printing nextKey");
        int k = s.nextKey(s, 11484288);
        System.out.println(k);

        System.out.println("printing range");
        int [] a = s.rangeKey(73240013, 23240013);
        for (int i: a)
            System.out.println(i);
    }

    public static void testMedium()
    {
        ElasticERL m = new ElasticERL(1000);
        m.add(m, 11484288, "11484288 VALUE");
        m.add(m, 33240013, "33240013 VALUE");
        m.add(m, 13240013, "13240013 VALUE");
        m.add(m, 23240013, "23240013 VALUE");
        m.add(m, 43240013, "43240013 VALUE");
        m.add(m, 73240013, "73240013 VALUE");
        m.add(m, 33224905, "33224905 VALUE");
        m.add(m, 33223370, "33223370 VALUE");
        
        
        
        String val = m.getValues(m, 13240013);
        System.out.println("\nprinting getValue: ");
        System.out.println(val);

        System.out.println("printing range");
        int[] a = m.rangeKey(11484288, 13240013);
        for (int i: a)
            System.out.println(i);
    }

    public static void testLarge() throws FileNotFoundException 
    {
        File file = new File("EHITS_test_file1.txt");
        Scanner scanner = new Scanner(file);
        ElasticERL e = new ElasticERL(500000);
        
        String value;
        while (scanner.hasNextLine())
        {
            value = scanner.nextLine();
            int key = Integer.parseInt(value);
            e.add(e, key, value);
        }
        
        scanner.close();

        System.out.println("\nprinting getValue: ");
        System.out.println(33286060);

        ElasticERL l = new ElasticERL(500000);

        l.add(l, 123, "123 VALUE");
        l.add(l, 33240013, "33240013 VALUE");
        l.add(l, 13240013, "13240013 VALUE");
        l.add(l, 23240013, "23240013 VALUE");
        l.add(l, 43240013, "43240013 VALUE");
        l.add(l, 10494912, "10494912 VALUE");
        l.add(l, 33224905, "33224905 VALUE");
        l.add(l, 33223370, "33223370 VALUE");


        //l.remove(33240013);

        
        String val = l.getValues(l, 10494912);
        System.out.println("\nprinting getValue: ");
        System.out.println(val);

        System.out.println("printing nextKey");
        int k = l.nextKey(l, 13240013);
        System.out.println(k);

        System.out.println("printing range" );
        int[] a = l.rangeKey(33240013, 43240013);
        for (int i: a)
            System.out.println(i);
    }
}