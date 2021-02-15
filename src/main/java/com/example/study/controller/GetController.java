package com.example.study.controller;


import com.example.study.model.SearchParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api") // Localhost:8080/api
public class GetController {

    @RequestMapping(method = RequestMethod.GET , path = "/getMethod") // localhost:8080/api/getMethod
    public String getRequest(){

        return "Hi getMethod";
    }

    @GetMapping("/getParameter")  // localhost:8080/api/getMethod?id=1234&password=abcd
    public String getParameter(@RequestParam String id , @RequestParam (name = "password")String pwd){
        String password = "bbbb";

        System.out.println("id : " +id);
        System.out.println("pwd : " +password);

        return id+pwd;
    }

    // localhost:9090/api/multiparameter?account=abcd&email=study@gamail.com&page=10
    @GetMapping("/getMultiParameter")
    public SearchParam getMultiParameter(SearchParam searchParam){
        System.out.println(searchParam.getAccount());
        System.out.println(searchParam.getEmail());
        System.out.println(searchParam.getPage());

        // { "account : "" , "email" : "", "page" : 0} JSON
        return searchParam;
    }

}
