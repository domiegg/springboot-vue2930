package com.entity.view;

import com.entity.BumenlingdaoEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 部门领导
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("bumenlingdao")
public class BumenlingdaoView extends BumenlingdaoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 性别的值
		*/
		private String sexValue;
		/**
		* 部门的值
		*/
		private String bumenValue;



	public BumenlingdaoView() {

	}

	public BumenlingdaoView(BumenlingdaoEntity bumenlingdaoEntity) {
		try {
			BeanUtils.copyProperties(this, bumenlingdaoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 性别的值
			*/
			public String getSexValue() {
				return sexValue;
			}
			/**
			* 设置： 性别的值
			*/
			public void setSexValue(String sexValue) {
				this.sexValue = sexValue;
			}
			/**
			* 获取： 部门的值
			*/
			public String getBumenValue() {
				return bumenValue;
			}
			/**
			* 设置： 部门的值
			*/
			public void setBumenValue(String bumenValue) {
				this.bumenValue = bumenValue;
			}













}
