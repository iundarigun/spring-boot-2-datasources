package br.com.s2it.blog.sample2datasources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @RequestMapping("/")
    public String restTest(){
        return "hello world";
    }

}
