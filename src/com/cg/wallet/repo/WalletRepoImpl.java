package com.cg.wallet.repo;

import java.util.HashMap;
import java.util.Map;

import com.cg.wallet.beans.Customer;
import com.cg.wallet.exception.InvalidInputException;

public class WalletRepoImpl implements WalletRepo{

	private Map<String, Customer> data=new HashMap<>();
	
	
	public Map<String, Customer> getData() {
		return data;
	}
	public void setData(Map<String, Customer> data) {
		this.data = data;
	}

	Customer cust=new Customer();
	public WalletRepoImpl(Map<String, Customer> data) {
		super();
		this.data = data;
	}
	public WalletRepoImpl() {
		
	}
	@Override
	public boolean save(Customer customer) {
		
		String mobileNo=customer.getMobileNo();	
		if(data.get(mobileNo)==null)
		{
			data.put(mobileNo, customer);
			return true;
		}
		else
			return false;
	}

	@Override
	public Customer findOne(String mobileNo) {		
		
		 cust=data.get(mobileNo);
		 if(cust==null)
			 throw new InvalidInputException("Account not found!!");
		 else
			 return cust;
	}

}