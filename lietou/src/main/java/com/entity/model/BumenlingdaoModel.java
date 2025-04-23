package com.entity.model;

import com.entity.BumenlingdaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 部门领导
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class BumenlingdaoModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 部门领导姓名
     */
    private String bumenlingdaoName;


    /**
     * 部门领导手机号
     */
    private String bumenlingdaoPhone;


    /**
     * 部门领导身份证号
     */
    private String bumenlingdaoIdNumber;


    /**
     * 部门领导头像
     */
    private String bumenlingdaoPhoto;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 部门
     */
    private Integer bumenTypes;


    /**
     * 电子邮箱
     */
    private String bumenlingdaoEmail;


    /**
     * 籍贯
     */
    private String jiguan;


    /**
     * 家庭住址
     */
    private String bumenlingdaoZhuzhi;


    /**
     * 入职时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date ruzhiTime;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 设置：账户
	 */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 设置：密码
	 */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：部门领导姓名
	 */
    public String getBumenlingdaoName() {
        return bumenlingdaoName;
    }


    /**
	 * 设置：部门领导姓名
	 */
    public void setBumenlingdaoName(String bumenlingdaoName) {
        this.bumenlingdaoName = bumenlingdaoName;
    }
    /**
	 * 获取：部门领导手机号
	 */
    public String getBumenlingdaoPhone() {
        return bumenlingdaoPhone;
    }


    /**
	 * 设置：部门领导手机号
	 */
    public void setBumenlingdaoPhone(String bumenlingdaoPhone) {
        this.bumenlingdaoPhone = bumenlingdaoPhone;
    }
    /**
	 * 获取：部门领导身份证号
	 */
    public String getBumenlingdaoIdNumber() {
        return bumenlingdaoIdNumber;
    }


    /**
	 * 设置：部门领导身份证号
	 */
    public void setBumenlingdaoIdNumber(String bumenlingdaoIdNumber) {
        this.bumenlingdaoIdNumber = bumenlingdaoIdNumber;
    }
    /**
	 * 获取：部门领导头像
	 */
    public String getBumenlingdaoPhoto() {
        return bumenlingdaoPhoto;
    }


    /**
	 * 设置：部门领导头像
	 */
    public void setBumenlingdaoPhoto(String bumenlingdaoPhoto) {
        this.bumenlingdaoPhoto = bumenlingdaoPhoto;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 设置：性别
	 */
    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：部门
	 */
    public Integer getBumenTypes() {
        return bumenTypes;
    }


    /**
	 * 设置：部门
	 */
    public void setBumenTypes(Integer bumenTypes) {
        this.bumenTypes = bumenTypes;
    }
    /**
	 * 获取：电子邮箱
	 */
    public String getBumenlingdaoEmail() {
        return bumenlingdaoEmail;
    }


    /**
	 * 设置：电子邮箱
	 */
    public void setBumenlingdaoEmail(String bumenlingdaoEmail) {
        this.bumenlingdaoEmail = bumenlingdaoEmail;
    }
    /**
	 * 获取：籍贯
	 */
    public String getJiguan() {
        return jiguan;
    }


    /**
	 * 设置：籍贯
	 */
    public void setJiguan(String jiguan) {
        this.jiguan = jiguan;
    }
    /**
	 * 获取：家庭住址
	 */
    public String getBumenlingdaoZhuzhi() {
        return bumenlingdaoZhuzhi;
    }


    /**
	 * 设置：家庭住址
	 */
    public void setBumenlingdaoZhuzhi(String bumenlingdaoZhuzhi) {
        this.bumenlingdaoZhuzhi = bumenlingdaoZhuzhi;
    }
    /**
	 * 获取：入职时间
	 */
    public Date getRuzhiTime() {
        return ruzhiTime;
    }


    /**
	 * 设置：入职时间
	 */
    public void setRuzhiTime(Date ruzhiTime) {
        this.ruzhiTime = ruzhiTime;
    }
    /**
	 * 获取：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：添加时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
