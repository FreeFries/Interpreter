package xander.whill;

import xander.whill.Node;

/**
 * Created by APereira JavaDeveloper,Croydon, UK on 07/03/17.
 */
public class NodeMulti implements Node {

    private Node left ;
    private Node right ;

    NodeMulti(Node left, Node right)
    {
        this.left = left ;
        this.right = right ;
    }

    public int eval()
    {
        System.out.print(" X ");
        return this.left.eval() * this.right.eval() ;

    }

}
