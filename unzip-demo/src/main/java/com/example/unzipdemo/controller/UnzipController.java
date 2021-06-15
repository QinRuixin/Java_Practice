package com.example.unzipdemo.controller;

import com.example.unzipdemo.service.QueryService;
import com.example.unzipdemo.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @author qin
 * @description todo
 * @date 2021-06-15
 */
@RestController
@RequestMapping("/unzip")
public class UnzipController {

    @Autowired
    QueryService queryService;

    @PostMapping("/uploadUnRegister")
    public ResponseVO uploadUnRegister( @RequestParam("sourceCode") MultipartFile sourceCode
            , HttpServletRequest httpServletRequest){
        ResponseVO responseVO;
        try {
            responseVO = queryService.queryNotRegister(sourceCode, 1L);
        }catch (Exception e){
            responseVO = ResponseVO.buildFailure(e.getMessage());
        }
        return responseVO;
    }
}
