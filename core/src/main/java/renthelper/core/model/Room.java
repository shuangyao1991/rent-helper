package renthelper.core.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with by shuangyao on 2016/10/26.
 */
public class Room implements Serializable {

    private Integer rid;

    private Integer rentalPerMonth;

    private Date createTime;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getRentalPerMonth() {
        return rentalPerMonth;
    }

    public void setRentalPerMonth(Integer rentalPerMonth) {
        this.rentalPerMonth = rentalPerMonth;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Room{" +
                "rid=" + rid +
                ", rentalPerMonth=" + rentalPerMonth +
                ", createTime=" + createTime +
                '}';
    }
}
