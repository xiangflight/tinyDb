package component;

import constant.*;
import domain.InputBuffer;
import domain.PrepareResult;
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
    private Executor executor;

    public Tokenizer() {
        inputBuffer = InputBuffer.getInstance();
        executor = Executor.getInstance();
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
                    PromptUtil.printf(TipEnum.UNRECOGNIZED_META_COMMAND.getTip(), inputBuffer.getBuffer());
                    return;
                default:
            }
        }

        PrepareResult result = prepareStatement(inputBuffer);
        switch (result.getPrepareStateResult()) {
            case PREPARE_SUCCESS:
                break;
            case PREPARE_SYNTAX_ERROR:
                PromptUtil.println(TipEnum.COMMAND_SYNTAX_ERROR.getTip());
                return;
            case PREPARE_UNRECOGNIZED_STATEMENT:
                PromptUtil.printf(TipEnum.UNRECOGNIZED_NORMAL_COMMAND.getTip(), inputBuffer.getBuffer());
                return;
            default:
        }

        switch (executor.executeStatement(result.getStatement())) {
            case EXECUTE_SUCCESS:
                PromptUtil.println(TipEnum.EXECUTED.getTip());
                break;
            case EXECUTE_TABLE_FULL:
                PromptUtil.println(TipEnum.TABLE_FULL_ERROR.getTip());
                break;
            default:
        }
    }

    MetaCommandResult processMetaCommand(InputBuffer buffer) {
        if (buffer.exit()) {
            System.exit(Status.EXIT_SUCCESS.code());
            return META_COMMAND_SUCCESS;
        } else {
            return META_COMMAND_UNRECOGNIZED_COMMAND;
        }
    }

    PrepareResult prepareStatement(InputBuffer buffer) {
        Statement statement = Statement.getInstance();
        if (buffer.isInsertStatement()) {
            statement.setType(StatementType.STATEMENT_INSERT);
            if (statement.transfer(buffer)) {
                return PrepareResult.getInstance(statement, PrepareStateResult.PREPARE_SYNTAX_ERROR);
            }
            return PrepareResult.getInstance(statement, PrepareStateResult.PREPARE_SUCCESS);
        }
        if (buffer.isSelectStatement()) {
            statement.setType(StatementType.STATEMENT_SELECT);
            return PrepareResult.getInstance(statement, PrepareStateResult.PREPARE_SUCCESS);
        }
        return PrepareResult.getInstance(statement, PrepareStateResult.PREPARE_UNRECOGNIZED_STATEMENT);
    }
}
