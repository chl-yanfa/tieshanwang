package com.tieshan.api.controller.tieshanAppHomePage.v1;
import com.tieshan.api.po.homePagePo.v1.TbArticle;
import com.tieshan.api.service.homePageService.v1.TbArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "v1/notice/")
public class noticController {
    @Autowired
    private TbArticleService tbArticleService;
    @RequestMapping("/notices")
    public String test(HttpServletRequest request){
        String id=request.getParameter("id");
        TbArticle tbArticle=tbArticleService.selectByPrimaryKey(Integer.parseInt(id));
        request.setAttribute("tbArticle", tbArticle);
        return "notice";
    }
}
