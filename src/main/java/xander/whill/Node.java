package xander.whill;

/**
 *
 * Created by APereira JavaDeveloper,Croydon, UK on 07/03/17.
 */
@FunctionalInterface
public interface Node {

    int eval();

    default Node multi(Node n, Node o)
    {
        return () -> (n.eval() * o.eval()) ; // returning code block (aka lambda) to be evaluated later
    }

    default Node add(Node a, Node b)
    {
        return () -> (a.eval() + b.eval()) ; //  returning code block (aka lambda) to be evaluated later
    }

    /**
     * Pity cannot be used because I still need to seem to produce a dummy node that you need in order to store the node expression or evaluate
     * @return Node
     */
    default Node exprsn()
    {
        return this ;
    }

}
