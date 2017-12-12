package com.mulesoft.training;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mule.api.annotations.param.InboundHeaders;
import org.mule.api.annotations.param.Payload;

public class MuleComponent {
	int count;
	
	public MuleComponent(){
		count=1;
	}

  public Map<String,String> processMap(Map<String,String> mp) {
    mp.put("executedBy", "processMap method");
    return mp;
  }

  public Map<String,String> processArray(List<String> lst) {
    Map<String, String> mp = new HashMap<String,String>();
    mp.put("message", lst.get(0));
    mp.put("executedBy", "processArray method");
    return mp;
  }

  public Map<String,String> processString(String str) {
	   Map<String, String> mp = new HashMap<String,String>();
	    mp.put("message", str);
	    mp.put("executedBy", "processArray method");
	    return mp;
  }

  public Map<String,String> processAll(@Payload Object obj,@InboundHeaders("http.method") String myHttpMethod) {
	   Map<String, String> mp = new HashMap<String,String>();
	    mp.put("message", obj.toString());
	    mp.put("executedBy", "processAll method");
	    mp.put("httpmethod", myHttpMethod);
	    mp.put("count", String.valueOf(count));
	    count++;
	    return mp;
  }

} 
