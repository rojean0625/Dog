package com.rojean.aop;

import java.io.File;

import org.springframework.stereotype.Service;

@Service("doService")
public class DoService implements IDo {

	@Override
	public String openFire(DataBag bag) {
		System.out.println("save dubbo: " + bag.getCustomerNo());
		return "6 ²» 6";
	}

}
