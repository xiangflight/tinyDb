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

    private Statement() {

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
}
