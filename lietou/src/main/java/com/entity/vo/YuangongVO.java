package com.entity.vo;

import com.entity.YuangongEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 普通员工
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("yuangong")
public class YuangongVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 账户
     */

    @TableField(value = "username")
    private String username;


    /**
     * 密码
     */

    @TableField(value = "password")
    private String password;


    /**
     * 普通员工姓名
     */

    @TableField(value = "yuangong_name")
    private String yuangongName;


    /**
     * 普通员工手机号
     */

    @TableField(value = "yuangong_phone")
    private String yuangongPhone;


    /**
     * 普通员工身份证号
     */

    @TableField(value = "yuangong_id_number")
    private String yuangongIdNumber;


    /**
     * 普通员工头像
     */

    @TableField(value = "yuangong_photo")
    private String yuangongPhoto;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 部门
     */

    @TableField(value = "bumen_types")
    private Integer bumenTypes;


    /**
     * 电子邮箱
     */

    @TableField(value = "yuangong_email")
    private String yuangongEmail;


    /**
     * 籍贯
     */

    @TableField(value = "jiguan")
    private String jiguan;


    /**
     * 家庭住址
     */

    @TableField(value = "yuangong_zhuzhi")
    private String yuangongZhuzhi;


    /**
     * 入职时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "ruzhi_time")
    private Date ruzhiTime;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 逻辑删除
     */

    @TableField(value = "yuangong_delete")
    private Integer yuangongDelete;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：普通员工姓名
	 */
    public String getYuangongName() {
        return yuangongName;
    }


    /**
	 * 获取：普通员工姓名
	 */

    public void setYuangongName(String yuangongName) {
        this.yuangongName = yuangongName;
    }
    /**
	 * 设置：普通员工手机号
	 */
    public String getYuangongPhone() {
        return yuangongPhone;
    }


    /**
	 * 获取：普通员工手机号
	 */

    public void setYuangongPhone(String yuangongPhone) {
        this.yuangongPhone = yuangongPhone;
    }
    /**
	 * 设置：普通员工身份证号
	 */
    public String getYuangongIdNumber() {
        return yuangongIdNumber;
    }


    /**
	 * 获取：普通员工身份证号
	 */

    public void setYuangongIdNumber(String yuangongIdNumber) {
        this.yuangongIdNumber = yuangongIdNumber;
    }
    /**
	 * 设置：普通员工头像
	 */
    public String getYuangongPhoto() {
        return yuangongPhoto;
    }


    /**
	 * 获取：普通员工头像
	 */

    public void setYuangongPhoto(String yuangongPhoto) {
        this.yuangongPhoto = yuangongPhoto;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：部门
	 */
    public Integer getBumenTypes() {
        return bumenTypes;
    }


    /**
	 * 获取：部门
	 */

    public void setBumenTypes(Integer bumenTypes) {
        this.bumenTypes = bumenTypes;
    }
    /**
	 * 设置：电子邮箱
	 */
    public String getYuangongEmail() {
        return yuangongEmail;
    }


    /**
	 * 获取：电子邮箱
	 */

    public void setYuangongEmail(String yuangongEmail) {
        this.yuangongEmail = yuangongEmail;
    }
    /**
	 * 设置：籍贯
	 */
    public String getJiguan() {
        return jiguan;
    }


    /**
	 * 获取：籍贯
	 */

    public void setJiguan(String jiguan) {
        this.jiguan = jiguan;
    }
    /**
	 * 设置：家庭住址
	 */
    public String getYuangongZhuzhi() {
        return yuangongZhuzhi;
    }


    /**
	 * 获取：家庭住址
	 */

    public void setYuangongZhuzhi(String yuangongZhuzhi) {
        this.yuangongZhuzhi = yuangongZhuzhi;
    }
    /**
	 * 设置：入职时间
	 */
    public Date getRuzhiTime() {
        return ruzhiTime;
    }


    /**
	 * 获取：入职时间
	 */

    public void setRuzhiTime(Date ruzhiTime) {
        this.ruzhiTime = ruzhiTime;
    }
    /**
	 * 设置：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：添加时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getYuangongDelete() {
        return yuangongDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setYuangongDelete(Integer yuangongDelete) {
        this.yuangongDelete = yuangongDelete;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
