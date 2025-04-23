
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
 * 部门领导
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/bumenlingdao")
public class BumenlingdaoController {
    private static final Logger logger = LoggerFactory.getLogger(BumenlingdaoController.class);

    @Autowired
    private BumenlingdaoService bumenlingdaoService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

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
        else if("部门领导".equals(role))
            params.put("bumenlingdaoId",request.getSession().getAttribute("userId"));
        else if("财务人员".equals(role))
            params.put("caiwurenyuanId",request.getSession().getAttribute("userId"));
        else if("人事人员".equals(role))
            params.put("renshiId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = bumenlingdaoService.queryPage(params);

        //字典表数据转换
        List<BumenlingdaoView> list =(List<BumenlingdaoView>)page.getList();
        for(BumenlingdaoView c:list){
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
        BumenlingdaoEntity bumenlingdao = bumenlingdaoService.selectById(id);
        if(bumenlingdao !=null){
            //entity转view
            BumenlingdaoView view = new BumenlingdaoView();
            BeanUtils.copyProperties( bumenlingdao , view );//把实体数据重构到view中

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
    public R save(@RequestBody BumenlingdaoEntity bumenlingdao, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,bumenlingdao:{}",this.getClass().getName(),bumenlingdao.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<BumenlingdaoEntity> queryWrapper = new EntityWrapper<BumenlingdaoEntity>()
            .eq("username", bumenlingdao.getUsername())
            .or()
            .eq("bumenlingdao_phone", bumenlingdao.getBumenlingdaoPhone())
            .or()
            .eq("bumenlingdao_id_number", bumenlingdao.getBumenlingdaoIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        BumenlingdaoEntity bumenlingdaoEntity = bumenlingdaoService.selectOne(queryWrapper);
        if(bumenlingdaoEntity==null){
            bumenlingdao.setInsertTime(new Date());
            bumenlingdao.setCreateTime(new Date());
            bumenlingdao.setPassword("123456");
            bumenlingdaoService.insert(bumenlingdao);
            return R.ok();
        }else {
            return R.error(511,"账户或者部门领导手机号或者部门领导身份证号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody BumenlingdaoEntity bumenlingdao, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,bumenlingdao:{}",this.getClass().getName(),bumenlingdao.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<BumenlingdaoEntity> queryWrapper = new EntityWrapper<BumenlingdaoEntity>()
            .notIn("id",bumenlingdao.getId())
            .andNew()
            .eq("username", bumenlingdao.getUsername())
            .or()
            .eq("bumenlingdao_phone", bumenlingdao.getBumenlingdaoPhone())
            .or()
            .eq("bumenlingdao_id_number", bumenlingdao.getBumenlingdaoIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        BumenlingdaoEntity bumenlingdaoEntity = bumenlingdaoService.selectOne(queryWrapper);
        if("".equals(bumenlingdao.getBumenlingdaoPhoto()) || "null".equals(bumenlingdao.getBumenlingdaoPhoto())){
                bumenlingdao.setBumenlingdaoPhoto(null);
        }
        if(bumenlingdaoEntity==null){
            bumenlingdaoService.updateById(bumenlingdao);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"账户或者部门领导手机号或者部门领导身份证号已经被使用");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        bumenlingdaoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<BumenlingdaoEntity> bumenlingdaoList = new ArrayList<>();//上传的东西
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
                            BumenlingdaoEntity bumenlingdaoEntity = new BumenlingdaoEntity();
//                            bumenlingdaoEntity.setUsername(data.get(0));                    //账户 要改的
//                            //bumenlingdaoEntity.setPassword("123456");//密码
//                            bumenlingdaoEntity.setBumenlingdaoName(data.get(0));                    //部门领导姓名 要改的
//                            bumenlingdaoEntity.setBumenlingdaoPhone(data.get(0));                    //部门领导手机号 要改的
//                            bumenlingdaoEntity.setBumenlingdaoIdNumber(data.get(0));                    //部门领导身份证号 要改的
//                            bumenlingdaoEntity.setBumenlingdaoPhoto("");//照片
//                            bumenlingdaoEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            bumenlingdaoEntity.setBumenTypes(Integer.valueOf(data.get(0)));   //部门 要改的
//                            bumenlingdaoEntity.setBumenlingdaoEmail(data.get(0));                    //电子邮箱 要改的
//                            bumenlingdaoEntity.setJiguan(data.get(0));                    //籍贯 要改的
//                            bumenlingdaoEntity.setBumenlingdaoZhuzhi(data.get(0));                    //家庭住址 要改的
//                            bumenlingdaoEntity.setRuzhiTime(new Date(data.get(0)));          //入职时间 要改的
//                            bumenlingdaoEntity.setInsertTime(date);//时间
//                            bumenlingdaoEntity.setCreateTime(date);//时间
                            bumenlingdaoList.add(bumenlingdaoEntity);


                            //把要查询是否重复的字段放入map中
                                //账户
                                if(seachFields.containsKey("username")){
                                    List<String> username = seachFields.get("username");
                                    username.add(data.get(0));//要改的
                                }else{
                                    List<String> username = new ArrayList<>();
                                    username.add(data.get(0));//要改的
                                    seachFields.put("username",username);
                                }
                                //部门领导手机号
                                if(seachFields.containsKey("bumenlingdaoPhone")){
                                    List<String> bumenlingdaoPhone = seachFields.get("bumenlingdaoPhone");
                                    bumenlingdaoPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> bumenlingdaoPhone = new ArrayList<>();
                                    bumenlingdaoPhone.add(data.get(0));//要改的
                                    seachFields.put("bumenlingdaoPhone",bumenlingdaoPhone);
                                }
                                //部门领导身份证号
                                if(seachFields.containsKey("bumenlingdaoIdNumber")){
                                    List<String> bumenlingdaoIdNumber = seachFields.get("bumenlingdaoIdNumber");
                                    bumenlingdaoIdNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> bumenlingdaoIdNumber = new ArrayList<>();
                                    bumenlingdaoIdNumber.add(data.get(0));//要改的
                                    seachFields.put("bumenlingdaoIdNumber",bumenlingdaoIdNumber);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<BumenlingdaoEntity> bumenlingdaoEntities_username = bumenlingdaoService.selectList(new EntityWrapper<BumenlingdaoEntity>().in("username", seachFields.get("username")));
                        if(bumenlingdaoEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(BumenlingdaoEntity s:bumenlingdaoEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //部门领导手机号
                        List<BumenlingdaoEntity> bumenlingdaoEntities_bumenlingdaoPhone = bumenlingdaoService.selectList(new EntityWrapper<BumenlingdaoEntity>().in("bumenlingdao_phone", seachFields.get("bumenlingdaoPhone")));
                        if(bumenlingdaoEntities_bumenlingdaoPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(BumenlingdaoEntity s:bumenlingdaoEntities_bumenlingdaoPhone){
                                repeatFields.add(s.getBumenlingdaoPhone());
                            }
                            return R.error(511,"数据库的该表中的 [部门领导手机号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //部门领导身份证号
                        List<BumenlingdaoEntity> bumenlingdaoEntities_bumenlingdaoIdNumber = bumenlingdaoService.selectList(new EntityWrapper<BumenlingdaoEntity>().in("bumenlingdao_id_number", seachFields.get("bumenlingdaoIdNumber")));
                        if(bumenlingdaoEntities_bumenlingdaoIdNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(BumenlingdaoEntity s:bumenlingdaoEntities_bumenlingdaoIdNumber){
                                repeatFields.add(s.getBumenlingdaoIdNumber());
                            }
                            return R.error(511,"数据库的该表中的 [部门领导身份证号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        bumenlingdaoService.insertBatch(bumenlingdaoList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }


    /**
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        BumenlingdaoEntity bumenlingdao = bumenlingdaoService.selectOne(new EntityWrapper<BumenlingdaoEntity>().eq("username", username));
        if(bumenlingdao==null || !bumenlingdao.getPassword().equals(password))
            return R.error("账号或密码不正确");
        //  // 获取监听器中的字典表
        // ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        // Map<String, Map<Integer, String>> dictionaryMap= (Map<String, Map<Integer, String>>) servletContext.getAttribute("dictionaryMap");
        // Map<Integer, String> role_types = dictionaryMap.get("role_types");
        // role_types.get(.getRoleTypes());
        String token = tokenService.generateToken(bumenlingdao.getId(),username, "bumenlingdao", "部门领导");
        R r = R.ok();
        r.put("token", token);
        r.put("role","部门领导");
        r.put("username",bumenlingdao.getBumenlingdaoName());
        r.put("tableName","bumenlingdao");
        r.put("userId",bumenlingdao.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody BumenlingdaoEntity bumenlingdao){
//    	ValidatorUtils.validateEntity(user);
        Wrapper<BumenlingdaoEntity> queryWrapper = new EntityWrapper<BumenlingdaoEntity>()
            .eq("username", bumenlingdao.getUsername())
            .or()
            .eq("bumenlingdao_phone", bumenlingdao.getBumenlingdaoPhone())
            .or()
            .eq("bumenlingdao_id_number", bumenlingdao.getBumenlingdaoIdNumber())
            ;
        BumenlingdaoEntity bumenlingdaoEntity = bumenlingdaoService.selectOne(queryWrapper);
        if(bumenlingdaoEntity != null)
            return R.error("账户或者部门领导手机号或者部门领导身份证号已经被使用");
        bumenlingdao.setInsertTime(new Date());
        bumenlingdao.setCreateTime(new Date());
        bumenlingdaoService.insert(bumenlingdao);
        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id){
        BumenlingdaoEntity bumenlingdao = new BumenlingdaoEntity();
        bumenlingdao.setPassword("123456");
        bumenlingdao.setId(id);
        bumenlingdao.setInsertTime(new Date());
        bumenlingdaoService.updateById(bumenlingdao);
        return R.ok();
    }


    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        BumenlingdaoEntity bumenlingdao = bumenlingdaoService.selectOne(new EntityWrapper<BumenlingdaoEntity>().eq("username", username));
        if(bumenlingdao!=null){
            bumenlingdao.setPassword("123456");
            boolean b = bumenlingdaoService.updateById(bumenlingdao);
            if(!b){
               return R.error();
            }
        }else{
           return R.error("账号不存在");
        }
        return R.ok();
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrBumenlingdao(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        BumenlingdaoEntity bumenlingdao = bumenlingdaoService.selectById(id);
        if(bumenlingdao !=null){
            //entity转view
            BumenlingdaoView view = new BumenlingdaoView();
            BeanUtils.copyProperties( bumenlingdao , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
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
        PageUtils page = bumenlingdaoService.queryPage(params);

        //字典表数据转换
        List<BumenlingdaoView> list =(List<BumenlingdaoView>)page.getList();
        for(BumenlingdaoView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        BumenlingdaoEntity bumenlingdao = bumenlingdaoService.selectById(id);
            if(bumenlingdao !=null){


                //entity转view
                BumenlingdaoView view = new BumenlingdaoView();
                BeanUtils.copyProperties( bumenlingdao , view );//把实体数据重构到view中

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
    public R add(@RequestBody BumenlingdaoEntity bumenlingdao, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,bumenlingdao:{}",this.getClass().getName(),bumenlingdao.toString());
        Wrapper<BumenlingdaoEntity> queryWrapper = new EntityWrapper<BumenlingdaoEntity>()
            .eq("username", bumenlingdao.getUsername())
            .or()
            .eq("bumenlingdao_phone", bumenlingdao.getBumenlingdaoPhone())
            .or()
            .eq("bumenlingdao_id_number", bumenlingdao.getBumenlingdaoIdNumber())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        BumenlingdaoEntity bumenlingdaoEntity = bumenlingdaoService.selectOne(queryWrapper);
        if(bumenlingdaoEntity==null){
            bumenlingdao.setInsertTime(new Date());
            bumenlingdao.setCreateTime(new Date());
        bumenlingdao.setPassword("123456");
        bumenlingdaoService.insert(bumenlingdao);
            return R.ok();
        }else {
            return R.error(511,"账户或者部门领导手机号或者部门领导身份证号已经被使用");
        }
    }


}
