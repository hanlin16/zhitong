package com.etai.okd.controller.device;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.etai.okd.api.service.FeignCityMappingService;
import com.etai.okd.api.service.FeignDeviceApplyService;
import com.etai.okd.api.service.FeignSYSCodeService;
import com.etai.okd.api.service.FeignSaleActionService;
import com.etai.yto.model.city.CityMappingModel;
import com.etai.yto.model.device.DeviceApply;
import com.etai.yto.model.saleaction.SaleAction;
import com.etai.yto.model.syscode.EightCode;
import com.etai.yto.page.PageResult;
import com.etai.yto.page.RemoteResult;
import com.etai.yto.page.city.CityMappingPage;
/**
 * 设备处理类
 * @author king
 *
 */
@Controller
@RequestMapping(value="/device")
public class DeviceController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private FeignCityMappingService cityServie;
	@Autowired
	private FeignDeviceApplyService deviceApplyService;
	@Autowired
	private FeignSYSCodeService sYSCodeService;
	@Autowired
	private FeignSaleActionService saleActionService;
	
	@RequestMapping(value="/deviceApply")
	public ModelAndView deviceApplyPage(HttpServletRequest request) {
		logger.error("跳转设备申领页面请求参数:"+request.getParameter("channelCode")
		+";"+request.getParameter("actionCode"));
		
		ModelAndView mov = new ModelAndView();
		mov.setViewName("/device/deviceApply");
		HashMap<String,Object> map = new HashMap<>();
		//判断活动码是否存在和过期
		String actionCode = request.getParameter("actionCode");
		String channelCode = request.getParameter("channelCode");
		if(StringUtils.isEmpty(actionCode) || StringUtils.isEmpty(channelCode)){
			map.put("msg", "活动码或渠道编码不能为空");
		}
		RemoteResult<SaleAction> result = saleActionService.getSaleActionByCode(actionCode);
		if(result.getData()==null){
			
			map.put("msg", "活动码不存在");
		}else {
			String endTime = result.getData().getEndTime();
			String startTime = result.getData().getStartTime();
			System.out.println("startTime:"+startTime+";endTime:"+endTime);
			Date date = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Date startDate = null;
			Date endDate = null;
			try {
				startDate = dateFormat.parse(startTime);
				endDate = dateFormat.parse(endTime);
			} catch (ParseException e) {
				logger.error("查询活动有效期日期转换异常",e);
			}
			
			System.out.println("startDate:"+startDate.getTime()+";endDate:"+endDate.getTime()+";now:"+date.getTime());
			if(date.getTime()<startDate.getTime() || date.getTime()>endDate.getTime()){
				map.put("msg", "活动码已过期");
			}else {
				
				EightCode eightCode = sYSCodeService.queryEightCode();
				String bizNo = eightCode.getCode();
				map.put("applyType", "B");
				map.put("bizNo", bizNo);
				map.put("actionCode", request.getParameter("actionCode"));
				map.put("channelCode", request.getParameter("channelCode"));
				map.put("msg", "success");
			}
		}
		
		
		mov.addAllObjects(map);
		return mov;
		
	}
	@RequestMapping(value="/deviceApplyUpdate")
	public String applyDevice(DeviceApply deviceApply){
		logger.error("设备申领请求参数:"+deviceApply);
		deviceApply.setBizNo(UUID.randomUUID().toString().substring(28).toUpperCase());
		RemoteResult<DeviceApply> remoteResult = deviceApplyService.queryDeviceApplyInfoByBizNo(deviceApply.getBizNo());
		if(!remoteResult.isSuccess()){
			deviceApply.setLinkStatus("1");
			deviceApply.setPayStatus("1");
			deviceApplyService.deviceApplyAdd(deviceApply);
		}
		
		return "redirect:/pay/payPage?orderNo="+deviceApply.getBizNo();
		
		
	}
	/**
	 * 城市地区数据
	 * @param page
	 * @return
	 */
	@RequestMapping(value="/queryCityMapping")
	@ResponseBody
	public String queryAreaCityPage(CityMappingPage page){
//		public List<CityMappingModel> queryAreaCityPage(CityMappingPage page){
		
//		System.out.println("查询城市参数1:"+page);
		RemoteResult<PageResult<CityMappingModel>> queryAreaCityPage = cityServie.queryAreaCityPage(page);
//		System.out.println("查询城市参数2:"+queryAreaCityPage);
		PageResult<CityMappingModel> result = queryAreaCityPage.getData();
//		System.out.println("查询城市:"+result.getDataList());
		
		JSONArray proArray = new JSONArray();
		// 省级map，存放省的id和省JSONObject
		Map<Integer, JSONObject> proMap = new HashMap<Integer, JSONObject>();
		// 市级map，存放省的id和省下所有市的集合JSONArray
		Map<Integer, JSONArray> cityMap = new HashMap<Integer, JSONArray>();
		// 市级map，存放市的id和市JSONObject
		Map<Integer, JSONObject> cityObjMap = new HashMap<Integer, JSONObject>();
		// 县级map，存放市的id和市下所有县的集合JSONArray
		Map<Integer, JSONArray> countryMap = new HashMap<Integer, JSONArray>();

		for (CityMappingModel areaConfig : result.getDataList())
		{
			int id = areaConfig.getId();
			String areaName = areaConfig.getAreaName();
			int parentId = areaConfig.getAreaParentId();
			// 省级
			if (areaConfig.getAreaLevel().equals("2"))
			{
				JSONObject pro_obj = new JSONObject();
				pro_obj.put("id", id);
				pro_obj.put("name", areaName);
				proMap.put(id, pro_obj);
				proArray.add(pro_obj);
			}
			// 市级
			else if (areaConfig.getAreaLevel().equals("3"))
			{
				JSONObject city_obj = new JSONObject();
				city_obj.put("id", id);
				city_obj.put("name", areaName);
				cityObjMap.put(id, city_obj);
				JSONArray cityArray = null;
				if (!cityMap.containsKey(parentId))
				{
					cityArray = new JSONArray();
				}
				else
				{
					cityArray = cityMap.get(parentId);
				}
				cityArray.add(city_obj);
				// 更新省下市的集合
				cityMap.put(parentId, cityArray);
				// 更新省JSONObject的child
				((JSONObject) proMap.get(parentId)).put("child", cityArray);
			}
			// 县级
			else if (areaConfig.getAreaLevel().equals("4"))
			{
				JSONObject country_obj = new JSONObject();
				country_obj.put("id", id);
				country_obj.put("name", areaName);
				JSONArray countryArray = null;
				if (!countryMap.containsKey(parentId))
				{
					countryArray = new JSONArray();
				}
				else
				{
					countryArray = countryMap.get(parentId);
				}
				countryArray.add(country_obj);
				// 更新市下县的集合
				countryMap.put(parentId, countryArray);
				// 更新市JSONObject的child
				((JSONObject) cityObjMap.get(parentId)).put("child", countryArray);
			}
		}
		return proArray.toString();
		
//		return result.getDataList();
		
	}
	
}
