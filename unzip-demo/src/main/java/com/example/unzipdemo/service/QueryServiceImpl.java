package com.example.unzipdemo.service;

import com.example.unzipdemo.util.MyFileUtil;
import com.example.unzipdemo.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author qin
 * @description todo
 * @date 2021-06-15
 */
@Service
public class QueryServiceImpl implements QueryService {

    @Value("${file.path.code}")
    String codePath;

    @Value("${file.path.report}")
    String reportPath;

    @Value("${file.path.python-cache}")
    String pythonCachePath;

    @Override
    public ResponseVO queryRegister(MultipartFile bugReport, String commitId, Long userId) {
        return null;
    }

    @Override
    public ResponseVO queryNotRegister(MultipartFile sourceCode, Long userId) {
        String codeDir = "";
        try {
            codeDir = MyFileUtil.unZipAndSaveDir(codePath, sourceCode);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseVO.buildSuccess(codeDir);
    }
}
