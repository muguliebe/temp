package com.skcc.start.part.common.service;


import com.skcc.fwk.base.BaseService;
import com.skcc.start.entity.common.Code;
import com.skcc.start.repository.jpa.CodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class CodeService extends BaseService {

    @Autowired
    CodeRepository repoCode;

    public Collection<Code> getCodes() {
        return repoCode.findAll();
    }

    public void postCode(Code code) {
        repoCode.save(code);
    }
}
