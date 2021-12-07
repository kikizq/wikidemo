package com.kiki.wiki.controller;

import com.kiki.wiki.req.EbookReq;
import com.kiki.wiki.resp.CommonResp;
import com.kiki.wiki.resp.EbookResp;
import com.kiki.wiki.resp.PageResp;
import com.kiki.wiki.service.EbookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author qizhang
 * @date 2021/9/27
 * @desc
 */
@RestController
@RequestMapping("/ebook")
public class EbookController {


    @Resource
    private EbookService ebookService;

    @GetMapping("/list")
    public CommonResp list(EbookReq ebookReq){
        CommonResp<PageResp<EbookResp>> resp =new CommonResp<>();
        PageResp<EbookResp> list = ebookService.list(ebookReq);
        resp.setContent(list);
        return resp;
    }
}
