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
    private static final int BOUND_EXPONENT = 20;
    private Random _random;
    private Logger _log = LoggerFactory.getLogger(UniqueIDGenerator.class);

    public UniqueIDGenerator(){
        _random = new Random();
    }

    /**
     *
     * @param x
     * @param y
     * @param z
     * @return
     *
     * verifies input params. calls sequence generator, then verifies the sequence is
     * the correct length.
     */
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

    /**
     *
     * @param x
     * @param y
     * @param z
     * @param stringBuilder
     * @return string of pseudorandom numbers
     *
     * generates base random value, adds it to stringBuilder, generates new values
     * based on base value according to even/odd rules. Generates and adds to stringBuilder
     * z times.
     */
    private StringBuilder _generateSequence(int x, int y, int z, StringBuilder stringBuilder){

            int base = _random.nextInt((int)Math.pow(2,BOUND_EXPONENT));
            stringBuilder.append(base);

            //rules 2 and 3 run z times
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

    /**
     *
     * @param n
     * @return n or valid param
     *
     * verifies n is non-zero, non-negative
     */
    private int validateParam(int n){

        if(n<1){
            _log.warn("illegal param value received {}", n);
            return _random.nextInt(VALIDATE_BOUND)+1;
        }
        return n;
    }
}
