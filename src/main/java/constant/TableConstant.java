package constant;

/**
 * @author xiangdotzhaoAtwoqutechcommacom
 * @date 2020/3/9
 */

public class TableConstant {

    /**
     * the same size as in the db_tutorial
     */
    private final static int ROW_SIZE = 291;

    /**
     * the same size as a page used
     * in the virtual memory systems of most computer architectures
     */
    private final static int PAGE_SIZE = 4096;

    public final static int TABLE_MAX_PAGES = 100;

    public final static int ROWS_PER_PAGE = PAGE_SIZE / ROW_SIZE;

    public final static int TABLE_MAX_ROWS = ROWS_PER_PAGE * TABLE_MAX_PAGES;


}
