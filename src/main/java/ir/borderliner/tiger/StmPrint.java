/**
 * Created by borderliner on 8/22/16.
 */

package ir.borderliner.tiger;

public class StmPrint implements Stm {

    public ExpList exps;

    public StmPrint(ExpList e) {
        exps = e;
    }

    @Override
    public Table eval(Table t) {
        return interpPrint(exps, t);
    }

    private Table interpPrint(ExpList exps, Table t) {
        if (exps instanceof ExpLastList) {
            IntAndTable expVal = ((ExpLastList) exps).head.eval(t);
            System.out.print(expVal.i);
            return expVal.t;
        } else {
            ExpPairList expPairList = (ExpPairList) exps;
            IntAndTable expVal = expPairList.head.eval(t);
            System.out.print(expVal.i);
            return interpPrint(expPairList.tail, expVal.t);
        }
    }
}
