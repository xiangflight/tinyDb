package domain;

import constant.PrepareStateResult;

/**
 * @author xiangdotzhaoAtwoqutechcommacom
 * @date 2020/3/9
 */

public class PrepareResult {

    Statement statement;

    PrepareStateResult prepareStateResult;

    public PrepareResult(Statement statement, PrepareStateResult prepareStateResult) {
        this.statement = statement;
        this.prepareStateResult = prepareStateResult;
    }

    public static PrepareResult getInstance(Statement statement, PrepareStateResult prepareResult) {
        return new PrepareResult(statement, prepareResult);
    }

    public Statement getStatement() {
        return statement;
    }

    public PrepareStateResult getPrepareStateResult() {
        return prepareStateResult;
    }
}
