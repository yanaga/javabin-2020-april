package com.redhat.developers;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class DeveloperRepository implements PanacheRepository<Developer> {

    public List<Developer> findBrazilianJapanese() {
        return find("name = ?1", "Yanaga").list();
    }
    
}