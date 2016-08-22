/**
 * Created by borderliner on 8/22/16.
 */

package ir.borderliner.tiger;

public class StmAssign implements Stm {

    public String id;
    public Exp exp;

    public StmAssign(String i, Exp e) {
        id = i;
        exp = e;
    }

    @Override public Table eval(Table t) {
        IntAndTable expVal = exp.eval(t);
        return new Table(id, expVal.i, expVal.t);
    }

}
