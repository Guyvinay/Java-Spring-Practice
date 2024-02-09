package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.app.modal.Entities;

@Service
public interface DbRepository extends JpaRepository<Entities, Integer> {

}
