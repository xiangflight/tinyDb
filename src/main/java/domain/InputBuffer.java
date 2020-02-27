package domain;

import constant.StatementType;
import constant.TipEnum;

import java.util.Objects;

/**
 * @author xiangdotzhaoAtwoqutechcommacom
 * @date 2020/2/25
 */

public class InputBuffer {

    private volatile static InputBuffer inputBuffer;

    private String buffer;

    private InputBuffer() {
    }

    public static InputBuffer getInstance() {
        if (Objects.isNull(inputBuffer)) {
            inputBuffer = new InputBuffer();
        }
        return inputBuffer;
    }

    public String getBuffer() {
        return buffer;
    }

    public void setBuffer(String buffer) {
        this.buffer = buffer;
    }

    public boolean isMetaCommand() {
        return !buffer.isEmpty() && buffer.startsWith(".");
    }

    public boolean isEmpty() {
        return buffer.isEmpty();
    }

    public boolean exit() {
        return Objects.equals(TipEnum.EXIT.getTip(), buffer);
    }

    public boolean isInsertStatement() {
        return !isEmpty() && buffer.startsWith(StatementType.STATEMENT_INSERT.getType());
    }

    public boolean isSelectStatement() {
        return !isEmpty() && buffer.startsWith(StatementType.STATEMENT_SELECT.getType());
    }
}
