/**
 * Created by borderliner on 8/22/16.
 */

package ir.borderliner.tiger;

public class Main {

    public static void main(String[] args) {
        Stm program = new CompoundStm(new AssignStm("a",
                new OpExp(new NumExp(5), OpExp.Plus, new NumExp(3))),
                new CompoundStm(new AssignStm("b",
                        new EseqExp(new PrintStm(new PairExpList(new IdExp("a"),
                                new LastExpList(new OpExp(new IdExp("a"),
                                        OpExp.Minus, new NumExp(1))))),
                                new OpExp(new NumExp(10), OpExp.Times, new IdExp("a")))),
                new PrintStm(new LastExpList(new IdExp("b")))));
    }

}
