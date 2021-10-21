package com.kiki.wiki.service;

import com.kiki.wiki.domain.Ebook;
import com.kiki.wiki.domain.EbookExample;
import com.kiki.wiki.mapper.EbookMapper;
import com.kiki.wiki.req.EbookReq;
import com.kiki.wiki.resp.EbookResp;
import com.kiki.wiki.util.CopyUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

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

    public List<EbookResp> list(EbookReq ebookReq) {
        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria criteria = ebookExample.createCriteria();
        if (!ObjectUtils.isEmpty(ebookReq.getName())) {
            criteria.andNameLike("%" + ebookReq.getName() + "%");
        }
        List<Ebook> ebookList = ebookMapper.selectByExample(ebookExample);
//        List<EbookResp> ebookRespList = new ArrayList<>();
        //列表复制
        List<EbookResp> ebookRespList = CopyUtil.copyList(ebookList, EbookResp.class);
//        for (Ebook ebook:ebookList){
//            EbookResp ebookResp = new EbookResp();
//            BeanUtils.copyProperties(ebook,ebookResp);
//            ebookRespList.add(ebookResp);

//        }
        return ebookRespList;
    }
}
