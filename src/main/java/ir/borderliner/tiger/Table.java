/**
 * Created by borderliner on 8/22/16.
 */

package ir.borderliner.tiger;

public class Table {

    String id;
    int value;
    Table tail;

    Table(String i, int v, Table t) {
        id = i;
        value = v;
        tail = t;
    }

}
