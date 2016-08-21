/**
 * Created by borderliner on 8/22/16.
 */

package ir.borderliner.tiger;

public class EseqExp extends Exp {

    public Stm stm;
    public Exp exp;

    public EseqExp(Stm s, Exp e) {
        stm = s;
        exp = e;
    }

}
