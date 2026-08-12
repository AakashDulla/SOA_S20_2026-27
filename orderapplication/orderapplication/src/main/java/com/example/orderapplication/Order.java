package com.example.orderapplication;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	
	@Id
	int oid;
	int userid;
	int restid;
	String items;
	//Setter, getters, tostring(), constructors
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getRestid() {
		return restid;
	}
	public void setRestid(int restid) {
		this.restid = restid;
	}
	public String getItems() {
		return items;
	}
	public void setItems(String items) {
		this.items = items;
	}
	@Override
	public String toString() {
		return "Order [oid=" + oid + ", userid=" + userid + ", restid=" + restid + ", items=" + items + "]";
	}
	public Order(int oid, int userid, int restid, String items) {
		super();
		this.oid = oid;
		this.userid = userid;
		this.restid = restid;
		this.items = items;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
