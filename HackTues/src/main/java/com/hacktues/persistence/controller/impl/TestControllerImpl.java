package com.hacktues.persistence.controller.impl;

import com.hacktues.error.exeption.TestException;
import com.hacktues.persistence.controller.TestController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@RestController
@RequestMapping("/api/hacktues")
public class TestControllerImpl implements TestController {
    @Override
    public ModelAndView test(String id) {
        throw new TestException("Test", new RuntimeException("Original exception"));
        //return null;
    }
}
