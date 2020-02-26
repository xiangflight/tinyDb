package component;

import domain.Statement;
import util.PromptUtil;

/**
 * @author xiangdotzhaoAtwoqutechcommacom
 * @date 2020/2/26
 */

public class Executor {



    public void executeStatement(Statement statement) {
        switch (statement.getType()) {
            case STATEMENT_INSERT:
                PromptUtil.println("This is where we would do an insert.");
                break;
            case STATEMENT_SELECT:
                PromptUtil.println("This is where we would do a select.");
                break;
            default:
        }
    }
}
