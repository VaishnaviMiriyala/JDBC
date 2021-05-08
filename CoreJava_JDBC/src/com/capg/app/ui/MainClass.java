package com.capg.app.ui;

import java.util.List;
import java.util.Scanner;

import com.capg.app.beans.Instructor;
import com.capg.app.dto.InstructorsLocationCountDTO;
import com.capg.app.service.InstructorService;
import com.capg.app.service.InstructorServiceImpl;

public class MainClass {
InstructorService service;
	
	public MainClass() {
		service = new InstructorServiceImpl();
	}
	
	public static void main(String[] args) {
		
		MainClass obj = new MainClass();
		
		while(true)
		{
			
			System.out.println("1. Insert");
			System.out.println("2. Show All");
			System.out.println("3. Get details by Instructorcode");
			System.out.println("4. Get details by location");
			System.out.println("5. Get details in the Ascending order of salary");
			System.out.println("6. Delete a row ");
			System.out.println("7. Get Insructor count by Location");
			System.out.println("8. Update the details");
			System.out.println("0. EXIT");
			
		
			
			int opt = new Scanner(System.in).nextInt(); 
			
			
			if(opt == 1)
			{
				obj.insertInstructorDetailsFromUser();
			}
			if(opt == 2)
			{
				
				obj.readInstructorDetails();
			}
			if(opt == 3) {
				System.out.println("Enter the code:");
				int code = new Scanner(System.in).nextInt(); 
				obj.getDetailsByCode(code);
			}
			if(opt == 4) {
				System.out.println("Enter the location");
				String location = new Scanner(System.in).nextLine();
				obj.getInstructorByLocation(location);
			}
			if(opt == 5) {
				obj.getDetailsBySalary();
			}
			if(opt == 6) {
				System.out.println("Enter the Id of the row to be deleted");
				int code = new Scanner(System.in).nextInt(); 
				obj.getDetailsAfterDelete(code);
			}
			if(opt == 7) {
				obj.getInstructorByCount();
			}
			if(opt == 8) {
				System.out.println("Enter the Id of the row to be updated");
				int code = new Scanner(System.in).nextInt(); 
				obj.getDetailsUpdated(code);
			}
			if(opt == 0)
			{
				System.exit(0);
			}
			
			
		}
		
		
	}//end main
	
	public void insertInstructorDetailsFromUser()
	{
		
		// ... write code to read data hope 
		Instructor instructor = new Instructor(130, "X", 7000, 2000, "x@x.com", "B");
		try {
			boolean result = service.insertInstructor(instructor);
			
			if(result) System.out.println(" Instructor Added");
			else System.out.println("Contact Admin ...");
		} catch (Exception e) {
			showErr(e);
		}
		
		
	}
	public void readInstructorDetails()
	{
		
		try
		{
			List<Instructor> list = service.getInstructors() ;
			
			list.stream().forEach(instructor->displayInstructor(instructor));
		}
		catch(Exception e)
		{
			showErr(e);
		}
	
	}
	public void getDetailsByCode(int code) {
		try
		{
			Instructor i = service.getInstructorByCode(code) ;
			displayInstructor(i);
			
		}
		catch(Exception e)
		{
			showErr(e);
		}
	}
	public void getInstructorByLocation(String location) {
		try
		{
			List<Instructor> list = service.getInstructorsByLocation(location) ;
			
			list.stream().forEach(instructor->displayInstructor(instructor));
		}
		catch(Exception e)
		{
			showErr(e);
		}
	}
	
	public void getDetailsBySalary() {
		try
		{
			List<Instructor> list = service.getInstructorsBySalary() ;
			
			list.stream().forEach(instructor->displayInstructor(instructor));
		}
		catch(Exception e)
		{
			showErr(e);
		}
	}
	
	public void getDetailsAfterDelete(int code) {
		try {
			boolean result = service.deleteInstructorByCode(code);
			
			if(result) System.out.println(" Instructor Deleted");
			else System.out.println("Contact Admin ...");
		} catch (Exception e) {
			showErr(e);
		}
	}
	
	public void getInstructorByCount() {
		try
		{
			List<InstructorsLocationCountDTO> list = service.getInstructorsCountByLocation() ;
			
			list.stream().forEach(instructor->displayInstructorDetails(instructor));
		}
		catch(Exception e)
		{
			showErr(e);
		}
		
	}
	
	public void displayInstructorDetails(InstructorsLocationCountDTO instructor) {
		System.out.println(instructor);
		System.out.println("-------------------------------------------------------");
	}
    
	
    public void getDetailsUpdated(int code) {
    	
    	try
		{
    		Instructor i = service.getInstructorByCode(code);
			Instructor instructor = service.updateInstructor(i) ;
			
			displayInstructor(instructor);
		}
		catch(Exception e)
		{
			showErr(e);
		}
	}
	public void displayInstructor(Instructor instructor)
	{
		
		System.out.println(instructor);
		System.out.println("-------------------------------------------------------");
	}
	
	
	public void showErr(Exception e)
	{
		System.out.println("====>> "+e);
	}

}
