package com.capg.app.service;

import java.sql.SQLException;
import java.util.List;

import com.capg.app.beans.Instructor;
import com.capg.app.dao.InstructorDAO;
import com.capg.app.dao.InstructorDAOImpl;
import com.capg.app.dto.InstructorsLocationCountDTO;
import com.capg.app.exception.InstructorNotFoundException;

public class InstructorServiceImpl implements InstructorService{
InstructorDAO dao;
	
	public InstructorServiceImpl() {
		dao = new InstructorDAOImpl();
	}

	@Override
	public boolean insertInstructor(Instructor instructor)throws SQLException {
		
		boolean isQueryExecuted = false;
		
		// --- call business Server side validations
		
		// call Security layer 
		
		isQueryExecuted = dao.insertInstructor(instructor);
		
		// call Logger task
		
		return isQueryExecuted;
	}

	@Override
	public Instructor getInstructorByCode(int code) throws InstructorNotFoundException,SQLException  {
		// TODO Auto-generated method stub
		return dao.getInstructorByCode(code);
	}

	@Override
	public List<Instructor> getInstructors() throws SQLException{
		
		return dao.getInstructors();
	}

	@Override
	public List<Instructor> getInstructorsByLocation(String location)throws SQLException  {
		// TODO Auto-generated method stub
		return dao.getInstructorsByLocation(location);
	}

	@Override
	public List<InstructorsLocationCountDTO> getInstructorsCountByLocation()throws SQLException  {
		// TODO Auto-generated method stub
		return dao.getInstructorsCountByLocation();
	}

	@Override
	public List<Instructor> getInstructorsBySalary() throws SQLException {
		// TODO Auto-generated method stub
		return dao.getInstructorsBySalary();
	}

	@Override
	public boolean deleteInstructorByCode(int code) throws InstructorNotFoundException,SQLException {
        boolean isQueryExecuted = false;
		isQueryExecuted = dao.deleteInstructorByCode(code);
		return isQueryExecuted;
	}

	@Override
	public Instructor updateInstructor(Instructor oldInfoInstructor)throws SQLException  {
		
		return dao.updateInstructor(oldInfoInstructor);
	}
	

}
