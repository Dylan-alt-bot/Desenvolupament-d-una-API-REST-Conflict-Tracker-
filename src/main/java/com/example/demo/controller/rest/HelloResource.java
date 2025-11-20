package com.example.demo.controller.rest;

import com.example.demo.dto.HelloDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(HelloResource.HELLO_RESOURCE)
public class HelloResource {
    public static final String HELLO_RESOURCE = "/hello";

        @GetMapping
        public HelloDto hello(@RequestParam(value = "name", defaultValue = "World") String name) {
            HelloDto hdto = new HelloDto(1,name);
            return hdto;
        }

        @GetMapping("/bye")
        public String bye() {
            return "Goodbye!";
        }

    }
