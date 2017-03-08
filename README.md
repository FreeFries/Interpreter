# How do you model an expression ?
Just recently I was posed with the following question above for a challenging and exciting role
<pre>
     +
    / \
   *  1
 / \
6  3

(6 * 3) + 1 = 19 
</pre>
At the end of this exercise the solution proposed to me was to use an interface with a common eval() method where

* NodeValue(s) are 6, 3, & 1
* Op Nodes were * (multiply) & + (Addition) thus we modelled NodeMulti & NodeAdd and this gave us the traditional DSL expression below as

### Approach I 
<pre>
int answer = new NodeAdd(
                             new NodeMulti( new NodeValue(6),new NodeValue(3)),
                             new NodeValue(1)
                             ).eval();
</pre>
### Approach II using a SAM Functional Interface with default methods only

This **other alternative** by just using a **Functional Interface** (which Node.java is), **default methods** and **Java 8's Lambdas** to make your code more concise, with much **fewer lines (less to test)** and **closer to the expression you are trying to model** which is what I have tried to do, hopefully. It is still and extension of Approach I

So if you look at NodeDriver.java you will see the following lambda expression(s)

<pre>
        Node v6 = () -> 6;
        Node v3 = () -> 3;
        Node v1 = () -> 1;

        Node d = () -> 0 ;  // dummy node to evaluate your final answer 
                            // also acts like store for the final Node expression to be evaluate.

        Node exprsn = d.add( d.multi(v6,v3), v1) ;

        int answer2 = exprsn.eval();  

</pre>

The default methods of multi() & add() actually return lambda expressions - thus the beauty of this is you are actually dealing with little Node blocks that you can effectively "transport" to your final calling method eval() ! Those code blocks are ... see the interface Node.java
<pre>
() -> (n.eval() * o.eval()) // for multiplication where n & o are the nodes passed in 

() -> (a.eval() + b.eval()) // for addition where a & b are the nodes passed in
</pre>


Both solutions are formed on the basis of the following pattern(s) ....

[Wikipedia - Interpreter Pattern](https://en.wikipedia.org/wiki/Interpreter_pattern#Java) 

And, it also has elements of the Composable Decorator Pattern in this post  ....

[Yegor Bugayenko post on Composite Pattern ](http://www.yegor256.com/2015/02/26/composable-decorators.html)






