/**
 * Created by borderliner on 8/22/16.
 */

package ir.borderliner.tiger;

public class PairExpList extends ExpList {

    public Exp head;
    public ExpList tail;

    public PairExpList(Exp h, ExpList t) {
        head = h;
        tail = t;
    }

}
