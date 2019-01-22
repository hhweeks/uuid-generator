package com.hans.uuidgenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UuidController {

    @Autowired
    UniqueIDGenerator idGenerator;

    @RequestMapping(method = RequestMethod.GET, value = "/generate")
    public String generate(@RequestParam(value="x", defaultValue = "2") int x,
                           @RequestParam(value="y", defaultValue = "7")int y,
                           @RequestParam(value="z", defaultValue = "5")int z){

        return idGenerator.generateUniqueID(x,y,z);

    }
}
