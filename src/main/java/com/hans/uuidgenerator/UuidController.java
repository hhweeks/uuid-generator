package com.hans.uuidgenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UuidController {

    @Autowired
    UniqueIDGenerator idGenerator;

    @Autowired
    PalindromeFinder palindromeFinder;

    @RequestMapping(method = RequestMethod.GET, value = "/generate")
    public String generate(@RequestParam(value="x", defaultValue = "2") int x,
                           @RequestParam(value="y", defaultValue = "7")int y,
                           @RequestParam(value="z", defaultValue = "5")int z){

        return idGenerator.generateUniqueID(x,y,z);

    }

    @RequestMapping(method = RequestMethod.GET, value = "/palindrome")
    public String palindrome(@RequestParam(value="string", defaultValue = "hi") String string){

        String pal = palindromeFinder.findLargestPalindromeString(string);

        return pal;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/uuid")
    public Map<String, String> uuid(@RequestParam(value="x", defaultValue = "2") int x,
                                    @RequestParam(value="y", defaultValue = "7")int y,
                                    @RequestParam(value="z", defaultValue = "5")int z){
        HashMap<String, String> map = new HashMap<>();
        String uuid = idGenerator.generateUniqueID(x,y,z);
        String pal = palindromeFinder.findLargestPalindromeString(uuid);

        map.put("uuid", uuid);
        map.put("palindrome", pal);

        return map;
    }
}
