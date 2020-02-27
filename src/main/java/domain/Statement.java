package domain;

import constant.StatementType;

import java.util.Objects;

/**
 * @author xiangdotzhaoAtwoqutechcommacom
 * @date 2020/2/26
 */

public class Statement {

    private volatile static Statement statement;

    private StatementType type;

    private Row row;

    private Statement() {
        row = new Row();
    }

    public static Statement getInstance() {
        if (Objects.isNull(statement)) {
            statement = new Statement();
        }
        return statement;
    }

    public StatementType getType() {
        return type;
    }

    public void setType(StatementType type) {
        this.type = type;
    }

    /**
     * 将输入的字符串转化为 statement
     *
     * @param buffer 输入 buffer
     * @return true if transfer successfully
     */
    public boolean transfer(InputBuffer buffer) {
        String[] elements = buffer.getBuffer().split(" ");
        final int validLen = 4;
        if (elements.length != validLen) {
            return true;
        }
        try {
            this.row.setId(Integer.parseInt(elements[1]));
        } catch (NumberFormatException e) {
            return true;
        }
        this.row.setUsername(elements[2]);
        this.row.setEmail(elements[3]);
        return false;
    }

    public Row getRow() {
        return row;
    }
}
