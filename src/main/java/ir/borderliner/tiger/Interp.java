/**
 * Created by borderliner on 8/22/16.
 */

package ir.borderliner.tiger;

public class Interp {

    public static int numargs(ExpList exps) {
        if (exps instanceof ExpLastList) {
            return 1;
        } else {
            return 1 + numargs(((ExpPairList) exps).tail);
        }
    }

    public static ExpList explist(Exp firstArg, Exp... otherArgs) {
        if (otherArgs.length == 0){
            return new ExpLastList(firstArg);
        }
        ExpList tail = new ExpLastList(otherArgs[otherArgs.length - 1]);
        for (int i = otherArgs.length - 2; i >= 0; i--) {
            tail = new ExpPairList(otherArgs[i], tail);
        }
        return new ExpPairList(firstArg, tail);
    }

    public static int maxargs(Stm s) {
        if (s instanceof StmPrint) {
            StmPrint stmPrint = (StmPrint) s;
            return  Math.max(numargs(stmPrint.exps), maxargs(stmPrint.exps));
        } else if (s instanceof StmCompound) {
            StmCompound cs = (StmCompound) s;
            return Math.max(maxargs(cs.stm1), maxargs(cs.stm2));
        } else if (s instanceof StmAssign) {
            return maxargs(((StmAssign) s).exp);
        }
        return 0;
    }

    private static int maxargs(ExpList exps) {
        if (exps instanceof ExpLastList) {
            return maxargs(((ExpLastList) exps).head);
        }
        ExpPairList expPairList = (ExpPairList) exps;
        return Math.max(maxargs(expPairList.head), maxargs(expPairList.tail));
    }

    private static int maxargs(Exp e) {
        if (e instanceof ExpEseq) {
            return maxargs(((ExpEseq) e).stm);
        } else if (e instanceof ExpOp) {
            ExpOp expOp = (ExpOp) e;
            return Math.max(maxargs(expOp.left), maxargs(expOp.right));
        }
        return 0;
    }

    public static void interp(Stm s) {
        s.eval(null);
    }

}
