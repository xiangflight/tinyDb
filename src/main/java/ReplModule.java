import constant.Const;
import constant.Status;
import domain.InputBuffer;

import java.util.Scanner;

/**
 * @author xiangdotzhaoAtwoqutechcommacom
 * @date 2020/2/25
 * <p>
 * 交互式解释器 REPL short for Read-Eval-Print-Loop
 */

public class ReplModule {

    static ReplModule newInstance() {
        return new ReplModule();
    }

    public void process() {
        while (true) {
            prompt();
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            InputBuffer inputBuffer = InputBuffer.newInstance(input);
            if (inputBuffer.exit()) {
                System.exit(Status.EXIT_SUCCESS.code());
            }
            if (inputBuffer.notEmpty()) {
                System.out.printf(Const.UNRECOGNIZED_NOTE, inputBuffer.getBuffer());
            }
        }
    }

    private void prompt() {
        System.out.print(Const.PROMPT_TIP);
    }

}
