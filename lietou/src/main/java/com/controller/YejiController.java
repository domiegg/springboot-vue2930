
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 业绩
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/yeji")
public class YejiController {
    private static final Logger logger = LoggerFactory.getLogger(YejiController.class);

    @Autowired
    private YejiService yejiService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private BumenlingdaoService bumenlingdaoService;
    @Autowired
    private YuangongService yuangongService;

    @Autowired
    private CaiwurenyuanService caiwurenyuanService;
    @Autowired
    private RenshiService renshiService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("普通员工".equals(role))
            params.put("yuangongId",request.getSession().getAttribute("userId"));
        else if("部门领导".equals(role)){
            BumenlingdaoEntity bumenlingdaoEntity = bumenlingdaoService.selectById(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            params.put("bumenlingdaoId",bumenlingdaoEntity.getId());
            params.put("bumenTypes",bumenlingdaoEntity.getBumenTypes());

        }
        else if("财务人员".equals(role))
            params.put("caiwurenyuanId",request.getSession().getAttribute("userId"));
        else if("人事人员".equals(role))
            params.put("renshiId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = yejiService.queryPage(params);

        //字典表数据转换
        List<YejiView> list =(List<YejiView>)page.getList();
        for(YejiView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        YejiEntity yeji = yejiService.selectById(id);
        if(yeji !=null){
            //entity转view
            YejiView view = new YejiView();
            BeanUtils.copyProperties( yeji , view );//把实体数据重构到view中

                //级联表
                BumenlingdaoEntity bumenlingdao = bumenlingdaoService.selectById(yeji.getBumenlingdaoId());
                if(bumenlingdao != null){
                    BeanUtils.copyProperties( bumenlingdao , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setBumenlingdaoId(bumenlingdao.getId());
                }
                //级联表
                YuangongEntity yuangong = yuangongService.selectById(yeji.getYuangongId());
                if(yuangong != null){
                    BeanUtils.copyProperties( yuangong , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYuangongId(yuangong.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody YejiEntity yeji, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,yeji:{}",this.getClass().getName(),yeji.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("部门领导".equals(role))
            yeji.setBumenlingdaoId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        else if("普通员工".equals(role))
            yeji.setYuangongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            yeji.setInsertTime(new Date());
            yeji.setCreateTime(new Date());
            yejiService.insert(yeji);
            return R.ok();

    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody YejiEntity yeji, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,yeji:{}",this.getClass().getName(),yeji.toString());


            yejiService.updateById(yeji);//根据id更新
            return R.ok();

    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        yejiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<YejiEntity> yejiList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            YejiEntity yejiEntity = new YejiEntity();
//                            yejiEntity.setBumenlingdaoId(Integer.valueOf(data.get(0)));   //部门领导 要改的
//                            yejiEntity.setYuangongId(Integer.valueOf(data.get(0)));   //员工 要改的
//                            yejiEntity.setYejiUuidNumber(data.get(0));                    //业绩编号 要改的
//                            yejiEntity.setGongsiName(data.get(0));                    //服务公司名称 要改的
//                            yejiEntity.setGongsiAddress(data.get(0));                    //服务公司地址 要改的
//                            yejiEntity.setTichengJine(data.get(0));                    //提成 要改的
//                            yejiEntity.setYejiContent("");//照片
//                            yejiEntity.setInsertTime(date);//时间
//                            yejiEntity.setCreateTime(date);//时间
                            yejiList.add(yejiEntity);


                            //把要查询是否重复的字段放入map中
                                //业绩编号
                                if(seachFields.containsKey("yejiUuidNumber")){
                                    List<String> yejiUuidNumber = seachFields.get("yejiUuidNumber");
                                    yejiUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> yejiUuidNumber = new ArrayList<>();
                                    yejiUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("yejiUuidNumber",yejiUuidNumber);
                                }
                        }

                        //查询是否重复
                         //业绩编号
                        List<YejiEntity> yejiEntities_yejiUuidNumber = yejiService.selectList(new EntityWrapper<YejiEntity>().in("yeji_uuid_number", seachFields.get("yejiUuidNumber")));
                        if(yejiEntities_yejiUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(YejiEntity s:yejiEntities_yejiUuidNumber){
                                repeatFields.add(s.getYejiUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [业绩编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        yejiService.insertBatch(yejiList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = yejiService.queryPage(params);

        //字典表数据转换
        List<YejiView> list =(List<YejiView>)page.getList();
        for(YejiView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        YejiEntity yeji = yejiService.selectById(id);
            if(yeji !=null){


                //entity转view
                YejiView view = new YejiView();
                BeanUtils.copyProperties( yeji , view );//把实体数据重构到view中

                //级联表
                    BumenlingdaoEntity bumenlingdao = bumenlingdaoService.selectById(yeji.getBumenlingdaoId());
                if(bumenlingdao != null){
                    BeanUtils.copyProperties( bumenlingdao , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setBumenlingdaoId(bumenlingdao.getId());
                }
                //级联表
                    YuangongEntity yuangong = yuangongService.selectById(yeji.getYuangongId());
                if(yuangong != null){
                    BeanUtils.copyProperties( yuangong , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYuangongId(yuangong.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody YejiEntity yeji, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,yeji:{}",this.getClass().getName(),yeji.toString());
        Wrapper<YejiEntity> queryWrapper = new EntityWrapper<YejiEntity>()
            .eq("bumenlingdao_id", yeji.getBumenlingdaoId())
            .eq("yuangong_id", yeji.getYuangongId())
            .eq("yeji_uuid_number", yeji.getYejiUuidNumber())
            .eq("gongsi_name", yeji.getGongsiName())
            .eq("gongsi_address", yeji.getGongsiAddress())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YejiEntity yejiEntity = yejiService.selectOne(queryWrapper);
        if(yejiEntity==null){
            yeji.setInsertTime(new Date());
            yeji.setCreateTime(new Date());
        yejiService.insert(yeji);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}
