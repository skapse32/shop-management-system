package com.congdongjava.repo.impl;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

public class AbstractBaseDao {
	@Autowired
    protected EntityManager em;
}
