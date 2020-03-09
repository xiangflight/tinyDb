package domain;

import constant.TableConstant;

/**
 * @author xiangdotzhaoAtwoqutechcommacom
 * @date 2020/2/27
 */

public class Table {

    /**
     * 表的行数
     */
    private int numOfRows;

    /**
     * 表的页数
     */
    private Page[] pages;

    public Table() {
        numOfRows = 0;
        pages = new Page[TableConstant.TABLE_MAX_PAGES];
    }

    public boolean isFull() {
        return false;
    }
}
