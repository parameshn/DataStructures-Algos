package wrapperClassesUtil;

public class impl {
    public static void main(String[] args) {

        int a = 10;
        int b = 3;

        int c;
        String s;
        c = Integer.valueOf(a);
        System.out.println(c);

        c = Integer.parseInt("001");
        System.out.println(c);

        s = Integer.toString(a);
        System.out.println(s);

        c = Integer.compare(b, a);
        System.out.println(c);

        c = Integer.compare(a, b);
        System.out.println(c);

        c = Integer.compare(a, a);
        System.out.println(c);

        c = Integer.max(a, b);
        System.out.println(c);

        c = Integer.max(a, a);
        System.out.println(c);

        c = Integer.min(a, b);
        System.out.println(c);

        c = Integer.bitCount(a);
        System.out.println(c);

        s = Integer.toBinaryString(a);
        System.out.println(s);

        s = Integer.toHexString(a); //a = 10 in hex
        System.out.println(s);

        s = Integer.toHexString(9); 
        System.out.println(s);

        s = Integer.toHexString(15);
        System.out.println(s);

        s = Integer.toOctalString(a); 
        System.out.println(s);

        s = Integer.toOctalString(9);
        System.out.println(s);

        c = Integer.divideUnsigned(a, b);
        System.out.println(c);

        c = Integer.remainderUnsigned(a, b);
        System.out.println(c);
        System.out.println(a % b); // Output: -1 (WRONG for unsigned)

        c = Integer.sum(a, b);
        System.out.println(c);

        c = Integer.parseInt("A", 16);
        System.out.println("new C ="+c);

        // c = Integer.divide(a, b); //doesn't exist 

        // c = Integer.remainder(a, b);

        c = Integer.sum(a, b);

        a = -1;;
        b = 2;

        int quotient = Integer.divideUnsigned(a, b);
        int remainder = Integer.remainderUnsigned(a, b);

        System.out.println("Quotient: " + quotient);
        System.out.println("Remainder: " + remainder);

        c = Integer.highestOneBit(a);
        System.out.println(c);

        c = Integer.lowestOneBit(a);
        System.out.println(c);

        System.out.println("===Double===");

        double d = 1000000000;
        double e = 2000000000;

        double f;

        f = Double.valueOf(d);
        System.out.println(f);

        f = Double.parseDouble("1000000000");
        System.out.println(f);

        f = Double.compare(d, e);
        System.out.println(f);

        s = Double.toString(e);
        System.out.println(s);

        boolean j = Double.isNaN(a);
        System.out.println(j);

        j = Double.isInfinite(a);
        System.out.println(j);

        f = Double.max(d, e);
        System.out.println(f);

        f = Double.min(d, e);
        System.out.println(f);

        f = Double.sum(d, e);
        System.out.println(f);

        j = Double.isFinite(d);
        System.out.println(j);

        f = Double.POSITIVE_INFINITY;
        System.out.println(f);

        f = Double.NEGATIVE_INFINITY;
        System.out.println(f);

        f = Double.NaN;
        System.out.println(f);

        f = Double.longBitsToDouble(0x7ff0000000000000L);
        System.out.println(f);


        System.out.println("===Float===");

        float g = -1;
        float h = 2;

        float i;

        i = Float.valueOf(g);
        System.out.println(i);

        i = Float.parseFloat("1000000000");
        System.out.println(i);

        System.out.println("===long===");

        long k = 1000000000;
        long l = 2000000000;

        long m;

        m = Long.valueOf(k);
        System.out.println(m);

        m = Long.parseLong("1000000000");
        System.out.println(m);

        m = Long.compare(k, l);
        System.out.println(m);

        s = Long.toString(k);
        System.out.println(s);

        m = Long.max(k, l);
        System.out.println(m);

        m = Long.min(k, l);
        System.out.println(m);

        m = Long.sum(k, l);
        System.out.println(m);

        System.out.println("===Boolean-Based===");

        boolean n = true;
        boolean o = false;

        boolean p;

        p = Boolean.valueOf(n);
        System.out.println(p);

        p = Boolean.parseBoolean("true");
        System.out.println(p);

        



    }

}
