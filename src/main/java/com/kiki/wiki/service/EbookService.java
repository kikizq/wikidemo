package com.kiki.wiki.service;

import com.kiki.wiki.domain.Ebook;
import com.kiki.wiki.mapper.EbookMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author qizhang
 * @date 2021/9/30
 * @desc
 */
@Service
public class EbookService {
    @Resource
    private EbookMapper ebookMapper;
    public List<Ebook> list(){
        return ebookMapper.selectByExample(null);
    }
}
