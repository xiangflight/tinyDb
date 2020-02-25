package constant;

/**
 * @author xiangdotzhaoAtwoqutechcommacom
 * @date 2020/2/25
 */

public enum Status {
    /**
     * 正常退出
     */
    EXIT_SUCCESS,
    /**
     * 异常退出
     */
    EXIT_FAILURE;

    public int code() {
        return this.ordinal();
    }

}
