package com.hacktues.persistence.service.impl;

import com.hacktues.persistence.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TestServiceImpl implements TestService {
    @Override
    public String method1() {
        log.info("Test method executed");
        return "result";
    }
}
