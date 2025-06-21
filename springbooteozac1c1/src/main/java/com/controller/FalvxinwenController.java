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

import com.entity.FalvxinwenEntity;
import com.entity.view.FalvxinwenView;

import com.service.FalvxinwenService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 法律新闻
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-02 08:50:30
 */
@RestController
@RequestMapping("/falvxinwen")
public class FalvxinwenController {
    @Autowired
    private FalvxinwenService falvxinwenService;

    @Autowired
    private StoreupService storeupService;



    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,FalvxinwenEntity falvxinwen,
		HttpServletRequest request){
        EntityWrapper<FalvxinwenEntity> ew = new EntityWrapper<FalvxinwenEntity>();

		PageUtils page = falvxinwenService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, falvxinwen), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,FalvxinwenEntity falvxinwen, 
		HttpServletRequest request){
        EntityWrapper<FalvxinwenEntity> ew = new EntityWrapper<FalvxinwenEntity>();

		PageUtils page = falvxinwenService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, falvxinwen), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( FalvxinwenEntity falvxinwen){
       	EntityWrapper<FalvxinwenEntity> ew = new EntityWrapper<FalvxinwenEntity>();
      	ew.allEq(MPUtil.allEQMapPre( falvxinwen, "falvxinwen")); 
        return R.ok().put("data", falvxinwenService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(FalvxinwenEntity falvxinwen){
        EntityWrapper< FalvxinwenEntity> ew = new EntityWrapper< FalvxinwenEntity>();
 		ew.allEq(MPUtil.allEQMapPre( falvxinwen, "falvxinwen")); 
		FalvxinwenView falvxinwenView =  falvxinwenService.selectView(ew);
		return R.ok("查询法律新闻成功").put("data", falvxinwenView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        FalvxinwenEntity falvxinwen = falvxinwenService.selectById(id);
		falvxinwen.setClicknum(falvxinwen.getClicknum()+1);
		falvxinwen.setClicktime(new Date());
		falvxinwenService.updateById(falvxinwen);
        falvxinwen = falvxinwenService.selectView(new EntityWrapper<FalvxinwenEntity>().eq("id", id));
        return R.ok().put("data", falvxinwen);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        FalvxinwenEntity falvxinwen = falvxinwenService.selectById(id);
		falvxinwen.setClicknum(falvxinwen.getClicknum()+1);
		falvxinwen.setClicktime(new Date());
		falvxinwenService.updateById(falvxinwen);
        falvxinwen = falvxinwenService.selectView(new EntityWrapper<FalvxinwenEntity>().eq("id", id));
        return R.ok().put("data", falvxinwen);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        FalvxinwenEntity falvxinwen = falvxinwenService.selectById(id);
        if(type.equals("1")) {
        	falvxinwen.setThumbsupnum(falvxinwen.getThumbsupnum()+1);
        } else {
        	falvxinwen.setCrazilynum(falvxinwen.getCrazilynum()+1);
        }
        falvxinwenService.updateById(falvxinwen);
        return R.ok("投票成功");
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody FalvxinwenEntity falvxinwen, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(falvxinwen);
        falvxinwenService.insert(falvxinwen);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @IgnoreAuth
    @RequestMapping("/add")
    public R add(@RequestBody FalvxinwenEntity falvxinwen, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(falvxinwen);
        falvxinwenService.insert(falvxinwen);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody FalvxinwenEntity falvxinwen, HttpServletRequest request){
        //ValidatorUtils.validateEntity(falvxinwen);
        falvxinwenService.updateById(falvxinwen);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        falvxinwenService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,FalvxinwenEntity falvxinwen, HttpServletRequest request,String pre){
        EntityWrapper<FalvxinwenEntity> ew = new EntityWrapper<FalvxinwenEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        params.put("order", "desc");
		PageUtils page = falvxinwenService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, falvxinwen), params), params));
        return R.ok().put("data", page);
    }










}
