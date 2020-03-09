package domain;

import constant.TableConstant;

/**
 * @author xiangdotzhaoAtwoqutechcommacom
 * @date 2020/2/28
 */

public class Page {
    /**
     * 一个页中能装下的 row
     */
    private Row[] rows;

    public Page() {
        rows = new Row[TableConstant.ROWS_PER_PAGE];
    }

}
