package com.hans.uuidgenerator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PalindromeFinderTest {

    private Logger _log = LoggerFactory.getLogger(PalindromeFinderTest.class);

    @Autowired
    private PalindromeFinder _palindromeFinder;

    @Autowired
    private UniqueIDGenerator _uniqueIDGenerator;

    @Test
    public void testFindLargestPalindromeString(){
        String testString = "dabccbaf";
        String pal = _palindromeFinder.findLargestPalindromeString(testString);

        Assert.assertEquals( "abccba",pal);
    }

    @Test
    public void testFindLargestPalindromeString2(){
        String testString = "amanaplanacanalpanama";
        String pal = _palindromeFinder.findLargestPalindromeString(testString);

        Assert.assertEquals( "amanaplanacanalpanama",pal);
    }

    @Test
    public void testtestFindLargestPalindromeString2(){
        String uuid = _uniqueIDGenerator.generateUniqueID(2,5,7);
        String pal = _palindromeFinder.findLargestPalindromeString(uuid);
        _log.info("found uuid pal {} in uuid {}",pal, uuid);

    }

}
