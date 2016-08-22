/**
 * Created by borderliner on 8/22/16.
 */

package ir.borderliner.tiger;

public class ExpPairList extends ExpList {

    public Exp head;
    public ExpList tail;

    public ExpPairList(Exp h, ExpList t) {
        head = h;
        tail = t;
    }

}
