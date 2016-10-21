package renthelper.core.model;

import renthelper.core.constants.RentTypeEnum;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with by shuangyao on 2016/10/9.
 */
public class RentInfo implements Serializable {

    private Integer iid;

    private Integer rid;

    private Integer rentalPerMonth;

    private Integer renterNumber;

    private Integer uid;

    private Date startTime;

    private Date endTime;

    private String type;

    private Date rentalExpireTime;

    private Date createTime;

    public Integer getIid() {
        return iid;
    }

    public void setIid(Integer iid) {
        this.iid = iid;
    }

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

    public Integer getRenterNumber() {
        return renterNumber;
    }

    public void setRenterNumber(Integer renterNumber) {
        this.renterNumber = renterNumber;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    @Override
    public String toString() {
        return "RentInfo{" +
                "iid=" + iid +
                ", rid=" + rid +
                ", rentalPerMonth=" + rentalPerMonth +
                ", renterNumber=" + renterNumber +
                ", uid=" + uid +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", type='" + type + '\'' +
                ", rentalExpireTime=" + rentalExpireTime +
                ", createTime=" + createTime +
                '}';
    }
}
