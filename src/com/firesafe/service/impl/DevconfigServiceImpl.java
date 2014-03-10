package com.firesafe.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Service;

import com.firesafe.consts.Constants;
import com.firesafe.service.DevconfigService;
import com.firesafe.util.http.HttpRequest;
import com.firesafe.util.http.HttpResponse;
import com.firesafe.vo.ConfigVO;
import com.firesafe.vo.DevConfigsVO;
import com.google.gson.Gson;

@Service("devconfigService")
public class DevconfigServiceImpl implements DevconfigService {
	static final Logger logger = Logger.getLogger(DevconfigServiceImpl.class);
	private final String url_get_config = Constants.URL_NCWS + "dev/getConfig2";
	private final String url_set_config = Constants.URL_NCWS + "dev/setConfig2";

	@Override
	public DevConfigsVO getConfig(long deviceid) {
		DevConfigsVO result = null;
		JSONObject param;
		try {
			param = new JSONObject().put("session", "hwJPCFmgNRtyOED91iTwpteCY").put("deviceid", deviceid);
			logger.info("Request for getConfig2 " + param.toString());
			Map<String, String> params = new HashMap<String, String>();
			params.put("param", param.toString());
			
			HttpResponse response = new HttpRequest().sendPost(url_get_config, params);
			logger.info("Response from getConfig2 " + response.getContent());
			JSONObject json = new JSONObject(response.getContent());
			if ("OK".equalsIgnoreCase(json.getString("status"))) {
				Gson gson = new Gson();
				result = gson.fromJson(json.toString(), DevConfigsVO.class);
			}
		} catch (JSONException e) {
			logger.error(e.getMessage());
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
		return result;
	}

	@Override
	public DevConfigsVO setConfig(ConfigVO configVO) {
		DevConfigsVO result = null;
		try {
			Gson gson = new Gson();
			JSONObject param = new JSONObject(gson.toJson(configVO));
			param.put("session", "hwJPCFmgNRtyOED91iTwpteCY");
			Map<String, String> params = new HashMap<String, String>();
			params.put("param", param.toString());
			logger.info("Reuqest for setConfig2 " + param.toString());

			HttpResponse response = new HttpRequest().sendPost(url_set_config, params);
			logger.info("Response from setConfig2 " + response.getContent());
			JSONObject json = new JSONObject(response.getContent());
			if ("OK".equalsIgnoreCase(json.getString("status"))) {
				result = gson.fromJson(json.toString(), DevConfigsVO.class);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return result;
	}

}
