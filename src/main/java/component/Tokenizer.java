package component;

import constant.*;
import domain.InputBuffer;
import domain.Statement;
import util.PromptUtil;

import static constant.MetaCommandResult.META_COMMAND_SUCCESS;
import static constant.MetaCommandResult.META_COMMAND_UNRECOGNIZED_COMMAND;

/**
 * @author xiangdotzhaoAtwoqutechcommacom
 * @date 2020/2/26
 */

public class Tokenizer {

    private InputBuffer inputBuffer;
    private Statement statement;
    private Executor executor;

    public Tokenizer() {
        inputBuffer = InputBuffer.getInstance();
        statement = Statement.getInstance();
        executor = new Executor();
    }

    public void process(String input) {
        inputBuffer.setBuffer(input);

        if (inputBuffer.isEmpty()) {
            return;
        }
        if (inputBuffer.isMetaCommand()) {
            switch (processMetaCommand(inputBuffer)) {
                case META_COMMAND_SUCCESS:
                    return;
                case META_COMMAND_UNRECOGNIZED_COMMAND:
                    PromptUtil.printf(Const.UNRECOGNIZED_META_COMMAND, inputBuffer.getBuffer());
                    return;
                default:
            }
        }

        switch (prepareStatement(inputBuffer, statement)) {
            case PREPARE_SUCCESS:
                break;
            case PREPARE_UNRECOGNIZED_STATEMENT:
                PromptUtil.printf(Const.UNRECOGNIZED_COMMAND, inputBuffer.getBuffer());
                return;
            default:
        }

        executor.executeStatement(statement);

        PromptUtil.println(Const.EXECUTE_NOTICE);
    }

    MetaCommandResult processMetaCommand(InputBuffer buffer) {
        if (buffer.exit()) {
            System.exit(Status.EXIT_SUCCESS.code());
            return META_COMMAND_SUCCESS;
        } else {
            return META_COMMAND_UNRECOGNIZED_COMMAND;
        }
    }

    PrepareResult prepareStatement(InputBuffer buffer, Statement statement) {
        if (buffer.isInsertStatement()) {
            statement.setType(StatementType.STATEMENT_INSERT);
            return PrepareResult.PREPARE_SUCCESS;
        }
        if (buffer.isSelectStatement()) {
            statement.setType(StatementType.STATEMENT_SELECT);
            return PrepareResult.PREPARE_SUCCESS;
        }
        return PrepareResult.PREPARE_UNRECOGNIZED_STATEMENT;
    }
}
