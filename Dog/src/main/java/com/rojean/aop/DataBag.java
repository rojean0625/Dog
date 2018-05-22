
package com.rojean.aop;

import java.math.BigDecimal;

public class DataBag {

	private String customerNo;
	private BigDecimal amt;
	public String getCustomerNo() {
		return customerNo;
	}
	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}
	public BigDecimal getAmt() {
		return amt;
	}
	public void setAmt(BigDecimal amt) {
		this.amt = amt;
	}
	
}
