package com.skcc.start.part.common.controller;

import com.skcc.fwk.base.BaseController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "")
public class MainController extends BaseController {

    @GetMapping(value = "")
    public String main(){
        return "alive";
    }
}
