package domain;

import constant.TableConstant;

import java.util.Objects;

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
        return numOfRows >= TableConstant.TABLE_MAX_ROWS;
    }

    public void insert(Row row) {
        int pageNum = numOfRows / TableConstant.ROWS_PER_PAGE;
        if (Objects.isNull(pages[pageNum])) {
            pages[pageNum] = new Page();
        }
        pages[pageNum].insert(row);
        numOfRows++;
    }

    public Page[] getPages() {
        return pages;
    }
}
