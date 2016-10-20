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

    private String startTime;

    private String endTime;

    private String type;

    private String rentalExpireTime;

    private String createTime;

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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
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
