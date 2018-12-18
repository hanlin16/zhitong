package com.etai.okd.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@EnableAutoConfiguration
@RequestMapping(value="/views")
public class ViewController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 *我的设备
	 * @return
	 * 2018年7月30日
	 * String
	 */
	@RequestMapping(value="/myEquipment")
	public String myEquipmentPage() {
	    return "myEquipment/index";
	}
	@RequestMapping(value="/hasBind")
	public String hasBindPage() {
		return "myEquipment/hasBind";
	}
	@RequestMapping(value="/change")
	public String changePage() {
		return "myEquipment/change";
	}
	/**
	 * 
	 * @return
	 * 2018年7月30日
	 * String
	 */
	@RequestMapping(value="/wDeposit")
	public String wDepositPage() {
	    return "wDeposit/addBank";
	}
	@RequestMapping(value="/bankShow")
	public String bankShowPage() {
		return "wDeposit/bankShow";
	}
	@RequestMapping(value="/Wdeposit")
	public String WdepositPage() {
		return "wDeposit/Wdeposit";
	}
	/**
	 * 
	 * @return
	 * 2018年7月30日
	 * String
	 */
	@RequestMapping(value="/myProfit")
	public String myProfitPage() {
	    return "myProfit/index";
	}
	/**
	 * 
	 * @return
	 * 2018年7月30日
	 * String
	 */
	@RequestMapping(value="/drivingRecord")
	public String drivingRecordPage() {
	    return "drivingRecord/weekRecordInfo";
	}
	@RequestMapping(value="/recordList")
	public String recordListPage() {
		return "drivingRecord/recordList";
	}
	@RequestMapping(value="/trajectoryDetail")
	public String trajectoryDetailPage() {
		return "drivingRecord/trajectoryDetail";
	}
	@RequestMapping(value="/driveAdvice")
	public String driveAdvicePage() {
		return "drivingRecord/driveAdvice";
	}
	/**
	 * 
	 * @return
	 * 2018年7月30日
	 * String
	 */
	@RequestMapping(value="/drivingReport")
	public String drivingReportPage() {
	    return "drivingReport/drivingReport";
	}
	@RequestMapping(value="/moonthReport")
	public String moonthReportPage() {
		return "drivingReport/moonthReport";
	}
	@RequestMapping(value="/weekReport")
	public String weekReportPage() {
		return "drivingReport/weekReport";
	}
	/*http://127.0.0.1:8080/ubi-web/static/views/myEquipment/index.html

		http://127.0.0.1:8080/ubi-web/static/views/wDeposit/addBank.html

		http://127.0.0.1:8080/ubi-web/static/views/myProfit/index.html

		http://127.0.0.1:8080/ubi-web/static/views/drivingRecord/weekRecordInfo.html

		http://127.0.0.1:8080/ubi-web/static/views/drivingReport/drivingReport.html
*/}
