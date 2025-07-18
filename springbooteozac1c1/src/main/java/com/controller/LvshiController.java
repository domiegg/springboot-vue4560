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

import com.entity.LvshiEntity;
import com.entity.view.LvshiView;

import com.service.LvshiService;
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
 * 律师
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-02 08:50:29
 */
@RestController
@RequestMapping("/lvshi")
public class LvshiController {
    @Autowired
    private LvshiService lvshiService;

    @Autowired
    private StoreupService storeupService;



    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		LvshiEntity u = lvshiService.selectOne(new EntityWrapper<LvshiEntity>().eq("lvshizhanghao", username));
		if(u==null || !u.getMima().equals(password)) {
			return R.error("账号或密码不正确");
		}
		
        if(!"是".equals(u.getSfsh())) return R.error("账号已锁定，请联系管理员审核。");
		String token = tokenService.generateToken(u.getId(), username,"lvshi",  "律师" );
		return R.ok().put("token", token);
	}


	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody LvshiEntity lvshi){
    	//ValidatorUtils.validateEntity(lvshi);
    	LvshiEntity u = lvshiService.selectOne(new EntityWrapper<LvshiEntity>().eq("lvshizhanghao", lvshi.getLvshizhanghao()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		lvshi.setId(uId);
        lvshiService.insert(lvshi);
        return R.ok();
    }

	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        LvshiEntity u = lvshiService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	LvshiEntity u = lvshiService.selectOne(new EntityWrapper<LvshiEntity>().eq("lvshizhanghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        u.setMima("123456");
        lvshiService.updateById(u);
        return R.ok("密码已重置为：123456");
    }



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,LvshiEntity lvshi,
		HttpServletRequest request){
        EntityWrapper<LvshiEntity> ew = new EntityWrapper<LvshiEntity>();

		PageUtils page = lvshiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, lvshi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,LvshiEntity lvshi, 
		HttpServletRequest request){
        EntityWrapper<LvshiEntity> ew = new EntityWrapper<LvshiEntity>();

		PageUtils page = lvshiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, lvshi), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( LvshiEntity lvshi){
       	EntityWrapper<LvshiEntity> ew = new EntityWrapper<LvshiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( lvshi, "lvshi")); 
        return R.ok().put("data", lvshiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(LvshiEntity lvshi){
        EntityWrapper< LvshiEntity> ew = new EntityWrapper< LvshiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( lvshi, "lvshi")); 
		LvshiView lvshiView =  lvshiService.selectView(ew);
		return R.ok("查询律师成功").put("data", lvshiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        LvshiEntity lvshi = lvshiService.selectById(id);
		lvshi.setClicknum(lvshi.getClicknum()+1);
		lvshi.setClicktime(new Date());
		lvshiService.updateById(lvshi);
        lvshi = lvshiService.selectView(new EntityWrapper<LvshiEntity>().eq("id", id));
        return R.ok().put("data", lvshi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        LvshiEntity lvshi = lvshiService.selectById(id);
		lvshi.setClicknum(lvshi.getClicknum()+1);
		lvshi.setClicktime(new Date());
		lvshiService.updateById(lvshi);
        lvshi = lvshiService.selectView(new EntityWrapper<LvshiEntity>().eq("id", id));
        return R.ok().put("data", lvshi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody LvshiEntity lvshi, HttpServletRequest request){
        if(lvshiService.selectCount(new EntityWrapper<LvshiEntity>().eq("lvshizhanghao", lvshi.getLvshizhanghao()))>0) {
            return R.error("律师账号已存在");
        }
    	lvshi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(lvshi);
    	LvshiEntity u = lvshiService.selectOne(new EntityWrapper<LvshiEntity>().eq("lvshizhanghao", lvshi.getLvshizhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		lvshi.setId(new Date().getTime());
        lvshiService.insert(lvshi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody LvshiEntity lvshi, HttpServletRequest request){
        if(lvshiService.selectCount(new EntityWrapper<LvshiEntity>().eq("lvshizhanghao", lvshi.getLvshizhanghao()))>0) {
            return R.error("律师账号已存在");
        }
    	lvshi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(lvshi);
    	LvshiEntity u = lvshiService.selectOne(new EntityWrapper<LvshiEntity>().eq("lvshizhanghao", lvshi.getLvshizhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		lvshi.setId(new Date().getTime());
        lvshiService.insert(lvshi);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody LvshiEntity lvshi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(lvshi);
        if(lvshiService.selectCount(new EntityWrapper<LvshiEntity>().ne("id", lvshi.getId()).eq("lvshizhanghao", lvshi.getLvshizhanghao()))>0) {
            return R.error("律师账号已存在");
        }
        lvshiService.updateById(lvshi);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<LvshiEntity> list = new ArrayList<LvshiEntity>();
        for(Long id : ids) {
            LvshiEntity lvshi = lvshiService.selectById(id);
            lvshi.setSfsh(sfsh);
            lvshi.setShhf(shhf);
            list.add(lvshi);
        }
        lvshiService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        lvshiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,LvshiEntity lvshi, HttpServletRequest request,String pre){
        EntityWrapper<LvshiEntity> ew = new EntityWrapper<LvshiEntity>();
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
		PageUtils page = lvshiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, lvshi), params), params));
        return R.ok().put("data", page);
    }






    /**
     * （按值统计）
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}")
    public R value(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        EntityWrapper<LvshiEntity> ew = new EntityWrapper<LvshiEntity>();
        List<Map<String, Object>> result = lvshiService.selectValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计(多)）
     */
    @RequestMapping("/valueMul/{xColumnName}")
    public R valueMul(@PathVariable("xColumnName") String xColumnName,@RequestParam String yColumnNameMul, HttpServletRequest request) {
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<LvshiEntity> ew = new EntityWrapper<LvshiEntity>();
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = lvshiService.selectValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }

    /**
     * （按值统计）时间统计类型
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}/{timeStatType}")
    public R valueDay(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        params.put("timeStatType", timeStatType);
        EntityWrapper<LvshiEntity> ew = new EntityWrapper<LvshiEntity>();
        List<Map<String, Object>> result = lvshiService.selectTimeStatValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计）时间统计类型(多)
     */
    @RequestMapping("/valueMul/{xColumnName}/{timeStatType}")
    public R valueMulDay(@PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,@RequestParam String yColumnNameMul,HttpServletRequest request) {
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("timeStatType", timeStatType);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<LvshiEntity> ew = new EntityWrapper<LvshiEntity>();
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = lvshiService.selectTimeStatValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }

    /**
     * 分组统计
     */
    @RequestMapping("/group/{columnName}")
    public R group(@PathVariable("columnName") String columnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("column", columnName);
        EntityWrapper<LvshiEntity> ew = new EntityWrapper<LvshiEntity>();
        List<Map<String, Object>> result = lvshiService.selectGroup(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }







}
