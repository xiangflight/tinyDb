package component;

import domain.Row;
import domain.Table;
import util.PromptUtil;

import java.util.Objects;

/**
 * @author xiangdotzhaoAtwoqutechcommacom
 * @date 2020/2/27
 */

public class Serializer {

    private volatile static Serializer INSTANCE;

    private Serializer() {
    }

    public static Serializer getInstance() {
        if (Objects.isNull(INSTANCE)) {
            INSTANCE = new Serializer();
        }
        return INSTANCE;
    }

    void serialize(Table table, Row row) {
        PromptUtil.println("序列化");
    }
}
