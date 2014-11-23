/**
 *Created by Lewis Palmer for the second coursework
 */
 public class FractionCalculatorTest
 {
    public static void main(String[] args)
    {
        
    FractionCalculator testcalc = new FractionCalculator();
    //Negation test
    Fraction f = new Fraction(1, 2);
    Fraction g = new Fraction(-1, 2);
    if(!f.equals(testcalc.evaluate(g, "n"))) System.out.println("Negation Failed");
    
    //Run over line test
    f = new Fraction(1, 1);
    g = new Fraction(1, 2);
    if(!f.equals(testcalc.evaluate(g, "+ 1/2"))) System.out.println("Run over line failed");
    
    //Addition test
    f = new Fraction(3, 4);
    if(!f.equals(testcalc.evaluate(g, "1/2 + 1/4"))) System.out.println("Addition failed");
    
    //Subtraction test
    f = new Fraction(-1, 4);
    g = new Fraction(0, 1);
    if(!f.equals(testcalc.evaluate(g, "- 1/4"))) System.out.println("Subtraction failed");
    
    //Cancel test
    f = new Fraction(3, 4);
    if(!g.equals(testcalc.evaluate(f, "clear"))) System.out.println("Clear failed");
    
    //Absolute value test
    f = new Fraction(1, 5);
    g = new Fraction(-1, 5);
    if(!(f.equals(testcalc.evaluate(g, "neg")))) System.out.println("Absolute value failed");
    
    //Error reset value test
    f = new Fraction(0, 1);
    g = new Fraction(1, 2);
    if(!f.equals(testcalc.evaluate(g, " ++"))) System.out.println("Error reset test failed");
    
    //Multiply test
    g = new Fraction(1, 4);
    if(!g.equals(testcalc.evaluate(f, "1/2 * 1/2"))) System.out.println("Multiply test failed");
    
    //Division test
    f = new Fraction(1, 2);
    if(!f.equals(testcalc.evaluate(g, "1/4 / 1/2"))) System.out.println("Division test failed");
    
    //Stored value test
    f = new Fraction(17, 20);
    if(!f.equals(testcalc.evaluate(g, "17/20"))) System.out.println("Stored value test");
    
    }
 }