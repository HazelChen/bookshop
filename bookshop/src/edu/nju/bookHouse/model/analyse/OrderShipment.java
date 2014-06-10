package edu.nju.bookHouse.model.analyse;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="orderShipment")
public class OrderShipment {
	private int orderId;
	private int distributeDay;
	private int sendDay;
	
	public OrderShipment(){}
	
	public OrderShipment(int orderId) {
		this.orderId = orderId;
	}

	@Id
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getDistributeDay() {
		return distributeDay;
	}

	public void setDistributeDay(int distributeDay) {
		this.distributeDay = distributeDay;
	}

	public int getSendDay() {
		return sendDay;
	}

	public void setSendDay(int sendDay) {
		this.sendDay = sendDay;
	}
	
	
	
	
}
