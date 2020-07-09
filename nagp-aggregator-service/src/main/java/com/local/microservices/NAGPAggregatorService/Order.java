package com.local.microservices.NAGPAggregatorService;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Order {

	private long orderId;
	@JsonIgnore
	private String orderName;
	private Long cost;
	private Date orderDate;
	
	public Order() {
	}

	
	public Order(long orderId, Long cost, Date orderDate) {
		super();
		this.orderId = orderId;
		this.cost = cost;
		this.orderDate = orderDate;
	}




	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}


	public Long getCost() {
		return cost;
	}


	public void setCost(Long cost) {
		this.cost = cost;
	}

}
