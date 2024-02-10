package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.modal.Entity;

public interface AppRepository extends JpaRepository<Entity, Integer> {

}
