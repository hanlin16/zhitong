package com.etai.yto.service.impl.syscode;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.etai.yto.api.syscode.EightCodeService;
import com.etai.yto.manager.syscode.EightCodeManager;
import com.etai.yto.model.syscode.EightCode;

@RestController
public class EightCodeServiceImpl implements EightCodeService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private EightCodeManager eightCodeManager;
	
	/**
	 * 保存随机码
	 */
	@Override
	public void insertEightCode(@RequestBody EightCode eightCode) {
		try {
			eightCodeManager.insertEightCode(eightCode);
		} catch (Exception e) {
			logger.error("保存8位随机码：",e);
		}
	}
	/**
	 * 获取一个未使用的随机码
	 */
	@Override
	public EightCode queryEightCode() {
		try {
			return eightCodeManager.queryEightCode();
		} catch (Exception e) {
			logger.error("获取8位随机码：",e);
			return null;
		}
	}

	/**
	 * 更新随机码状态
	 */
	@Override
	public void UpdateEightCode(@RequestBody EightCode eightCode) {
		try {
			eightCodeManager.UpdateEightCode(eightCode);
		} catch (Exception e) {
			logger.error("更新8位随机码：",e);
		}
	}
	
	@Override
	public void generateEightCode(){
		//启用多线程生成8位编码
		long startTime = System.currentTimeMillis();
		CountDownLatch count = new CountDownLatch(100);
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(80, 110, 10000, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(5));
		logger.error("生成8位随机码开始   。。。");
		final Pattern numPattern = Pattern.compile("^[-\\+]?[\\d]*$");//全数字
		final Pattern engPattern = Pattern.compile("^[-\\+]?[A-Z]*$"); //全字母
		final String dateStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		for (int i = 0; i < 100; i++) {
			threadPoolExecutor.execute(new Runnable() {
				@Override
				public void run() {
					try {
						for (int i = 0; i < 250; i++) {
							String uuid = UUID.randomUUID().toString().replace("-", "").toUpperCase();
							for (int j = 0; j < 4; j++) {
								String code = uuid.substring(0+j*8, j*8+8);
								//去掉不和要求的编码
								if(numPattern.matcher(code).matches()) {
									continue;
								}
								if(engPattern.matcher(code).matches()) {
									continue;
								}
								EightCode eightCodeTemp = new EightCode();
								eightCodeTemp.setCode(code);
								eightCodeTemp.setStatus("0");
								eightCodeTemp.setBatchNo("20181");
								eightCodeTemp.setCreateTime(dateStr);
								eightCodeTemp.setCreateUser("system");
								try {
									eightCodeManager.insertEightCode(eightCodeTemp);
								} catch (DuplicateKeyException e) {
									logger.error("生成编码重复： "+eightCodeTemp.getCode(), e);
								}
							}
						}
					}finally{
						count.countDown();
					}
				}
			});
		}
		threadPoolExecutor.shutdown();
		try {
			count.await();
			logger.error("编码生成完毕！");
			long endTime = System.currentTimeMillis();
			logger.error("耗时："+(endTime-startTime)/1000);
		} catch (InterruptedException e) {
			logger.error("编码生成完毕！但是发生错误 ", e);
		}
	}

}
