
import evaluater.Evaluater;
import evaluater.EvaluaterExceptions;

public class sample {

    public static void main(String[] args)
    {
        try
        {
            Evaluater eval = new Evaluater("1280.33/(12*-10.11)");
            System.out.println("\n Output of the given expression = " + eval.evaluate());
        }
        catch(EvaluaterExceptions.InvalidMathExpression excep)
        {
            System.out.println(excep);
        }
    }
    
}
