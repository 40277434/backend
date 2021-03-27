package com.example.demo.controller;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.Result;
import com.example.demo.service.IDemoService;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class DemoController {

	@Autowired
	private IDemoService idemoService;
	
	@GetMapping(value = "/api")
	public String aip(@RequestParam String x, @RequestParam String y, @RequestParam String method){
		JSONObject jsonObject = new JSONObject();
		if (null == method || "".equals(method)){
			jsonObject.put("error", true);
			jsonObject.put("reason", "method is null");
			return jsonObject.toJSONString();
		}
		if ("add".equals(method)){
			return add(x,y);
		}else if ("minus".equals(method)){
			return minus(x,y);
		}else if ("product".equals(method)){
			return product(x,y);
		}else if ("divi".equals(method)){
			return divi(x, y);
		}else if ("power".equals(method)){
			return power(x,y);
		}else if ("modulu".equals(method)){
			return modulu(x,y);
		}else {
			jsonObject.put("error", true);
			jsonObject.put("reason", "method[add,minus,product,divi,power,modulu]");
			return jsonObject.toJSONString();
		}
	}
	

	@GetMapping(value = "/add")
	public String add(@RequestParam(value = "x") String x, @RequestParam(value = "y") String y) {
		
		try {
			JSONObject jsonObject = new JSONObject();
			if (isNumeric(x) && isNumeric(x)) {
				if (isInteger(x) && isInteger(y)) {

					int numX = Integer.parseInt(x);
					int numY = Integer.parseInt(y);
					jsonObject.put("error", false);
					jsonObject.put("string", x + "+" + y + "=" + (numX + numY));
					jsonObject.put("answer", numX + numY);
					idemoService.insertJOSN(jsonObject.toJSONString());
					return jsonObject.toJSONString();
				} else {

					jsonObject.put("error", true);
					jsonObject.put("reason", "Encountered non-integer value.");
					idemoService.insertJOSN(jsonObject.toJSONString());
					return jsonObject.toJSONString();
				}
			} else {

				jsonObject.put("error", true);
				jsonObject.put("reason", "Encountered non-numeric value.");
				idemoService.insertJOSN(jsonObject.toJSONString());
				return jsonObject.toJSONString();
			}
		} catch (Exception e) {

			JSONObject jsonObject = new JSONObject();
			jsonObject.put("answer", true);
			jsonObject.put("reason", e.getMessage());
			idemoService.insertJOSN(jsonObject.toJSONString());
			return jsonObject.toJSONString();
		}
	}
	
	
	@GetMapping(value = "/minus")
	public String minus(@RequestParam(value = "x") String x, @RequestParam(value = "y") String y) {
		try {
			JSONObject jsonObject = new JSONObject();
			if (isNumeric(x) && isNumeric(x)) {
				if (isInteger(x) && isInteger(y)) {
					
					int numX = Integer.parseInt(x);
					int numY = Integer.parseInt(y);
					jsonObject.put("error", false);
					jsonObject.put("string", x + "-" + y + "=" + (numX - numY));
					jsonObject.put("answer", numX - numY);
					idemoService.insertJOSN(jsonObject.toJSONString());
					return jsonObject.toJSONString();
				} else {
					
					jsonObject.put("error", true);
					jsonObject.put("reason", "Encountered non-integer value.");
					idemoService.insertJOSN(jsonObject.toJSONString());
					return jsonObject.toJSONString();
				}
			} else {
				
				jsonObject.put("error", true);
				jsonObject.put("reason", "Encountered non-numeric value.");
				idemoService.insertJOSN(jsonObject.toJSONString());
				return jsonObject.toJSONString();
			}
		} catch (Exception e) {
			
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("answer", true);
			jsonObject.put("reason", e.getMessage());
			idemoService.insertJOSN(jsonObject.toJSONString());
			return jsonObject.toJSONString();
		}
	}
	
	@GetMapping(value = "/product")
	public String product(@RequestParam(value = "x") String x, @RequestParam(value = "y") String y) {
		try {
			JSONObject jsonObject = new JSONObject();
			if (isNumeric(x) && isNumeric(x)) {
				if (isInteger(x) && isInteger(y)) {
					
					int numX = Integer.parseInt(x);
					int numY = Integer.parseInt(y);
					jsonObject.put("error", false);
					jsonObject.put("string", x + "x" + y + "=" + (numX * numY));
					jsonObject.put("answer", numX * numY);
					idemoService.insertJOSN(jsonObject.toJSONString());
					return jsonObject.toJSONString();
				} else {
					
					jsonObject.put("error", true);
					jsonObject.put("reason", "Encountered non-integer value.");
					idemoService.insertJOSN(jsonObject.toJSONString());
					return jsonObject.toJSONString();
				}
			} else {
				
				jsonObject.put("error", true);
				jsonObject.put("reason", "Encountered non-numeric value.");
				idemoService.insertJOSN(jsonObject.toJSONString());
				return jsonObject.toJSONString();
			}
		} catch (Exception e) {
			
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("error", true);
			jsonObject.put("reason", e.getMessage());
			idemoService.insertJOSN(jsonObject.toJSONString());
			return jsonObject.toJSONString();
		}
	}

	@GetMapping(value = "/divi")
	public String divi(@RequestParam(value = "x") String x, @RequestParam(value = "y") String y) {
		try {
			JSONObject jsonObject = new JSONObject();
			if (isNumeric(x) && isNumeric(x)) {
				if (isInteger(x) && isInteger(y)) {
					
					int numX = Integer.parseInt(x);
					int numY = Integer.parseInt(y);
					jsonObject.put("error", false);
					jsonObject.put("string", x + "/" + y + "=" + ((float)numX / numY));
					jsonObject.put("answer", (float)numX / numY);
					idemoService.insertJOSN(jsonObject.toJSONString());
					return jsonObject.toJSONString();
				} else {
					
					jsonObject.put("error", true);
					jsonObject.put("reason", "Encountered non-integer value.");
					idemoService.insertJOSN(jsonObject.toJSONString());
					return jsonObject.toJSONString();
				}
			} else {
				
				jsonObject.put("error", true);
				jsonObject.put("reason", "Encountered non-numeric value.");
				idemoService.insertJOSN(jsonObject.toJSONString());
				return jsonObject.toJSONString();
			}
		} catch (Exception e) {
			
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("error", true);
			jsonObject.put("reason", e.getMessage());
			idemoService.insertJOSN(jsonObject.toJSONString());
			return jsonObject.toJSONString();
		}
	}

	@GetMapping(value = "/")
	public String power(@RequestParam(value = "x") String x, @RequestParam(value = "y") String y) {
		try {
			JSONObject jsonObject = new JSONObject();
			if (isNumeric(x) && isNumeric(x)) {
				if (isInteger(x) && isInteger(y)) {
					
					int numX = Integer.parseInt(x);
					int numY = Integer.parseInt(y);
					jsonObject.put("error", false);
					jsonObject.put("string", x + "^" + y + "=" + Math.pow(numX,numY));
					jsonObject.put("answer", Math.pow(numX,numY));
					idemoService.insertJOSN(jsonObject.toJSONString());
					return jsonObject.toJSONString();
				} else {
					
					jsonObject.put("error", true);
					jsonObject.put("reason", "Encountered non-integer value.");
					idemoService.insertJOSN(jsonObject.toJSONString());
					return jsonObject.toJSONString();
				}
			} else {
				
				jsonObject.put("error", true);
				jsonObject.put("reason", "Encountered non-numeric value.");
				idemoService.insertJOSN(jsonObject.toJSONString());
				return jsonObject.toJSONString();
			}
		} catch (Exception e) {
			
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("answer", true);
			jsonObject.put("reason", e.getMessage());
			idemoService.insertJOSN(jsonObject.toJSONString());
			return jsonObject.toJSONString();
		}
	}

	@GetMapping(value = "/modulu")
	public String modulu(@RequestParam(value = "x") String x, @RequestParam(value = "y") String y) {
		try {
			JSONObject jsonObject = new JSONObject();
			if (isNumeric(x) && isNumeric(x)) {
				if (isInteger(x) && isInteger(y)) {
					
					int numX = Integer.parseInt(x);
					int numY = Integer.parseInt(y);
					jsonObject.put("error", false);
					jsonObject.put("string", x + "%" + y + "=" + (numX % numY));
					jsonObject.put("answer", (numX % numY));
					idemoService.insertJOSN(jsonObject.toJSONString());
					return jsonObject.toJSONString();
				} else {
					
					jsonObject.put("error", true);
					jsonObject.put("reason", "Encountered non-integer value.");
					idemoService.insertJOSN(jsonObject.toJSONString());
					return jsonObject.toJSONString();
				}
			} else {
				
				jsonObject.put("error", true);
				jsonObject.put("reason", "Encountered non-numeric value.");
				idemoService.insertJOSN(jsonObject.toJSONString());
				return jsonObject.toJSONString();
			}
		} catch (Exception e) {
			
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("error", true);
			jsonObject.put("reason", e.getMessage());
			idemoService.insertJOSN(jsonObject.toJSONString());
			return jsonObject.toJSONString();
		}
	}
	
	@GetMapping(value = "/list")
	public JSONObject list() {
		
		List<Result> list = idemoService.selectList();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("data", list);
		return jsonObject;
	}

	private boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher isNum = pattern.matcher(str);
		if (!isNum.matches()) {
			return false;
		}
		return true;
	}

	private boolean isInteger(String str) {
		Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
		return pattern.matcher(str).matches();
	}
}
