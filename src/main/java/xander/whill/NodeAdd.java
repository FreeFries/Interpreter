package xander.whill;

import xander.whill.Node;

/**
 * Created by APereira JavaDeveloper,Croydon, UK on 07/03/17.
 */
public class NodeAdd implements Node {

    private Node left ;
    private Node right ;

    NodeAdd(Node left, Node right)
    {
        this.left = left ;
        this.right = right ;
    }

    public int eval()
    {
        System.out.print(" + ");
        return this.left.eval() + this.right.eval() ;

    }

}
