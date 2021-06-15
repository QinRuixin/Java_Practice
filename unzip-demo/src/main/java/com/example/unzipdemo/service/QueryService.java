package com.example.unzipdemo.service;

import com.example.unzipdemo.vo.ResponseVO;
import org.springframework.web.multipart.MultipartFile;

public interface QueryService {

    ResponseVO queryRegister(MultipartFile bugReport, String commitId, Long userId);

    ResponseVO queryNotRegister(MultipartFile sourceCode, Long userId);

}
