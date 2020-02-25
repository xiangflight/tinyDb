package domain;

import constant.Const;
import constant.Status;

/**
 * @author xiangdotzhaoAtwoqutechcommacom
 * @date 2020/2/25
 */

public class InputBuffer {

    private String buffer;

    private InputBuffer(String input) {
        if (input == null) {
            System.out.print("Error reading input\n");
            System.exit(Status.EXIT_FAILURE.code());
        }
        this.buffer = input;
    }

    public static InputBuffer newInstance(String input) {
        return new InputBuffer(input);
    }

    public String getBuffer() {
        return buffer;
    }

    public boolean exit() {
        return Const.EXIT_STRING_INTERNAL.equals(this.buffer);
    }

    public boolean notEmpty() {
        return !buffer.isEmpty();
    }
}
