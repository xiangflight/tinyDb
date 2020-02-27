package component;

import constant.TipEnum;
import util.PromptUtil;

import java.util.Scanner;

/**
 * @author xiangdotzhaoAtwoqutechcommacom
 * @date 2020/2/25
 * <p>
 * 交互式解释器 REPL short for Read-Eval-Print-Loop
 */

public class Repl {

    private Tokenizer tokenizer;
    private Scanner scanner;

    private Repl(Scanner scanner) {
        this.scanner = scanner;
        tokenizer = new Tokenizer();
    }

    public static Repl newInstance(Scanner scanner) {
        return new Repl(scanner);
    }

    @SuppressWarnings("InfiniteLoopStatement")
    public void start() {
        while (true) {
            prompt();
            tokenizer.process(scanner.nextLine());
        }
    }

    private void prompt() {
        PromptUtil.print(TipEnum.PROMPT.getTip());
    }

}
