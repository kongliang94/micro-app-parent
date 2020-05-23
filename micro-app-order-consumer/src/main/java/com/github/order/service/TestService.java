package com.github.order.service;

import com.github.common.model.ResultModel;
import com.github.utils.ResultUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class TestService {
    public ResultModel getOrder(Long id){
        return ResultUtils.success("success");
    }
}
