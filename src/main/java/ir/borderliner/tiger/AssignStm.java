/**
 * Created by borderliner on 8/22/16.
 */

package ir.borderliner.tiger;

public class AssignStm extends Stm {

    public String id;
    public Exp exp;

    public AssignStm(String i, Exp e) {
        id = i;
        exp = e;
    }

}