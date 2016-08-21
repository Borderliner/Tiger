/**
 * Created by borderliner on 8/22/16.
 */

package ir.borderliner.tiger;

public class CompoundStm extends Stm {

    public Stm stm1, stm2;

    public CompoundStm(Stm s1, Stm s2) {
        stm1 = s1;
        stm2 = s2;
    }

}
