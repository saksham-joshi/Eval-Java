
package evaluater;


public final class EvaluaterUtility
{

    public static short preference(char __operator)
    {
        switch(__operator)
        {
            case '+' : 
            case '-' : return 1 ;

            case '*' :
            case 'x' :
            case 'X' :
            case '/' :
            case '÷' :
            case '%' : return 2 ; 

            case '^' : return 3 ;

            case '!' : return 4 ;
        }

        return 0;
    }

    public static boolean isOperator(char __operator)
    {
        // the preference method returns 0, if the passed
        // character is not an operator
        return preference(__operator) != 0;
    }

    public static boolean isDigit(char __token)
    {
        return (__token >= '0' && __token <= '9');
    }

    public static int convertToDigit(char __ch)
    {
        return __ch - '0';
    }

    /** 
     *  Converts the character in the string to double value 
     
     *  @return : a array of double type of size 2 in which the first element
     *            contains the value we extracted from the String and
     *            the second element contains the index at which the 
     *            double type value ended.
    */
    public static double[] extractNumber(String __extract_from , int __index)
    {
        final int len = __extract_from.length();

        double[] output = new double[2];
        output[0] = 0;
        
        for(; __index < len ; ++__index)
        {
            char ch = __extract_from.charAt(__index);

            if(ch >= '0' && ch <= '9')
            {
                output[0] *= 10;
                output[0] += EvaluaterUtility.convertToDigit(ch);

                continue;
            }
            
            // if the character is not a digit, then breaking the loop
            break;
        }

        // if the character at __index is '.', so there is definitely a number with decimal digits
        if(__index < len && __extract_from.charAt(__index) == '.')
        {
            double ten = 10;

            ++__index;

            for(; __index < len ; ++__index)
            {
                char ch = __extract_from.charAt(__index);

                if(ch >= '0' && ch <= '9')
                {
                    output[0] += ((double)EvaluaterUtility.convertToDigit(ch) / ten);

                    ten *= 10;

                    continue;
                }
                
                break;
            }
        }

        output[1] = __index;

        return output;
    }
}

