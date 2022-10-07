package com.example.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class VotoRepoImpl implements IVotoRepo{
	
	@PersistenceContext
	private EntityManager entityManager;
}
