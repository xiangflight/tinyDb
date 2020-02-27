package domain;

import util.PromptUtil;

/**
 * @author xiangdotzhaoAtwoqutechcommacom
 * @date 2020/2/27
 */

public class Row {

    private int id;

    private String username;

    private String email;

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void show() {
        PromptUtil.printf("(%d, %s, %s)\n", this.id, this.username, this.email);
    }
}
