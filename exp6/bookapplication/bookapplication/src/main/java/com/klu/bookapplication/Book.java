package com.klu.bookapplication;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Book {
@Id
int bno;
String bname;
int bpages;
public int getBno() {
	return bno;
}
public void setBno(int bno) {
	this.bno = bno;
}
public String getBname() {
	return bname;
}
public void setBname(String bname) {
	this.bname = bname;
}
public int getBpages() {
	return bpages;
}
public void setBpages(int bpages) {
	this.bpages = bpages;
}
@Override
public String toString() {
	return "Book [bno=" + bno + ", bname=" + bname + ", bpages=" + bpages + "]";
}
public Book(int bno, String bname, int bpages) {
	super();
	this.bno = bno;
	this.bname = bname;
	this.bpages = bpages;
}


}
