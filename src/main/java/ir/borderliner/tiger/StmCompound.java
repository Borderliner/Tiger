/**
 * Created by borderliner on 8/22/16.
 */

package ir.borderliner.tiger;

public class StmCompound implements Stm {

    public Stm stm1, stm2;

    public StmCompound(Stm s1, Stm s2) {
        stm1 = s1;
        stm2 = s2;
    }

    @Override public Table eval(Table t) {
        Table stm1Ret = stm1.eval(t);
        Table stm2Ret = stm2.eval(stm1Ret);
        return stm2Ret;
    }

}
