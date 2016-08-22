/**
 * Created by borderliner on 8/22/16.
 */

package ir.borderliner.tiger;

public class Interp {

    public static int numargs(ExpList exps) {
        if (exps instanceof LastExpList) {
            return 1;
        } else {
            return 1 + numargs(((PairExpList) exps).tail);
        }
    }

    public static ExpList explist(Exp firstArg, Exp... otherArgs) {
        if (otherArgs.length == 0){
            return new LastExpList(firstArg);
        }
        ExpList tail = new LastExpList(otherArgs[otherArgs.length - 1]);
        for (int i = otherArgs.length - 2; i >= 0; i--) {
            tail = new PairExpList(otherArgs[i], tail);
        }
        return new PairExpList(firstArg, tail);
    }

    public static int maxargs(Stm s) {
        if (s instanceof PrintStm) {
            PrintStm printStm = (PrintStm) s;
            return  Math.max(numargs(printStm.exps), maxargs(printStm.exps));
        } else if (s instanceof CompoundStm) {
            CompoundStm cs = (CompoundStm) s;
            return Math.max(maxargs(cs.stm1), maxargs(cs.stm2));
        } else if (s instanceof AssignStm) {
            return maxargs(((AssignStm) s).exp);
        }
        return 0;
    }

    private static int maxargs(ExpList exps) {
        if (exps instanceof LastExpList) {
            return maxargs(((LastExpList) exps).head);
        }
        PairExpList pairExpList = (PairExpList) exps;
        return Math.max(maxargs(pairExpList.head), maxargs(pairExpList.tail));
    }

    private static int maxargs(Exp e) {
        if (e instanceof EseqExp) {
            return maxargs(((EseqExp) e).stm);
        } else if (e instanceof OpExp) {
            OpExp opExp = (OpExp) e;
            return Math.max(maxargs(opExp.left), maxargs(opExp.right));
        }
        return 0;
    }

    public static void interp(Stm s) {
        s.eval(null);
    }

}
