/**
 * Created by keith for the second coursework assignment.
 */
public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int num, int denom) {
        if (denom == 0) {
            System.out.println("Invalid fraction with denominator 0"); 
	    // this should use exceptions
            return;
        }
        int gcd = myGcd(num, denom);
        setNumerator(num / gcd);
        setDenominator(denom / gcd);
    }

    @Override
    public String toString() {
	int x = getDenominator();
	//For Display purposes, I put the negative sign in front of the Numerator.
	int neg = (x<0) ? -1 : 1;
	//Checks if Denominator is 1 and acts accordingly.
	if(x==1)
	{
	    return "" + getNumerator();
	}
	else
	{
	    return "" + neg * getNumerator() + '/' + neg * getDenominator();
	}
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int num) {
        numerator = num;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int num) {
        denominator = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fraction fraction = (Fraction) o;

        if (getDenominator() != fraction.getDenominator()) return false;
        if (getNumerator() != fraction.getNumerator()) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numerator;
        result = 31 * result + denominator;
        return result;
    }

    public Fraction multiply(Fraction other) {

        int num = this.getNumerator() * other.getNumerator();
        int denom = this.getDenominator() * other.getDenominator();
        return new Fraction(num, denom);
    }
    
    public Fraction add(Fraction other)
    {
	int newnum = (this.getNumerator()*other.getDenominator()) +
			(this.getDenominator() * other.getNumerator());
	return new Fraction(newnum, (this.getDenominator() * other.getDenominator()));
    }
    
    public Fraction subtract(Fraction other)
    {
	//Treating subtract as add to the negated other.
	return this.add(other.negate());
    }
    
    public Fraction negate()
    {
	return new Fraction(-1*this.getNumerator(), this.getDenominator());
    }
    
    public Fraction divide(Fraction other)
    {
	//Treating divide as 1/multiply
	Fraction flipped = new Fraction(other.getDenominator(), other.getNumerator());
	return this.multiply(flipped);
    }
    
    public Fraction absValue()
    {
	boolean numneg = (this.getNumerator() < 0);
	boolean denneg = (this.getDenominator() < 0);
	int negmultiplier = (numneg) ? -1 : 1;
	int denmultiplier = (denneg) ? -1 : 1;
	
	return new Fraction(this.getNumerator()*negmultiplier, this.getDenominator()*denmultiplier);
    }

    private int myGcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}
