package com.redhat.developers;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDeveloperRepository extends JpaRepository<Developer, Long> {

    public List<Developer> findByName(String name);

}