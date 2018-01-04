package com.skcc.start.part.common.controller;

import com.skcc.start.part.common.service.CodeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/codes")
public class CodeController {

    @GetMapping(value = "")
    public String getCodes(){


        return codes;
    }
}
