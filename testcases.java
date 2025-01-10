import evaluater.Evaluater;
import evaluater.EvaluaterExceptions.InvalidMathExpression;

public class testcases {
    
    public static void main(String[] args) {

        String [] test_cases = {"1280.33/(12*-10.11)" ,
                                "50 * 3 / 5" ,
                                "5 + 10 - 3",
                                "45 % 4",
                                "2 ^ 3",
                                "!0",
                                "!1",
                                "2 + 3 * 4 - 5 / 2",
                                "(5 + 3) * 2",
                                "128 / -4",
                                "((2 + 3) * (4 - 1)) / 3", 
                                "2 ^ -3",
                                "10 / 0",
                                "-10 % 3",
                                "3.5 * 2.4 - 1.2",
                                "10 ^ 6",
                                "(-5 + 3 * 4) ^ 2 / 2 % 7",
                            };
        

        for(int i = 0 ; i < test_cases.length ; ++i)
        {
            try
            {
                Evaluater eval = new Evaluater(test_cases[i]);
                System.out.println("\n Output of '"+ test_cases[i] + "' = " + eval.evaluate());
            }
            catch(InvalidMathExpression __excep)
            {
                System.out.println(__excep);
            }
        }
    }
}
