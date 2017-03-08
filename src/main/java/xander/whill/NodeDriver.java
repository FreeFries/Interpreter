package xander.whill;

/**
 *     +
 *    / \
 *   *  1
 *  / \
 * 6  3
 *
 *
 * Created by APereira JavaDeveloper,Croydon, UK on 07/03/17.
 */
public class NodeDriver {
    public static void main(String... args) {

        // obtaining the more verbose but nevertheless non-lambda way of getting the same answer
        System.out.print("Evals in the following order.... ");
        int answer = new NodeAdd(
                        new NodeMulti( new NodeValue(6),new NodeValue(3)),
                        new NodeValue(1)
                        ).eval();
        System.out.println("\nanswer using traditional implementation of Node as Value,Multi & Add types = " + answer);
        // ------------------------------------------------------------------------

        Node v6 = () -> 6;
        Node v3 = () -> 3;
        Node v1 = () -> 1;

        Node d = () -> 0 ;  // dummy node to evaluate your final answer (Chose zero because you get zero if you multiply by it or you get the same if value if you add)
                            // also acts like store for the final Node expression to be evaluate.

        Node exprsn = d.add( d.multi(v6,v3), v1) ;

        int answer2 = exprsn.eval();
        System.out.println("answer using default methods and lambdas ONLY using an additional dummy node d = " + answer2 );
        // ------------------------------------------------------------------------


        Node exprsnn = () ->  (  v6.add(v6.multi(v6,v3),v1).eval() )  ;
        int answer3 = exprsnn.eval() ;
        System.out.println("answer using default methods and lambdas ONLY using an existing node v6  = " + answer3 );
        // ------------------------------------------------------------------------

    }
}
