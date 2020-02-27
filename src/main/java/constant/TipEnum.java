package constant;

/**
 * @author xiangdotzhaoAtwoqutechcommacom
 * @date 2020/2/25
 */

public enum TipEnum {
    /**
     * 退出
     */
    EXIT(".exit"),
    /**
     * 执行
     */
    EXECUTED("Executed."),
    /**
     * 虚拟机关闭
     */
    JVM_SHUTDOWN("~"),
    /**
     * 提示语
     */
    PROMPT("db > "),
    /**
     * 未能识别的元命令
     */
    UNRECOGNIZED_META_COMMAND("Unrecognized command '%s'.\n"),
    /**
     * 未能识别的命令
     */
    UNRECOGNIZED_NORMAL_COMMAND("Unrecognized keyword at start of '%s'.\n"),
    /**
     * 命令语法错误
     */
    COMMAND_SYNTAX_ERROR("Syntax error. Could not parse statement."),
    /**
     * 表格空间已满
     */
    TABLE_FULL_ERROR("Error: Table full.");

    private String tip;

    TipEnum(String tip) {
        this.tip = tip;
    }

    public String getTip() {
        return tip;
    }
}
