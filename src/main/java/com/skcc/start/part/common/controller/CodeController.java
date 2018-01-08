package com.skcc.start.part.common.controller;

import com.skcc.fwk.base.BaseController;
import com.skcc.start.config.BaseConfig;
import com.skcc.start.entity.common.Code;
import com.skcc.start.part.common.service.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value = "/codes")
public class CodeController extends BaseController {

    @Autowired
    CodeService serviceCode;

    @GetMapping(value = "")
    public Collection<Code> getCodes() {
        return serviceCode.getCodes();
    }

    @PostMapping(value = "/{codeName}")
    public void postCode(
            @PathVariable String codeName,
            @RequestBody Code code
    ) {
        serviceCode.postCode(code);
    }
}
