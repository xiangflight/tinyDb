package domain;

import constant.TableConstant;

/**
 * @author xiangdotzhaoAtwoqutechcommacom
 * @date 2020/2/28
 */

public class Page {
    /**
     * 一个页中能装下的row
     */
    private Row[] rows;

    private int i;

    public Page() {
        rows = new Row[TableConstant.ROWS_PER_PAGE];
        i = 0;
    }

    public Row[] getRows() {
        return rows;
    }


    public void insert(Row row) {
        if (i > TableConstant.ROWS_PER_PAGE) {
            throw new RuntimeException("insert error");
        }
        rows[i] = row;
        i++;
    }
}
