package com.dao;

import com.entity.YejiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.YejiView;

/**
 * 业绩 Dao 接口
 *
 * @author 
 */
public interface YejiDao extends BaseMapper<YejiEntity> {

   List<YejiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
