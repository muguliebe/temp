package com.skcc.start.part.common.controller;

import com.skcc.fwk.base.BaseController;
import com.skcc.start.config.BaseConfig;
import com.skcc.start.entity.common.Code;
import com.skcc.start.part.common.service.CodeService;
import com.skcc.start.part.member.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value = "/codes")
@Api(value="코드 콘트롤러", description = "코드값 관리")
public class CodeController extends BaseController {

    @Autowired
    CodeService serviceCode;

    @Autowired // <-----------
    UserService serviceUser; // <-----------

    @GetMapping(value = "")
    @ApiOperation(value = "코드 전체 조회", notes = "입력값 없음")
    public Collection<Code> getCodes() {
        serviceUser.test(); // <-----------
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
