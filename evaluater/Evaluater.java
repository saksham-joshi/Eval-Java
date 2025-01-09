package evaluater;

import java.util.Stack;
import java.util.EmptyStackException;
import java.util.NoSuchElementException;
import java.lang.Math;

public final class Evaluater {

    private String _expression;
    private Stack<Double> _value_stack;
    private Stack<Character> _operator_stack;

    public Evaluater(String __expression) 
    {
        this._expression = new String(__expression);
        this._value_stack = new Stack<Double>();
        this._operator_stack = new Stack<Character>();
    }

    private double eval() throws EvaluaterExceptions.InvalidMathExpression , EmptyStackException , NoSuchElementException
    {
        int len = this._expression.length();

        char previous_token = '\0';

        for(int i = 0 ; i < len ; ++i)
        {
            char token = this._expression.charAt(i);
            
            if(token == ' ' || token == '\t' || token == '\n') continue;

            else if(token == '(') this._operator_stack.push(token);

            else if(token == ')') this.moveOperatorsToStackTillOpenBracket();

            else if(EvaluaterUtility.isDigit(token)) i = this.extractNumber(i) - 1;

            else if(token == '-' && (previous_token == '\0' ||  previous_token == '(' || EvaluaterUtility.isOperator(previous_token))) i = this.extractNegativeNumber(i) - 1;
                
            else if(EvaluaterUtility.isOperator(token)) this.pushOperatorToOperatorStack(token);
            
            else throw new EvaluaterExceptions.InvalidTokenFound(token);

            previous_token = this._expression.charAt(i);
            
        }

        while(!this._operator_stack.empty()) moveOperatorsToValueStack();
        
        return this._value_stack.pop();
    }

    public double evaluate() throws EvaluaterExceptions.InvalidMathExpression
    {
        try{
            return this.eval();
        }
        catch(EmptyStackException __excep)
        {
            throw new EvaluaterExceptions.InvalidMathExpression("the expression '"+ this._expression +"' is invalid!");
        }
        catch(NoSuchElementException __excep)
        {
            throw new EvaluaterExceptions.InvalidMathExpression("the expression '" + this._expression + "' is invalid!");
        }
    }

    private int extractNegativeNumber(int __index)
    {
        int new_i = this.extractNumber(++__index);

        this._value_stack.push(-this._value_stack.pop());

        return new_i;
    }

    private int extractNumber(int __index)
    {
        double[] ar = EvaluaterUtility.extractNumber(_expression, __index);

        this._value_stack.push(ar[0]);

        return (int) ar[1];
    }

    private void moveOperatorsToStackTillOpenBracket() throws EmptyStackException , EvaluaterExceptions.InvalidMathExpression 
    {
        char operator = this._operator_stack.peek();

        while(operator != '(')
        {
            this.moveOperatorsToValueStack();
            operator = this._operator_stack.peek();
        }

        // removing '('
        this._operator_stack.pop();
    }

    private void moveOperatorsToValueStack() throws EvaluaterExceptions.InvalidOperatorFound , EmptyStackException
    {
        performOperation(this._operator_stack.pop());
    }

    private void performOperation(char __operator) throws EvaluaterExceptions.InvalidOperatorFound , EmptyStackException
    {
        if(__operator == '!'){ this._value_stack.push(this._value_stack.pop() == 0 ? 1.0 : 0); return;}

        double d2 = this._value_stack.pop();
        double d1 = this._value_stack.pop();

        System.out.println(d1 + " " + __operator + " " + d2);

        switch(__operator)
        {
            case '+' : this._value_stack.push(d1 + d2); break;
            
            case '-' : this._value_stack.push(d1 - d2); break;

            case 'x' :

            case 'X' :

            case '*' : this._value_stack.push(d1 * d2); break;

            case '÷' :

            case '/' : this._value_stack.push(d1 / d2); break;

            case '%' : this._value_stack.push(d1 % d2); break;

            case '^' : this._value_stack.push(Math.pow(d1, d2)); break;

            case '(' :

            case ')' : break;

            default : throw new EvaluaterExceptions.InvalidOperatorFound(__operator);
        }
    }

    private void pushOperatorToOperatorStack(char __operator) throws EvaluaterExceptions.InvalidOperatorFound , EmptyStackException
    {
        short operator_preference = EvaluaterUtility.preference(__operator);

        while (!this._operator_stack.empty() && operator_preference <= EvaluaterUtility.preference(this._operator_stack.peek())) 
        {
            this.moveOperatorsToValueStack();
        }

        this._operator_stack.push(__operator);
    }
}
