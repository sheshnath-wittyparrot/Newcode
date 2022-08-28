package com.in28minutes.springboot.learnspringboot;

public class Course {
private long id;
private long name;
private long auther;



public Course(long id, long name, long auther) {
	super();
	this.id = id;
	this.name = name;
	this.auther = auther;
}



public Course(int id2, String string, String string2) {
	// TODO Auto-generated constructor stub
}



public long getId() {
	return id;
}



public long getName() {
	return name;
}



public long getAuther() {
	return auther;
}



@Override
public String toString() {
	return "Course [id=" + id + ", name=" + name + ", auther=" + auther + "]";
}
}
//constructor
//getter

