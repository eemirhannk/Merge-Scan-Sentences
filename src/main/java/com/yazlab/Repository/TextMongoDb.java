package com.yazlab.Repository;


import com.yazlab.Entity.Input;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TextMongoDb extends MongoRepository<Input,Integer> {


}
