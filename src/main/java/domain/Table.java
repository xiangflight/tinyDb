package domain;

/**
 * @author xiangdotzhaoAtwoqutechcommacom
 * @date 2020/2/27
 */

public class Table {

    private int numRows;

    public int getNumRows() {
        return numRows;
    }

    public void setNumRows(int numRows) {
        this.numRows = numRows;
    }

    public boolean isFull() {
        return false;
    }
}
