package com.hans.uuidgenerator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UniqueIDGeneratorTest {

    @Autowired
    private UniqueIDGenerator _uniqueIDGenerator;

    @Test
    public void testGenerateUniqueID(){
        String uuid = _uniqueIDGenerator.generateUniqueID(2,5,7);

        Assert.assertTrue(uuid.length()>=30);
        Assert.assertTrue(uuid.length()<=40);
    }

    @Test
    public void testInvalidParams(){
        _uniqueIDGenerator.generateUniqueID(-1,-1,-1);
    }
}
