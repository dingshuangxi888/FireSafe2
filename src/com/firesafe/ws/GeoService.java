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

@Service("geoService")
public class GeoService {
	static final Logger logger = Logger.getLogger(GeoService.class);
	private final String url = Constants.URL_NCWS + "geo";
	
	public String getGeo(float lat, float lng) {
		String result = null;
		try {
			JSONObject geo = new JSONObject().put("lat", lat).put("lon", lng).put("language", "zh_CN");
			Map<String, String> params = new HashMap<String, String>();
			params.put("geo", geo.toString());
			HttpResponse response = new HttpRequest().sendPost(url, params);
			result = response.getContent();
		} catch (JSONException e) {
			logger.error(e.getMessage());
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
		return result;
	}
}
