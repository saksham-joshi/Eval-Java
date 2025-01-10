# 🔢 Eval-Java 🔢

#### Python has a function called eval() used to solve mathematical expressions in a string but Java has nothing like this, so i developed this algorithm which can do so.

  **You can use this package to create a calculator which can solve complex mathematical expressions.**

> #### ```Average Time Complexity: **O(n)**```
> #### ```Average Space Complexity: **O(k + m)**```

## 📝 Sample code 
```java
import evaluater.Evaluater;
import evaluater.EvaluaterExceptions;

public class sample {

    public static void main(String[] args)
    {
        try
        {
            
            Evaluater eval = new Evaluater("1280.33/(12*-10.11)");
            System.out.println(eval.evaluate());
        }
        catch(EvaluaterExceptions.InvalidMathExpression excep)
        {
            System.out.println(excep);
        }
    }
    
}
```

> #### **NOTE:** ```evaluate() methods throw InvalidMathExpression exception if the given expression is invalid. ```


## ➗ Supported operators ➕

| Operators    |   Name         | Precedence      |
| :-------:    |  :-------:     | :-----------:   |
| **+**        | Addition       |       `1`       |
| **-**        | Subtraction    |       `1`       |
| **x,*,X**    | Multiplication |       `2`       |
| **/,÷**      | Division       |       `2`       |
| **%**        | Modulus        |       `2`       |
| **^**        | Power          |       `3`       |
| **!**        | Not            |       `4`       |



## 🔗 Developer Links

[![portfolio](https://img.shields.io/badge/my_portfolio-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://sakshamjoshi.vercel.app/)
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/sakshamjoshi27)
[![Github](https://img.shields.io/badge/Visit_my-Github-purple)](https://github.com/saksham-joshi)
[![X(Twitter)](https://img.shields.io/twitter/follow/sakshamjoshi27
)](https://x.com/sakshamjoshi27)
[![Static Badge](https://img.shields.io/badge/mail_at-social.sakshamjoshi%40gmail.com-aqua)](mailto:social.sakshamjoshi@gmail.com)

---