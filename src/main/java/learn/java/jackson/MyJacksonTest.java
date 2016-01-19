/**
 * http://www.mkyong.com/java/jackson-2-convert-java-object-to-from-json/
 */
package learn.java.jackson;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MyJacksonTest {

	public static void main(String args[]) {
		String jsonString = "{\"logType\":\"tpipas\",\"logTime\":\"2016-01-19 16:55:28.149\",\"apID\":\"TPIPASApp04V3\",\"functionID\":\"FUNC_10005\",\"who\":\"機器人\",\"at\":\"postgres\",\"to\":\"edb\",\"action\":\"填寫個人資料\",\"systemID\":\"upcc\",\"keyword\":\"侏儸紀世界\",\"messageLevel\":\"INFO\",\"messageCode\":\"8385\",\"tableName\":\"CODES\",\"dataCount\":99,\"result\":\"取消\",\"message\":\"Invalid arguments\",\"from\":\"batch02\"}";
		ObjectMapper objectMapper = new ObjectMapper();
		ApLog apLog;
		try {
			apLog = objectMapper.readValue(jsonString, ApLog.class);
			String systemID = apLog.getSystemID();
			System.out.print(systemID);
			String logTime = apLog.getLogTime();
			System.out.print(logTime);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}