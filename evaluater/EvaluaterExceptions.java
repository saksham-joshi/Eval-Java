package evaluater;

public final class EvaluaterExceptions {
    
    public static class InvalidMathExpression extends Exception
    {
        public InvalidMathExpression(String __error_message)
        {
            super(__error_message);
        }
    }

    public static class InvalidTokenFound extends InvalidMathExpression
    {
        public InvalidTokenFound(char __token)
        {
            super("Found this invalid token '" + __token +"'");
        }
    }

    public static class InvalidOperatorFound extends InvalidMathExpression
    {
        public InvalidOperatorFound(char __operator)
        {
            super("Found this invalid token '"+ __operator + "'");
        }
    }
}
