/**
 * Created by borderliner on 8/22/16.
 */

package ir.borderliner.tiger;

public class ExpOp implements Exp {

    public Exp left, right;
    public int oper;
    final public static int Plus = 1, Minus = 2, Times = 3, Div = 4;

    public ExpOp(Exp l, int o, Exp r) {
        left = l;
        oper = o;
        right = r;
    }

    @Override public IntAndTable eval(Table t) {
        IntAndTable exp1Val = left.eval(t);
        IntAndTable exp2Val = right.eval(exp1Val.t);
        if (oper == ExpOp.Plus) {
            return new IntAndTable(exp1Val.i + exp2Val.i, exp2Val.t);
        } else if (oper == ExpOp.Minus) {
            return new IntAndTable(exp1Val.i - exp2Val.i, exp2Val.t);
        } else if (oper == ExpOp.Times) {
            return new IntAndTable(exp1Val.i * exp2Val.i, exp2Val.t);
        } else if (oper == ExpOp.Div) {
            return new IntAndTable(exp1Val.i / exp2Val.i, exp2Val.t);
        }
        throw new UnsupportedOperationException("Unknown operator " + oper);
    }

}
