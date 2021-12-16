package com.kiki.wiki.controller;

import com.kiki.wiki.req.EbookQueryReq;
import com.kiki.wiki.req.EbookSaveReq;
import com.kiki.wiki.resp.CommonResp;
import com.kiki.wiki.resp.PageResp;
import com.kiki.wiki.service.EbookService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

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
    public CommonResp list(@Valid EbookQueryReq ebookQueryReq){
        CommonResp<PageResp<com.kiki.wiki.resp.EbookQueryReq>> resp =new CommonResp<>();
        PageResp<com.kiki.wiki.resp.EbookQueryReq> list = ebookService.list(ebookQueryReq);
        resp.setContent(list);
        return resp;
    }

    @PostMapping("/save")
    public CommonResp save(@Valid @RequestBody EbookSaveReq req){
        CommonResp resp =new CommonResp<>();
        ebookService.save(req);
        return resp;
    }

    @DeleteMapping("/delete/{id}")
    public CommonResp delete(@PathVariable Long id){
        CommonResp resp =new CommonResp<>();
        ebookService.delete(id);
        return resp;
    }
}
