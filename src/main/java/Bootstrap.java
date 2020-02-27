import component.Repl;
import constant.TipEnum;

import java.util.Scanner;

/**
 * @author xiangdotzhaoAtwoqutechcommacom
 * @date 2020/2/25
 */

public class Bootstrap {

    public static void main(String[] args) {

        Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println(TipEnum.JVM_SHUTDOWN.getTip())));

        Scanner scanner = new Scanner(System.in);
        Repl repl = Repl.newInstance(scanner);

        repl.start();
    }

}
