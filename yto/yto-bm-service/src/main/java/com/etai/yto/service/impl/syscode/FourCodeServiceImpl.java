package com.etai.yto.service.impl.syscode;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.etai.yto.api.syscode.FourCodeService;
import com.etai.yto.manager.syscode.FourCodeManager;
import com.etai.yto.model.syscode.FourCode;
import com.etai.yto.page.RemoteResult;

@RestController
public class FourCodeServiceImpl implements FourCodeService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private FourCodeManager fourCodeManager;
	
	/**
	 * 保存随机码
	 */
	@Override
	public void insertFourCode(@RequestBody FourCode fourCode) {
		try {
			fourCodeManager.insertFourCode(fourCode);
		} catch (Exception e) {
			logger.error("保存8位随机码：",e);
		}
	}
	/**
	 * 获取一个未使用的随机码
	 */
	@Override
	public RemoteResult<FourCode> queryFourCode() {
		RemoteResult<FourCode> result = new RemoteResult<>();
		try {
			FourCode fourCode = fourCodeManager.queryFourCode();
			result.setData(fourCode);
			result.setSuccess(true);
			return result;
		} catch (Exception e) {
			logger.error("获取4位随机码报错：",e);
			result.setSuccess(false);
			result.setErrorMsg("获取4位随机码报错");
			return result;
		}
	}

	/**
	 * 更新随机码状态
	 */
	@Override
	public void UpdateFourCode(@RequestBody FourCode fourCode) {
		try {
			fourCodeManager.updateFourCode(fourCode);
		} catch (Exception e) {
			logger.error("更新8位随机码：",e);
		}
	}
	@Override
	public void generateFourCode(){
		//启用多线程生成8位编码
		long startTime = System.currentTimeMillis();
		CountDownLatch count = new CountDownLatch(100);
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 12, 10000, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(5));
		logger.error("生成4位随机码开始   。。。");
		final String dateStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		final Random random = new Random();
		for (int i = 0; i < 10; i++) {
			threadPoolExecutor.execute(new Runnable() {
				@Override
				public void run() {
					try {
						for (int i = 0; i < 200; i++) {
							int intNext = random.nextInt(9000)+1000;
							String code = String.valueOf(intNext);
							if(code.contains("4")) {
								continue;
							}
							FourCode fourCodeTemp = new FourCode();
							fourCodeTemp.setCode(String.valueOf(code));
							fourCodeTemp.setStatus("0");
							fourCodeTemp.setBatchNo("20181");
							fourCodeTemp.setCreateTime(dateStr);
							fourCodeTemp.setCreateUser("system");
							try {
								fourCodeManager.insertFourCode(fourCodeTemp);
							} catch (DuplicateKeyException e) {
								logger.error("生成编码重复： "+fourCodeTemp.getCode(), e);
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
