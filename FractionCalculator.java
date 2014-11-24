/**
 *Created by Lewis Palmer for the second coursework
 */
import java.util.Scanner;
public class FractionCalculator{
    private Fraction storedvalue = new Fraction(0, 1);
    private String remOp = "";
    
    //flag to tell program the User has requested to quit.
    private boolean quit = false;
    public Fraction evaluate(Fraction fraction, String inputString)
    {
        storedvalue = fraction;
        Fraction nextvalue = new Fraction(0, 1);
        String[] brokendown = inputString.split(" ");
        int funclen = brokendown.length;
        int counter = 0;
        while(counter<funclen)
        {
            //storing this part as current to save typing
            String current = brokendown[counter];
            //checking if it is just an integer
            if(isInteger(current))
            {
                if(remOp.equals(""))
                {
                    storedvalue = new Fraction(Integer.parseInt(current), 1);
                }
                else
                {
                    nextvalue = new Fraction(Integer.parseInt(current), 1);
                    Calculate(storedvalue, nextvalue, remOp);
                    remOp = "";
                }
            }
            //checking to see if next part of expression is a Fraction and then assinging
            else if(isFraction(current))
            {
                //If no stored Operation, overwrite the Stored Fraction.
                String[] numdem = current.split("/");
                if(remOp.equals(""))
                {
                    storedvalue = new Fraction(Integer.parseInt(numdem[0]), Integer.parseInt(numdem[1]));
                }
                else
                {
                    //If we have a stored Fraction, perform the Operation, set remOp to nothing.
                    nextvalue = new Fraction(Integer.parseInt(numdem[0]), Integer.parseInt(numdem[1]));
                    Calculate(storedvalue, nextvalue, remOp);
                    remOp = "";
                }
            }
            else if(isFunction(current))
            {
                if(!remOp.equals(""))
                {
                    System.out.println("Error");
                    storedvalue = new Fraction(0, 1);
                }
                else
                {
                    remOp = current;
                }
            }
            else if(isOperation(current))
            {
                PerformOperation(current);
            }
            else if(isQuitmessage(current))
            {
                quit = true;
                return storedvalue;
            }
            else
            {
                storedvalue = new Fraction(0, 1);
                System.out.println("Error");
                return storedvalue;
            }
            counter++;
        }
        return storedvalue;
    }
    
    private boolean isFraction(String input)
    {
        if(!input.contains("/"))
        {
            return false;
        }
        String[] numbers = input.split("/");
        if(numbers.length != 2)
        {
            return false;
        }
        if(!isInteger(numbers[0]))
        {
            return false;
        }
        if(!isInteger(numbers[1]))
        {
            return false;
        }
        return true;
    }
    
    private boolean isInteger(String input)
    {
        try
        {
            Integer.parseInt(input);
        }
        catch(NumberFormatException e)
        {
            return false;
        }
        return true;
    }
    
    private boolean isFunction(String input)
    {
        boolean result = false;
        if(input.equals("+"))
        {
            result = true;
        }
        if(input.equals("/"))
        {
            result = true;
        }
        if(input.equals("*"))
        {
            result = true;
        }
        if(input.equals("-"))
        {
            result = true;
        }
        return result;
    }
    
    private void Calculate(Fraction first, Fraction second, String Op)
    {
        switch(Op)
        {
            case "+":
                storedvalue = first.add(second);
                break;
            
            case "-":
                storedvalue = first.subtract(second);
                break;
            
            case "*":
                storedvalue = first.multiply(second);
                break;
            
            case "/":
                storedvalue = first.divide(second);
                break;
        }
    }
    
    private boolean isOperation(String input)
    {
        boolean result = false;
        if(input.equals("a") || input.equals("A") || input.equals("abs"))
        {
            result = true;
        }
        if(input.equals("n") || input.equals("N") || input.equals("neg"))
        {
            result = true;
        }
        if(input.equals("c") || input.equals("C") || input.equals("clear"))
        {
            result = true;
        }
        return result;
    }
    
    private void PerformOperation(String input)
    {
        switch(input)
        {
            case "a":
            case "A":
            case "abs":
                storedvalue = storedvalue.absValue();
                break;
            
            case "n":
            case "N":
            case "neg":
                storedvalue = storedvalue.negate();
                break;
            
            case "c":
            case "C":
            case "clear":
                storedvalue = new Fraction(0, 1);
                break;
        }
    }
    
    private boolean isQuitmessage(String input)
    {
        return (input.equals("q") || input.equals("Q") || input.equals("quit"));
    }
    
    public Fraction getStoredValue()
    {
        return new Fraction(storedvalue.getNumerator(), storedvalue.getDenominator());
    }
    
    public static void main(String[] args)
    {
        System.out.println("Hello, this is Lewis Palmer's Fraction Calculator.");
        System.out.println("Please begin entering formulas to calcuate");
        String input = "";
        FractionCalculator fcalc = new FractionCalculator();
        Fraction result = new Fraction(0, 1);
        while(!fcalc.quit)
        {
            Scanner sc = new Scanner(System.in);
            if(sc.hasNextLine())
            {
                input = sc.nextLine();
            }
            else
            {
                input = "q";
            }
            fcalc.evaluate(fcalc.getStoredValue(), input);
            if(!fcalc.quit)
            {
                result = fcalc.getStoredValue();
                System.out.println(result.toString());
            }    
        }
        System.out.println("Goodbye.");
    }
}
