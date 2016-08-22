/**
 * Created by borderliner on 8/22/16.
 */

package ir.borderliner.tiger;

public class NumExp implements Exp {

    public int num;

    public NumExp(int n) {
        num = n;
    }

    @Override public IntAndTable eval(Table t) {
        return new IntAndTable(num, t);
    }

}
