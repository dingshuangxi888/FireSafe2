package com.firesafe.ws;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Service;

import com.firesafe.consts.Constants;
import com.firesafe.util.http.HttpRequest;
import com.firesafe.util.http.HttpResponse;

@Service("offsetService")
public class OffsetService {
	static final Logger logger = Logger.getLogger(OffsetService.class);
	private String url = Constants.URL_NCWS + "offset";
	
	public double[] getOffset(float lat, float lng) {
		double[] result = {lat, lng};
		try {
			JSONObject offset = new JSONObject().put("lat", lat).put("lon", lng);
			Map<String, String> params = new HashMap<String, String>();
			params.put("offset", offset.toString());
			HttpResponse response = new HttpRequest().sendPost(url, params);
			String str = response.getContent();
			if (str != null && !str.isEmpty()) {
				JSONObject json = new JSONObject(str);
				result[0] += json.getDouble("lat");
				result[1] += json.getDouble("lon");
			}
		} catch (JSONException e) {
			logger.error(e.getMessage());
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
		return result;
	}
}
