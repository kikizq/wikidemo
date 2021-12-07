package com.kiki.wiki.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kiki.wiki.domain.Ebook;
import com.kiki.wiki.domain.EbookExample;
import com.kiki.wiki.mapper.EbookMapper;
import com.kiki.wiki.req.EbookReq;
import com.kiki.wiki.resp.EbookResp;
import com.kiki.wiki.resp.PageResp;
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

    public PageResp<EbookResp> list(EbookReq ebookReq) {

        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria criteria = ebookExample.createCriteria();
        if (!ObjectUtils.isEmpty(ebookReq.getName())) {
            criteria.andNameLike("%" + ebookReq.getName() + "%");
        }
        PageHelper.startPage(ebookReq.getPage(), ebookReq.getSize());
        List<Ebook> ebookList = ebookMapper.selectByExample(ebookExample);
//        List<EbookResp> ebookRespList = new ArrayList<>();
        //列表复制

        PageInfo<Ebook> pageInfo = new PageInfo<>(ebookList);
        List<EbookResp> ebookRespList = CopyUtil.copyList(ebookList, EbookResp.class);
//        for (Ebook ebook:ebookList){
//            EbookResp ebookResp = new EbookResp();
//            BeanUtils.copyProperties(ebook,ebookResp);
//            ebookRespList.add(ebookResp);

//        }

        PageResp<EbookResp> pageResp = new PageResp();
        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(ebookRespList);
        return pageResp;
    }
}
