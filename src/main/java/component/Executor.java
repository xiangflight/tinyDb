package component;

import constant.ExecuteResult;
import domain.Statement;
import domain.Table;

/**
 * @author xiangdotzhaoAtwoqutechcommacom
 * @date 2020/2/26
 */

public class Executor {

    private Table table;

    private Executor() {
        table = new Table();
    }

    public static Executor getInstance() {
        return new Executor();
    }


    public ExecuteResult executeStatement(Statement statement) {
        switch (statement.getType()) {
            case STATEMENT_INSERT:
                return executeInsert(statement);
            case STATEMENT_SELECT:
                return executeSelect(statement);
            default:
        }
        throw new UnsupportedOperationException("unsupported operation");
    }

    private ExecuteResult executeSelect(Statement statement) {
        return ExecuteResult.EXECUTE_SUCCESS;
    }

    private ExecuteResult executeInsert(Statement statement) {
        return ExecuteResult.EXECUTE_SUCCESS;
    }
}
