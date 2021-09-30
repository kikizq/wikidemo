package com.kiki.wiki.service;

import com.kiki.wiki.domain.Test;
import com.kiki.wiki.mapper.TestMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author qizhang
 * @date 2021/9/30
 * @desc
 */
@Service
public class TestService {
    @Resource
    private TestMapper testMapper;
    public List<Test> list(){
        return testMapper.selectByExample(null);
    }
}
