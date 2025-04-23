package com.entity.model;

import com.entity.YejiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 业绩
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class YejiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 部门领导
     */
    private Integer bumenlingdaoId;


    /**
     * 员工
     */
    private Integer yuangongId;


    /**
     * 业绩编号
     */
    private String yejiUuidNumber;


    /**
     * 服务公司名称
     */
    private String gongsiName;


    /**
     * 服务公司地址
     */
    private String gongsiAddress;


    /**
     * 提成
     */
    private Double tichengJine;


    /**
     * 业绩详情
     */
    private String yejiContent;


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
	 * 获取：部门领导
	 */
    public Integer getBumenlingdaoId() {
        return bumenlingdaoId;
    }


    /**
	 * 设置：部门领导
	 */
    public void setBumenlingdaoId(Integer bumenlingdaoId) {
        this.bumenlingdaoId = bumenlingdaoId;
    }
    /**
	 * 获取：员工
	 */
    public Integer getYuangongId() {
        return yuangongId;
    }


    /**
	 * 设置：员工
	 */
    public void setYuangongId(Integer yuangongId) {
        this.yuangongId = yuangongId;
    }
    /**
	 * 获取：业绩编号
	 */
    public String getYejiUuidNumber() {
        return yejiUuidNumber;
    }


    /**
	 * 设置：业绩编号
	 */
    public void setYejiUuidNumber(String yejiUuidNumber) {
        this.yejiUuidNumber = yejiUuidNumber;
    }
    /**
	 * 获取：服务公司名称
	 */
    public String getGongsiName() {
        return gongsiName;
    }


    /**
	 * 设置：服务公司名称
	 */
    public void setGongsiName(String gongsiName) {
        this.gongsiName = gongsiName;
    }
    /**
	 * 获取：服务公司地址
	 */
    public String getGongsiAddress() {
        return gongsiAddress;
    }


    /**
	 * 设置：服务公司地址
	 */
    public void setGongsiAddress(String gongsiAddress) {
        this.gongsiAddress = gongsiAddress;
    }
    /**
	 * 获取：提成
	 */
    public Double getTichengJine() {
        return tichengJine;
    }


    /**
	 * 设置：提成
	 */
    public void setTichengJine(Double tichengJine) {
        this.tichengJine = tichengJine;
    }
    /**
	 * 获取：业绩详情
	 */
    public String getYejiContent() {
        return yejiContent;
    }


    /**
	 * 设置：业绩详情
	 */
    public void setYejiContent(String yejiContent) {
        this.yejiContent = yejiContent;
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
