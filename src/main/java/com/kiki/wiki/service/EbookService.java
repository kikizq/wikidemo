package com.kiki.wiki.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kiki.wiki.domain.Ebook;
import com.kiki.wiki.domain.EbookExample;
import com.kiki.wiki.mapper.EbookMapper;
import com.kiki.wiki.req.EbookQueryReq;
import com.kiki.wiki.req.EbookSaveReq;
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

    public PageResp<com.kiki.wiki.resp.EbookQueryReq> list(EbookQueryReq ebookQueryReq) {

        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria criteria = ebookExample.createCriteria();
        if (!ObjectUtils.isEmpty(ebookQueryReq.getName())) {
            criteria.andNameLike("%" + ebookQueryReq.getName() + "%");
        }
        PageHelper.startPage(ebookQueryReq.getPage(), ebookQueryReq.getSize());
        List<Ebook> ebookList = ebookMapper.selectByExample(ebookExample);
//        List<EbookQueryReq> ebookQueryReqList = new ArrayList<>();
        //列表复制

        PageInfo<Ebook> pageInfo = new PageInfo<>(ebookList);
        List<com.kiki.wiki.resp.EbookQueryReq> ebookQueryReqList = CopyUtil.copyList(ebookList, com.kiki.wiki.resp.EbookQueryReq.class);
//        for (Ebook ebook:ebookList){
//            EbookQueryReq ebookResp = new EbookQueryReq();
//            BeanUtils.copyProperties(ebook,ebookResp);
//            ebookQueryReqList.add(ebookResp);

//        }

        PageResp<com.kiki.wiki.resp.EbookQueryReq> pageResp = new PageResp();
        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(ebookQueryReqList);
        return pageResp;
    }


    public void save(EbookSaveReq req) {
        Ebook ebook = CopyUtil.copy(req, Ebook.class);
        if (ObjectUtils.isEmpty(req.getId())) {
            ebookMapper.insert(ebook);
        } else {
            ebookMapper.updateByPrimaryKey(ebook);
        }

    }


}
