package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.modal.Entities;

public interface AppRepository extends JpaRepository<Entities, Integer> {

}
