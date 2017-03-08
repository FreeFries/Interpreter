package xander.whill;

import xander.whill.Node;

/**
 * Created by APereira JavaDeveloper,Croydon, UK on 07/03/17.
 */
public class NodeValue implements Node {

    private int value ;

    NodeValue(int i)
    {
        this.value = i ;
    }

    public int eval()
    {
        System.out.print(" " + this.value + " ");
        return this.value ;
    }

}
