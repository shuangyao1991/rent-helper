package renthelper.core.model;

import renthelper.core.constants.RentTypeEnum;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with by shuangyao on 2016/10/9.
 */
public class RentInfo implements Serializable {

    private Integer number;

    private Double rentalPerMonth;

    private Integer rid;

    private Date startTime;

    private Date endTime;

    private RentTypeEnum rentTypeEnum;

    private Date expireTime;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Double getRentalPerMonth() {
        return rentalPerMonth;
    }

    public void setRentalPerMonth(Double rentalPerMonth) {
        this.rentalPerMonth = rentalPerMonth;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
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

    public RentTypeEnum getRentTypeEnum() {
        return rentTypeEnum;
    }

    public void setRentTypeEnum(RentTypeEnum rentTypeEnum) {
        this.rentTypeEnum = rentTypeEnum;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }
}
