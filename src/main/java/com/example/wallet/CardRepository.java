package com.example.wallet;

import org.springframework.data.repository.CrudRepository;

public interface CardRepository extends CrudRepository<Card, String>{
    
}