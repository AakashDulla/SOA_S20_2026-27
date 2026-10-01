package com.klu.orderapplication;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
	@Id
	
	int oid;
	int uid;
	int rid;
	String items;
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getItems() {
		return items;
	}
	public void setItems(String items) {
		this.items = items;
	}
	@Override
	public String toString() {
		return "Order [oid=" + oid + ", uid=" + uid + ", rid=" + rid + ", items=" + items + "]";
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(int oid, int uid, int rid, String items) {
		super();
		this.oid = oid;
		this.uid = uid;
		this.rid = rid;
		this.items = items;
	}
	

}
