package constant;

/**
 * @author xiangdotzhaoAtwoqutechcommacom
 * @date 2020/2/26
 */

public enum StatementType {
    /**
     * insert statement
     */
    STATEMENT_INSERT("insert"),
    /**
     * select statement
     */
    STATEMENT_SELECT("select");

    private String type;

    StatementType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
