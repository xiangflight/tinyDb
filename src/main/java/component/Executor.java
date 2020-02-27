package component;

import constant.ExecuteResult;
import domain.Row;
import domain.Statement;
import domain.Table;

/**
 * @author xiangdotzhaoAtwoqutechcommacom
 * @date 2020/2/26
 */

public class Executor {

    private Table table;
    private Serializer serializer;

    private Executor() {
        table = new Table();
        serializer = Serializer.getInstance();
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

    /**
     * how to get data from table
     *
     * @param statement get data
     * @return execute result
     */
    private ExecuteResult executeSelect(Statement statement) {
        return ExecuteResult.EXECUTE_SUCCESS;
    }

    /**
     * how to insert, how to serialize data
     *
     * @param statement get data from statement
     * @return execute result
     */
    private ExecuteResult executeInsert(Statement statement) {
        if (table.isFull()) {
            return ExecuteResult.EXECUTE_TABLE_FULL;
        }
        Row row = statement.getRow();
        serializer.serialize(table, row);
        return ExecuteResult.EXECUTE_SUCCESS;
    }
}
