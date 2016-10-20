package renthelper.core.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with by shuangyao on 2016/10/9.
 */
public class RentLog implements Serializable {

    private Integer lid;

    private Integer rid;

    private Integer uid;

    private Integer pay;

    private String rentalExpireTime;

    private String createTime;

    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getPay() {
        return pay;
    }

    public void setPay(Integer pay) {
        this.pay = pay;
    }

    public String getRentalExpireTime() {
        return rentalExpireTime;
    }

    public void setRentalExpireTime(String rentalExpireTime) {
        this.rentalExpireTime = rentalExpireTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
