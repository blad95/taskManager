package com.bladimirhernandez.taskManager;
import java.util.Scanner;
//import java.Hashtable;


public class taskObject {
	String description;
	boolean complete;
	int listNum;
	
	//constructor
	public taskObject() {
		description = "";
		complete = false;
		listNum = 0;
	}
	//overloaded constructor;
	public taskObject(String task, boolean bool, int num) {
		description = task;
		complete = bool;
		listNum = num;
	}
	//get the task method;
	public String getTask() {
		return description;
	}
	//set the task method
	public void setTask(String newTask) {
		description = newTask;
	}
	//update status i.e change boolean to true or false;
	public boolean getBool() {
		return complete;
	}
	public void setBool(boolean bool) {
		complete = bool;
	}
	
	//get the list number
	public int getListNumber() {
		return listNum;
	}
	//set the list number
	public void setListNumber(int num) {
		listNum = num;
	}
}
