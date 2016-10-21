package renthelper.core.model;

import renthelper.core.constants.GenderEnum;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with by shuangyao on 2016/10/9.
 */
public class Renter implements Serializable {

    private Integer uid;

    private String name;

    private String mobile;

    private Integer age;

    private String gender;

    private Date birthday;

    private String comment;

    private Date createTime;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Renter{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", comment='" + comment + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
