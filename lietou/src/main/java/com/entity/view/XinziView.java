package com.entity.view;

import com.entity.XinziEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 薪资
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("xinzi")
public class XinziView extends XinziEntity implements Serializable {
    private static final long serialVersionUID = 1L;




		//级联表 caiwurenyuan
			/**
			* 财务人员姓名
			*/
			private String caiwurenyuanName;
			/**
			* 财务人员手机号
			*/
			private String caiwurenyuanPhone;
			/**
			* 财务人员身份证号
			*/
			private String caiwurenyuanIdNumber;
			/**
			* 财务人员头像
			*/
			private String caiwurenyuanPhoto;

		//级联表 yuangong
			/**
			* 普通员工姓名
			*/
			private String yuangongName;
			/**
			* 普通员工手机号
			*/
			private String yuangongPhone;
			/**
			* 普通员工身份证号
			*/
			private String yuangongIdNumber;
			/**
			* 普通员工头像
			*/
			private String yuangongPhoto;
			/**
			* 电子邮箱
			*/
			private String yuangongEmail;
			/**
			* 家庭住址
			*/
			private String yuangongZhuzhi;
			/**
			* 逻辑删除
			*/
			private Integer yuangongDelete;

	public XinziView() {

	}

	public XinziView(XinziEntity xinziEntity) {
		try {
			BeanUtils.copyProperties(this, xinziEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}










				//级联表的get和set caiwurenyuan
					/**
					* 获取： 财务人员姓名
					*/
					public String getCaiwurenyuanName() {
						return caiwurenyuanName;
					}
					/**
					* 设置： 财务人员姓名
					*/
					public void setCaiwurenyuanName(String caiwurenyuanName) {
						this.caiwurenyuanName = caiwurenyuanName;
					}
					/**
					* 获取： 财务人员手机号
					*/
					public String getCaiwurenyuanPhone() {
						return caiwurenyuanPhone;
					}
					/**
					* 设置： 财务人员手机号
					*/
					public void setCaiwurenyuanPhone(String caiwurenyuanPhone) {
						this.caiwurenyuanPhone = caiwurenyuanPhone;
					}
					/**
					* 获取： 财务人员身份证号
					*/
					public String getCaiwurenyuanIdNumber() {
						return caiwurenyuanIdNumber;
					}
					/**
					* 设置： 财务人员身份证号
					*/
					public void setCaiwurenyuanIdNumber(String caiwurenyuanIdNumber) {
						this.caiwurenyuanIdNumber = caiwurenyuanIdNumber;
					}
					/**
					* 获取： 财务人员头像
					*/
					public String getCaiwurenyuanPhoto() {
						return caiwurenyuanPhoto;
					}
					/**
					* 设置： 财务人员头像
					*/
					public void setCaiwurenyuanPhoto(String caiwurenyuanPhoto) {
						this.caiwurenyuanPhoto = caiwurenyuanPhoto;
					}

























				//级联表的get和set yuangong
					/**
					* 获取： 普通员工姓名
					*/
					public String getYuangongName() {
						return yuangongName;
					}
					/**
					* 设置： 普通员工姓名
					*/
					public void setYuangongName(String yuangongName) {
						this.yuangongName = yuangongName;
					}
					/**
					* 获取： 普通员工手机号
					*/
					public String getYuangongPhone() {
						return yuangongPhone;
					}
					/**
					* 设置： 普通员工手机号
					*/
					public void setYuangongPhone(String yuangongPhone) {
						this.yuangongPhone = yuangongPhone;
					}
					/**
					* 获取： 普通员工身份证号
					*/
					public String getYuangongIdNumber() {
						return yuangongIdNumber;
					}
					/**
					* 设置： 普通员工身份证号
					*/
					public void setYuangongIdNumber(String yuangongIdNumber) {
						this.yuangongIdNumber = yuangongIdNumber;
					}
					/**
					* 获取： 普通员工头像
					*/
					public String getYuangongPhoto() {
						return yuangongPhoto;
					}
					/**
					* 设置： 普通员工头像
					*/
					public void setYuangongPhoto(String yuangongPhoto) {
						this.yuangongPhoto = yuangongPhoto;
					}
					/**
					* 获取： 电子邮箱
					*/
					public String getYuangongEmail() {
						return yuangongEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setYuangongEmail(String yuangongEmail) {
						this.yuangongEmail = yuangongEmail;
					}
					/**
					* 获取： 家庭住址
					*/
					public String getYuangongZhuzhi() {
						return yuangongZhuzhi;
					}
					/**
					* 设置： 家庭住址
					*/
					public void setYuangongZhuzhi(String yuangongZhuzhi) {
						this.yuangongZhuzhi = yuangongZhuzhi;
					}
					/**
					* 获取： 逻辑删除
					*/
					public Integer getYuangongDelete() {
						return yuangongDelete;
					}
					/**
					* 设置： 逻辑删除
					*/
					public void setYuangongDelete(Integer yuangongDelete) {
						this.yuangongDelete = yuangongDelete;
					}



}
