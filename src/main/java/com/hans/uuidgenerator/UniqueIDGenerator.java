package com.hans.uuidgenerator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.util.Random;

@Component
public class UniqueIDGenerator {

    private static final int MIN_LENGTH = 30;
    private static final int MAX_LENGTH = 40;
    private static final int VALIDATE_BOUND = 10;
    private Random _random;
    private Logger _log = LoggerFactory.getLogger(UniqueIDGenerator.class);

    public UniqueIDGenerator(){
        _random = new Random();
    }

    public String generateUniqueID(int x, int y, int z){

        StringBuilder stringBuilder = new StringBuilder();

        //validate values to prevent errors while running
        x = validateParam(x);
        y = validateParam(y);
        z = validateParam(z);

        while(stringBuilder.length()<MIN_LENGTH){
            stringBuilder = _generateSequence(x,y,z, stringBuilder);
        }
        if(stringBuilder.length()>MAX_LENGTH){
            stringBuilder = stringBuilder.delete(MAX_LENGTH,stringBuilder.length());
        }
        _log.warn("output size is: {}", stringBuilder.length());

        return stringBuilder.toString();
    }

    private StringBuilder _generateSequence(int x, int y, int z, StringBuilder stringBuilder){

            int base = _random.nextInt((int)Math.pow(2,20));
            stringBuilder.append(base);

            for (int i = 0; i < z; i++) {
                if (base % 2 == 0) {
                    base /= x;
                } else {
                    base += y;
                }
                _log.info("base = {}", base);
                stringBuilder.append(base);
        }

        return stringBuilder;
    }

    private int validateParam(int n){

        if(n<1){
            _log.warn("illegal param value received {}", n);
            return _random.nextInt(VALIDATE_BOUND)+1;
        }
        return n;
    }
}
