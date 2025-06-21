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

import com.entity.AnlikuEntity;
import com.entity.view.AnlikuView;

import com.service.AnlikuService;
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
 * 案例库
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-02 08:50:29
 */
@RestController
@RequestMapping("/anliku")
public class AnlikuController {
    @Autowired
    private AnlikuService anlikuService;

    @Autowired
    private StoreupService storeupService;



    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,AnlikuEntity anliku,
		HttpServletRequest request){
        EntityWrapper<AnlikuEntity> ew = new EntityWrapper<AnlikuEntity>();

		PageUtils page = anlikuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, anliku), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,AnlikuEntity anliku, 
		HttpServletRequest request){
        EntityWrapper<AnlikuEntity> ew = new EntityWrapper<AnlikuEntity>();

		PageUtils page = anlikuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, anliku), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( AnlikuEntity anliku){
       	EntityWrapper<AnlikuEntity> ew = new EntityWrapper<AnlikuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( anliku, "anliku")); 
        return R.ok().put("data", anlikuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(AnlikuEntity anliku){
        EntityWrapper< AnlikuEntity> ew = new EntityWrapper< AnlikuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( anliku, "anliku")); 
		AnlikuView anlikuView =  anlikuService.selectView(ew);
		return R.ok("查询案例库成功").put("data", anlikuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        AnlikuEntity anliku = anlikuService.selectById(id);
		anliku.setClicknum(anliku.getClicknum()+1);
		anliku.setClicktime(new Date());
		anlikuService.updateById(anliku);
        anliku = anlikuService.selectView(new EntityWrapper<AnlikuEntity>().eq("id", id));
        return R.ok().put("data", anliku);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        AnlikuEntity anliku = anlikuService.selectById(id);
		anliku.setClicknum(anliku.getClicknum()+1);
		anliku.setClicktime(new Date());
		anlikuService.updateById(anliku);
        anliku = anlikuService.selectView(new EntityWrapper<AnlikuEntity>().eq("id", id));
        return R.ok().put("data", anliku);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody AnlikuEntity anliku, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(anliku);
        anlikuService.insert(anliku);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody AnlikuEntity anliku, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(anliku);
        anlikuService.insert(anliku);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody AnlikuEntity anliku, HttpServletRequest request){
        //ValidatorUtils.validateEntity(anliku);
        anlikuService.updateById(anliku);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        anlikuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,AnlikuEntity anliku, HttpServletRequest request,String pre){
        EntityWrapper<AnlikuEntity> ew = new EntityWrapper<AnlikuEntity>();
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
		PageUtils page = anlikuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, anliku), params), params));
        return R.ok().put("data", page);
    }










}
