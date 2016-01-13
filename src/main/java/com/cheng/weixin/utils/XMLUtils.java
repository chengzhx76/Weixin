package com.cheng.weixin.utils;

import java.io.Writer;

import com.cheng.weixin.enums.Event;
import com.cheng.weixin.enums.MsgType;
import com.cheng.weixin.model.TextMessage;
import com.cheng.weixin.model.VoiceMessage;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
/**
 * XML工具类
 * @author Cheng
 *
 */
public class XMLUtils {
	/**
	 * 将文本消息转换成XML
	 * @param textMessage
	 * @return
	 */
	public static String textMsg2XML(TextMessage textMsg) {
		xstream.alias("xml", textMsg.getClass());
		return xstream.toXML(textMsg);
	}
	
	public static String voiceMsg2XML(VoiceMessage voiceMsg) {
		xstream.alias("xml", voiceMsg.getClass());
		return xstream.toXML(voiceMsg);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// 扩展xstream，使其支持CDATA块 
	private static XStream xstream = new XStream(new XppDriver() {
		@Override
		public HierarchicalStreamWriter createWriter(Writer out) {
			return new PrettyPrintWriter(out) {
				
				boolean cdata;
				
				@SuppressWarnings("rawtypes")
				@Override
				public void startNode(String name, Class clazz) {
					super.startNode(name, clazz);
					cdata = false;
					if(clazz.equals(String.class)||clazz.equals(Event.class)||clazz.equals(MsgType.class)) {
						cdata=true;
					}
					
				}

				@Override
				protected void writeText(QuickWriter writer, String text) {
					if(cdata) {
						writer.write("<![CDATA[");
						writer.write(text);
						writer.write("]]>");
					}else {
						writer.write(text);
					}
				};
				
			};
		}
	});
	
	
	
}