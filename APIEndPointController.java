package com.firstapi.firstapi;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class APIEndPointController {


    HashMap<Integer, User> Userdb = new HashMap<>();

    @GetMapping("/getWeather") //http://localhost:8080/getWeather
    public String weatherInfo() {
        return "Today's weather is hot";
    }

    @GetMapping("/sum")  //http://localhost:8080/sum?a=1&b=2
    public String calculateSum(@RequestParam("a") Integer a, @RequestParam("b") Integer b) {
        int total = a + b;
        return "Total Sum is " + total;
    }

    @PostMapping("/signUP") //http://localhost:8080/signUP
    public String Signup(@RequestBody User User) {
        int primaryKey = User.getUserId();
        Userdb.put(primaryKey, User);
        return "User" + User.getName() + "added";
    } /*{
    "userId" : 1,
    "name" : "vicky",
    "emailId" : "vigneshemail@email.com",
    "phnNumber" : "123456789"
      }*/

    @GetMapping("/getUser") //http://localhost:8080/getUser?UserId=1
    public User getUser(@RequestParam("UserId") Integer UserId) {
        return Userdb.get(UserId);
    }

    @GetMapping("/getUserByName/{name}") //http://localhost:8080/getUserByName/vicky
    public List<User> getUserByName(@PathVariable("name") String bad) {
        List<User> finallist = new ArrayList<>();
        for (User ans : Userdb.values()) {
            if (ans.getName().equals(bad)) {
                finallist.add(ans);
            }
        }
        return finallist;

    }

    @PutMapping("/updateName") //http://localhost:8080/updateName?userID=2
    public String updateName(@RequestBody User UpdateUser,@RequestParam("userID") Integer userID){
        int Pk = userID;
        Userdb.put(Pk,UpdateUser);
        return "User" +UpdateUser.getName()+ "modified";
    }

    /*@DeleteMapping("/deleteuser/{userName}")//http://localhost:8080/deleteuser/vicky
    public String deleteuser(@PathVariable("userName") String name){
     */
    @DeleteMapping("/deleteuser") //http://localhost:8080/deleteuser?userName=zz
    public String deleteuser(@RequestParam("namee") String name){

        for(int key: Userdb.keySet()){
            User user= Userdb.get(key);
            if(user.getName().equals(name)){
                Userdb.remove(key);
            }
        }
        return "User" +name+ "modified";
    }



}