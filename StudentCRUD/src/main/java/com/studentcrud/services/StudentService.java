package com.studentcrud.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentcrud.repository.StudentRepository;


@Service
public class StudentService {
	@Autowired
	private StudentRepository repo;
}
