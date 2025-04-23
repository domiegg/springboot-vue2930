package com.entity.vo;

import com.entity.YejiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 业绩
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("yeji")
public class YejiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 部门领导
     */

    @TableField(value = "bumenlingdao_id")
    private Integer bumenlingdaoId;


    /**
     * 员工
     */

    @TableField(value = "yuangong_id")
    private Integer yuangongId;


    /**
     * 业绩编号
     */

    @TableField(value = "yeji_uuid_number")
    private String yejiUuidNumber;


    /**
     * 服务公司名称
     */

    @TableField(value = "gongsi_name")
    private String gongsiName;


    /**
     * 服务公司地址
     */

    @TableField(value = "gongsi_address")
    private String gongsiAddress;


    /**
     * 提成
     */

    @TableField(value = "ticheng_jine")
    private Double tichengJine;


    /**
     * 业绩详情
     */

    @TableField(value = "yeji_content")
    private String yejiContent;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


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
	 * 设置：部门领导
	 */
    public Integer getBumenlingdaoId() {
        return bumenlingdaoId;
    }


    /**
	 * 获取：部门领导
	 */

    public void setBumenlingdaoId(Integer bumenlingdaoId) {
        this.bumenlingdaoId = bumenlingdaoId;
    }
    /**
	 * 设置：员工
	 */
    public Integer getYuangongId() {
        return yuangongId;
    }


    /**
	 * 获取：员工
	 */

    public void setYuangongId(Integer yuangongId) {
        this.yuangongId = yuangongId;
    }
    /**
	 * 设置：业绩编号
	 */
    public String getYejiUuidNumber() {
        return yejiUuidNumber;
    }


    /**
	 * 获取：业绩编号
	 */

    public void setYejiUuidNumber(String yejiUuidNumber) {
        this.yejiUuidNumber = yejiUuidNumber;
    }
    /**
	 * 设置：服务公司名称
	 */
    public String getGongsiName() {
        return gongsiName;
    }


    /**
	 * 获取：服务公司名称
	 */

    public void setGongsiName(String gongsiName) {
        this.gongsiName = gongsiName;
    }
    /**
	 * 设置：服务公司地址
	 */
    public String getGongsiAddress() {
        return gongsiAddress;
    }


    /**
	 * 获取：服务公司地址
	 */

    public void setGongsiAddress(String gongsiAddress) {
        this.gongsiAddress = gongsiAddress;
    }
    /**
	 * 设置：提成
	 */
    public Double getTichengJine() {
        return tichengJine;
    }


    /**
	 * 获取：提成
	 */

    public void setTichengJine(Double tichengJine) {
        this.tichengJine = tichengJine;
    }
    /**
	 * 设置：业绩详情
	 */
    public String getYejiContent() {
        return yejiContent;
    }


    /**
	 * 获取：业绩详情
	 */

    public void setYejiContent(String yejiContent) {
        this.yejiContent = yejiContent;
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
