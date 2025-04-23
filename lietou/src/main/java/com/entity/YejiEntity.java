package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 业绩
 *
 * @author 
 * @email
 */
@TableName("yeji")
public class YejiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YejiEntity() {

	}

	public YejiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
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
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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

    @Override
    public String toString() {
        return "Yeji{" +
            "id=" + id +
            ", bumenlingdaoId=" + bumenlingdaoId +
            ", yuangongId=" + yuangongId +
            ", yejiUuidNumber=" + yejiUuidNumber +
            ", gongsiName=" + gongsiName +
            ", gongsiAddress=" + gongsiAddress +
            ", tichengJine=" + tichengJine +
            ", yejiContent=" + yejiContent +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
