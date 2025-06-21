package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.AnlileixingEntity;
import com.entity.view.AnlileixingView;

import com.service.AnlileixingService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 案例类型
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-02 08:50:29
 */
@RestController
@RequestMapping("/anlileixing")
public class AnlileixingController {
    @Autowired
    private AnlileixingService anlileixingService;




    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,AnlileixingEntity anlileixing,
		HttpServletRequest request){
        EntityWrapper<AnlileixingEntity> ew = new EntityWrapper<AnlileixingEntity>();

		PageUtils page = anlileixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, anlileixing), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,AnlileixingEntity anlileixing, 
		HttpServletRequest request){
        EntityWrapper<AnlileixingEntity> ew = new EntityWrapper<AnlileixingEntity>();

		PageUtils page = anlileixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, anlileixing), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( AnlileixingEntity anlileixing){
       	EntityWrapper<AnlileixingEntity> ew = new EntityWrapper<AnlileixingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( anlileixing, "anlileixing")); 
        return R.ok().put("data", anlileixingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(AnlileixingEntity anlileixing){
        EntityWrapper< AnlileixingEntity> ew = new EntityWrapper< AnlileixingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( anlileixing, "anlileixing")); 
		AnlileixingView anlileixingView =  anlileixingService.selectView(ew);
		return R.ok("查询案例类型成功").put("data", anlileixingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        AnlileixingEntity anlileixing = anlileixingService.selectById(id);
        return R.ok().put("data", anlileixing);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        AnlileixingEntity anlileixing = anlileixingService.selectById(id);
        return R.ok().put("data", anlileixing);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody AnlileixingEntity anlileixing, HttpServletRequest request){
        if(anlileixingService.selectCount(new EntityWrapper<AnlileixingEntity>().eq("anlileixing", anlileixing.getAnlileixing()))>0) {
            return R.error("案例类型已存在");
        }
    	//ValidatorUtils.validateEntity(anlileixing);
        anlileixingService.insert(anlileixing);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody AnlileixingEntity anlileixing, HttpServletRequest request){
        if(anlileixingService.selectCount(new EntityWrapper<AnlileixingEntity>().eq("anlileixing", anlileixing.getAnlileixing()))>0) {
            return R.error("案例类型已存在");
        }
    	//ValidatorUtils.validateEntity(anlileixing);
        anlileixingService.insert(anlileixing);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody AnlileixingEntity anlileixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(anlileixing);
        if(anlileixingService.selectCount(new EntityWrapper<AnlileixingEntity>().ne("id", anlileixing.getId()).eq("anlileixing", anlileixing.getAnlileixing()))>0) {
            return R.error("案例类型已存在");
        }
        anlileixingService.updateById(anlileixing);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        anlileixingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
