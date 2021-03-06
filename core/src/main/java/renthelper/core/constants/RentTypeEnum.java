package renthelper.core.constants;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created with by shuangyao on 2016/10/9.
 */
public enum  RentTypeEnum {

    MONTH(0, 1, "月"),
    QUARTER(1, 3, "季度"),
    HALF(2, 6, "半年"),
    YEAR(3, 12, "年");

    private Integer source;

    private Integer months;

    private String desc;

    private static final Map<String, RentTypeEnum> map = Maps.newHashMap();

    static {
        for (RentTypeEnum rentTypeEnum : RentTypeEnum.values()) {
            map.put(rentTypeEnum.getDesc(), rentTypeEnum);
        }
    }

    RentTypeEnum(Integer source, Integer months, String desc) {
        this.source = source;
        this.months = months;
        this.desc = desc;
    }

    public static RentTypeEnum getByDesc(String desc) {
        return map.get(desc);
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public Integer getMonths() {
        return months;
    }

    public void setMonths(Integer months) {
        this.months = months;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
