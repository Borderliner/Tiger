package ir.borderliner.tiger;

/**
 * Created by borderliner on 8/22/16.
 */
public class ExpId implements Exp {

    public String id;

    public ExpId(String i) {
        id = i;
    }

    @Override public IntAndTable eval(Table t) {
        return new IntAndTable(lookup(t, id), t);
    }

    private int lookup(Table t, String id) {
        if (t == null) {
            throw new IllegalArgumentException("Variable " + id + " not found in table.");
        }
        if (t.id.equals(id)) {
            return t.value;
        }
        return lookup(t.tail, id);
    }

}
