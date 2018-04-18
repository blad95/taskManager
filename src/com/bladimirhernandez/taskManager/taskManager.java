package com.bladimirhernandez.taskManager;
import java.util.Scanner;
//import java.Hashtable;

public class taskManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//create the tasks array with 10 elements
		taskObject[] tasks = new taskObject[10];
		int index = 0;
		
		mainMenu(tasks, index);
	}
	public static void mainMenu(taskObject tasks[],int index) {
		

		//main menu options
		System.out.println("1. Add a task");
		System.out.println("2. Remove a task");
		System.out.println("3. Mark a task complete");
		System.out.println("4. List tasks");
		System.out.println("\n");
		System.out.println("What would you like to do?");
		//declare a new scanner object
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		//read in user input and store it
		int userInput = input.nextInt();

		optionsResponse(userInput, tasks, index);	
	}

	public static void optionsResponse(int userInput, taskObject tasks[], int index) {
		
		//if add a task
		if(userInput == 1){
			taskObject newTaskObject = addTask();
			System.out.println(newTaskObject.getTask());
			//find where the next task should be placed
			//the next place that isn't null
			if( index == 0) {
				tasks[index] = newTaskObject;
			}
			else {
				tasks[index] = newTaskObject;				
			}
			index++;
			System.out.println( "\n"+"Task has been added!");
			
		}
		else if(userInput == 2){
			removeTask(tasks);
		}
		else if(userInput == 3) {
			markTaskComplete(tasks);
		}
		else if(userInput == 4) {
			listTasks(tasks);
		}
		else {
			System.out.println("Please Choose an Option between 1-4.");
			System.out.println("\n");
		}
		mainMenu(tasks, index);
	}
	
	//create the method addTask()
	public static taskObject addTask() {
		System.out.println("What task would you like to add?");
		//create a task object
		taskObject task = new taskObject();
		//declare a new scanner object
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		//read in user input and store it
		String userInput = input.nextLine();
		task.setTask(userInput);
		return task;
	}
	//create the removeTask method
	public static void removeTask(taskObject[] tasks) {
		listTasks(tasks);
		System.out.println("Which task do you want to remove?");
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		//read in user input and store it
		int remove = input.nextInt();
		remove = remove -1;
		while(tasks[remove+1] != null) {
			//add values to its variables
			tasks[remove].setTask(tasks[remove+1].getTask());
			tasks[remove].setBool(tasks[remove+1].getBool());
			//System.out.println(tasks[remove].getTask());
			remove++;
		}
		//make the last element null
		tasks[remove] = null;
		System.out.println("Task has been removed from list!");
	}
	public static void markTaskComplete(taskObject[] tasks) {
		taskObject[] incompleteTasks = new taskObject[10];
		//for every element in task that is incomplete i.e false
		for(int j = 0; j < tasks.length; j++) {
			if(tasks[j]!= null) {
				if(tasks[j].getBool() == false) {
					//create an object to place on the jth element
					taskObject tempTask = new taskObject();
					//set place tempTask in the incompleteTasks array
					incompleteTasks[j] = tempTask;
					incompleteTasks[j].setTask(tasks[j].getTask());
					incompleteTasks[j].setBool(false);
					System.out.println( (j+1) + ".) " + incompleteTasks[j].getTask());

				}
			}
			else {
				j++;
			}
		}
		System.out.println("\n");
		//for loop that will go through every element in the incompleteTasks array;
		System.out.println("Which task do you want to mark complete?");
		//declare a new scanner object
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		//read in user input and store it
		int userInput = input.nextInt();
		userInput = userInput -1;
		//the user wants to 
		//mark 'userInputTask' complete 
		tasks[userInput].setBool(true);
		System.out.println("Task has been marked completed!");
		System.out.println("\n");
	}
	public static void listTasks(taskObject tasks[]){
		String indicator;
		//check if the array is empty
		if(tasks[0] == null) {
			System.out.println("**There are currently no tasks on your list**");
			System.out.println("\n");
		}
		//print out everything in tasks;
		for(int i = 0; i<tasks.length; i++) {
			if(tasks[i] != null) {
				int num = i +1;
				if(tasks[i].getBool() == true) {
					indicator = "(COMPLETE)";
				}
				else {
					indicator = "";
				}
				System.out.println( num + ".) " + tasks[i].getTask() + " " + indicator);
			}
		}
		System.out.println("\n");
	}
}
