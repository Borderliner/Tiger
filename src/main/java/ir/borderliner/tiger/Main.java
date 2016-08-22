/**
 * Created by borderliner on 8/22/16.
 */

package ir.borderliner.tiger;

public class Main {

    public static void main(String[] args) {
        Stm program = new StmCompound(new StmAssign("a",
                new ExpOp(new ExpNum(5), ExpOp.Plus, new ExpNum(3))),
                new StmCompound(new StmAssign("b",
                        new ExpEseq(new StmPrint(new ExpPairList(new ExpId("a"),
                                new ExpLastList(new ExpOp(new ExpId("a"),
                                        ExpOp.Minus, new ExpNum(1))))),
                                new ExpOp(new ExpNum(10), ExpOp.Times, new ExpId("a")))),
                new StmPrint(new ExpLastList(new ExpId("b")))));
    }

}
