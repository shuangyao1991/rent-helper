package renthelper.core.model;

import renthelper.core.constants.RentTypeEnum;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with by shuangyao on 2016/10/9.
 */
public class RentInfo implements Serializable {

    private Integer rid;

    private Double rentalPerMonth;

    private Integer renterNumber;

    private Integer uid;

    private Date startTime;

    private Date endTime;

    private String type;

    private String rentalExpireTime;

    private String createTime;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Double getRentalPerMonth() {
        return rentalPerMonth;
    }

    public void setRentalPerMonth(Double rentalPerMonth) {
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
