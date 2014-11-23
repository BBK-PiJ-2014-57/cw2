/**
 * Created by keith for the second coursework assignment.
 */
public class FractionTest {
    public static void main(String[] args) {

        // test divide by zero - should print an error and exit
        new Fraction(1, 0);
        // test multiply
	Fraction f = new Fraction(3,10);
	Fraction g = new Fraction(1,2);
	Fraction h = new Fraction(3,5);
	if (!f.equals(g.multiply(h))) System.out.println("Multiply failed");
        // test equals
	test(new Fraction(1, 2),new Fraction(1, 2),"error test 1");
	test(new Fraction(1, 2),new Fraction(3, 6),"error test 2");
	test(new Fraction(-1, 2),new Fraction(1, -2),"error test 3");
	test(new Fraction(-1, -2),new Fraction(1, 2),"error test 4");
	test(new Fraction(4, -8),new Fraction(1, 2),"error test 5");//Supposed to fail.

        // extend with extra tests
	//subtract tests
	f = new Fraction(1, 10);
	if(!f.equals(h.subtract(g))) System.out.println("Subtract Failed");
	// Addition tests
	f = new Fraction(11, 10);
	if(!f.equals(h.add(g))) System.out.println("Addition failed");
	//Division tests
	f = new Fraction(6, 5);
	if(!f.equals(h.divide(g))) System.out.println("Division failed");
	f = new Fraction(1,5);
	if(!f.equals(new Fraction(-1, 5).absValue())) System.out.println("Absolute Value failed");
	g = new Fraction(-1, 5);
	if(!f.equals(g.negate())) System.out.println("Negation failed");
	//Integer to String test
	f = new Fraction(3,1);
	if(!f.toString().equals("3")) System.out.println("To String method failed");
    }

    static void test(Fraction f1, Fraction f2, String msg){
    	if (! f1.equals(f2))
		System.out.println(msg);
    }
}
