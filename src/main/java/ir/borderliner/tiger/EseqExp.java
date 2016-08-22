/**
 * Created by borderliner on 8/22/16.
 */

package ir.borderliner.tiger;

public class EseqExp implements Exp {

    public Stm stm;
    public Exp exp;

    public EseqExp(Stm s, Exp e) {
        stm = s;
        exp = e;
    }

    @Override public IntAndTable eval(Table t) {
        Table stmRet = stm.eval(t);
        IntAndTable expVal = exp.eval(stmRet);
        return expVal;
    }

}
