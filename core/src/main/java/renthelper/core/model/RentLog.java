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

    private Date rentalExpireTime;

    private Date createTime;

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

    public Date getRentalExpireTime() {
        return rentalExpireTime;
    }

    public void setRentalExpireTime(Date rentalExpireTime) {
        this.rentalExpireTime = rentalExpireTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
