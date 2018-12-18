package com.etai.okd.api.util;

import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 该工具类用于对象与XML的转换
 * 
 */
public class JAXBUtils {
	protected final static Logger logger = LoggerFactory.getLogger(JAXBUtils.class);
	/**
	 * 将对象直接转换成String类型的 XML输出
	 * @param obj
	 * @return
	 */
	public static String convertObjectToXML(Object obj) {
		// 创建输出流
		StringWriter sw = new StringWriter();
		try {
			// 利用jdk中自带的转换类实现
			JAXBContext context = JAXBContext.newInstance(obj.getClass());
			Marshaller marshaller = context.createMarshaller();
			// 格式化xml输出的格式
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			// 将对象转换成输出流形式的xml
			marshaller.marshal(obj, sw);
		} catch (JAXBException e) {
			e.printStackTrace();
			logger.error("", e);
		}
		return sw.toString();
	}
	/**
	 * 将对象直接转换成String类型的 XML输出
	 * @param obj
	 * @return
	 * @throws JAXBException 
	 */
	public static String convertObjectToXMLForNa(Object obj) throws JAXBException {
		// 创建输出流
		StringWriter sw = new StringWriter();
		// 利用jdk中自带的转换类实现
		JAXBContext context = JAXBContext.newInstance(obj.getClass());
		Marshaller marshaller = context.createMarshaller();
		// 格式化xml输出的格式
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.setProperty(Marshaller.JAXB_ENCODING, "utf-8");
		// 将对象转换成输出流形式的xml
		marshaller.marshal(obj, sw);
		String xml = sw.toString();
		if(!StringUtils.isEmpty(xml)){
			xml = xml.toString().replace(" standalone=\"yes\"", "");
		}
		return xml;
	}
	/**
	 * 将对象直接转换成String类型的 XML片段
	 * @param obj
	 * @return
	 * @throws JAXBException 
	 */
	public static String objToFragmentXML(Object obj) throws JAXBException {
		// 创建输出流
		StringWriter sw = new StringWriter();
		// 利用jdk中自带的转换类实现
		JAXBContext context = JAXBContext.newInstance(obj.getClass());
		Marshaller marshaller = context.createMarshaller();
		// 格式化xml输出的格式
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
		// 将对象转换成输出流形式的xml
		marshaller.marshal(obj, sw);
		return sw.toString();
	}
	public static String convertObjectToXML(@SuppressWarnings("rawtypes") Class[] clazs,Object obj) {
		// 创建输出流
		StringWriter sw = new StringWriter();
		try {
			// 利用jdk中自带的转换类实现
			JAXBContext context = JAXBContext.newInstance(clazs);
			Marshaller marshaller = context.createMarshaller();
			// 格式化xml输出的格式
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			// 将对象转换成输出流形式的xml
			marshaller.marshal(obj, sw);
		} catch (JAXBException e) {
			e.printStackTrace();
			logger.error("", e);
		}
		return sw.toString();
	}
	
	/** 
     * 将String类型的xml转换成对象 
     */  
    @SuppressWarnings("unchecked")
	public static <T> T convertXMLToObject(Class<T> clazz, String xml) {  
        T xmlObject = null;
        try {  
            JAXBContext context = JAXBContext.newInstance(clazz);  
            // 进行将XML转成对象的核心接口  
            Unmarshaller unmarshaller = context.createUnmarshaller();  
            StringReader sr = new StringReader(xml);  
            xmlObject = (T)unmarshaller.unmarshal(sr);  
        } catch (JAXBException e) {
            e.printStackTrace();
            logger.error("", e);
        }  
        return xmlObject;  
    }
    /** 
     * 将String类型的xml转换成对象 
     * @throws JAXBException 
     */  
    @SuppressWarnings("unchecked")
	public static <T> T convertXMLToObjectForNa(Class<T> clazz, String xml) throws JAXBException {  
        T xmlObject = null;
        JAXBContext context = JAXBContext.newInstance(clazz);  
        // 进行将XML转成对象的核心接口  
        Unmarshaller unmarshaller = context.createUnmarshaller();  
        StringReader sr = new StringReader(xml);  
        xmlObject = (T)unmarshaller.unmarshal(sr);  
        return xmlObject;  
    }
    @SuppressWarnings("unchecked")
	public static <T> T convertXMLToObject(Class<?>[] clazzs, String xml) {  
        T xmlObject = null;
        try {  
            JAXBContext context = JAXBContext.newInstance(clazzs);  
            // 进行将XML转成对象的核心接口  
            Unmarshaller unmarshaller = context.createUnmarshaller();  
            StringReader sr = new StringReader(xml);  
            xmlObject = (T)unmarshaller.unmarshal(sr);  
        } catch (JAXBException e) {
            e.printStackTrace();
            logger.error("", e);
        }  
        return xmlObject;  
    }
    /**
     * 将对象直接转换成String类型的 XML输出且没有间隙
     * @param obj
     * @return
     */
    public static String objToxml(Object obj){
    	// 创建输出流
		StringWriter sw = new StringWriter();
		try {
			// 利用jdk中自带的转换类实现
			JAXBContext context = JAXBContext.newInstance(obj.getClass());
			Marshaller marshaller = context.createMarshaller();
			// 将对象转换成输出流形式的xml
			marshaller.marshal(obj, sw);
		} catch (JAXBException e) {
			e.printStackTrace();
			logger.error("", e);
		}
		return sw.toString();
    }
    
    public static Map<String, Object> convertToMap(Object obj)
            throws Exception {

    	SortedMap<String, Object> map = new TreeMap<String, Object>();
        Field[] fields = obj.getClass().getDeclaredFields();
        for (int i = 0, len = fields.length; i < len; i++) {
            String varName = fields[i].getName();
            boolean accessFlag = fields[i].isAccessible();
            fields[i].setAccessible(true);

            Object o = fields[i].get(obj);
            if (o != null)
                map.put(varName, o.toString());

            fields[i].setAccessible(accessFlag);
        }

        return map;
    }
}
