import constant.Const;

/**
 * @author xiangdotzhaoAtwoqutechcommacom
 * @date 2020/2/25
 */

public class Bootstrap {

    public static void main(String[] args) {

        Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println(Const.JVM_SHUTDOWN_TIP)));

        ReplModule repl = ReplModule.newInstance();
        repl.process();
    }

}
