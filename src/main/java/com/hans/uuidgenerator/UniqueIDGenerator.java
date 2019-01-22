package com.hans.uuidgenerator;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class UniqueIDGenerator {

    private Random random;

    public UniqueIDGenerator(){
        random = new Random();
    }

    public String generateUniqueID(int x, int y, int z){

        int seed = random.nextInt();
        return Integer.toString(seed);
    }

}
