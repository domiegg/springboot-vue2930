package com.entity.view;

import com.entity.YejiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 业绩
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("yeji")
public class YejiView extends YejiEntity implements Serializable {
    private static final long serialVersionUID = 1L;




		//级联表 bumenlingdao
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
			* 电子邮箱
			*/
			private String bumenlingdaoEmail;
			/**
			* 家庭住址
			*/
			private String bumenlingdaoZhuzhi;

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

	public YejiView() {

	}

	public YejiView(YejiEntity yejiEntity) {
		try {
			BeanUtils.copyProperties(this, yejiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}







				//级联表的get和set bumenlingdao
					/**
					* 获取： 部门领导姓名
					*/
					public String getBumenlingdaoName() {
						return bumenlingdaoName;
					}
					/**
					* 设置： 部门领导姓名
					*/
					public void setBumenlingdaoName(String bumenlingdaoName) {
						this.bumenlingdaoName = bumenlingdaoName;
					}
					/**
					* 获取： 部门领导手机号
					*/
					public String getBumenlingdaoPhone() {
						return bumenlingdaoPhone;
					}
					/**
					* 设置： 部门领导手机号
					*/
					public void setBumenlingdaoPhone(String bumenlingdaoPhone) {
						this.bumenlingdaoPhone = bumenlingdaoPhone;
					}
					/**
					* 获取： 部门领导身份证号
					*/
					public String getBumenlingdaoIdNumber() {
						return bumenlingdaoIdNumber;
					}
					/**
					* 设置： 部门领导身份证号
					*/
					public void setBumenlingdaoIdNumber(String bumenlingdaoIdNumber) {
						this.bumenlingdaoIdNumber = bumenlingdaoIdNumber;
					}
					/**
					* 获取： 部门领导头像
					*/
					public String getBumenlingdaoPhoto() {
						return bumenlingdaoPhoto;
					}
					/**
					* 设置： 部门领导头像
					*/
					public void setBumenlingdaoPhoto(String bumenlingdaoPhoto) {
						this.bumenlingdaoPhoto = bumenlingdaoPhoto;
					}
					/**
					* 获取： 电子邮箱
					*/
					public String getBumenlingdaoEmail() {
						return bumenlingdaoEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setBumenlingdaoEmail(String bumenlingdaoEmail) {
						this.bumenlingdaoEmail = bumenlingdaoEmail;
					}
					/**
					* 获取： 家庭住址
					*/
					public String getBumenlingdaoZhuzhi() {
						return bumenlingdaoZhuzhi;
					}
					/**
					* 设置： 家庭住址
					*/
					public void setBumenlingdaoZhuzhi(String bumenlingdaoZhuzhi) {
						this.bumenlingdaoZhuzhi = bumenlingdaoZhuzhi;
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
