package constants;

/**
 * Created with by shuangyao on 2016/10/9.
 */
public enum GenderEnum {

    UNKNOWN(0, "未知"),
    MALE(1, "男"),
    FEMALE(2, "女");

    private int source;

    private String desc;

    GenderEnum(int source, String desc) {
        this.source = source;
        this.desc = desc;
    }
}
