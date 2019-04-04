package practicegeeks;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class QueryDecoding {
	
	static Map<String, String> decodeQueryParameters(String fullQuery) throws UnsupportedEncodingException {
		Map<String, String> paramMap = new HashMap<String, String>();
		String query = fullQuery.split("where")[1].trim();
		System.out.println(query);
	    String[] pairs = query.split("and");
	    int idx = 0;
	    for (String pair : pairs) {
	        idx = pair.indexOf("=");
	        paramMap.put(pair.substring(0, idx).trim(), pair.substring(idx + 1).trim());
	    }
		return paramMap;
	}
	
	public static void main(String[] args) throws UnsupportedEncodingException { 
		String fullQuery = "select count(*) from ops_perf.repl_user_security where user_dsid = 123 and user_name = \"test\"";
		Map<String, String> paramMap = decodeQueryParameters(fullQuery);
		for (Map.Entry<String,String> entry : paramMap.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
		}
	}
}
