package kit.side.forum.controller;

import kit.side.forum.entity.Article;
import kit.side.forum.entity.HeadArticle;
import kit.side.forum.service.ArticleService;
import kit.side.forum.service.HeadArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
public class ForumController {

    private HeadArticleService headArticleService;
    private ArticleService articleService;

    @Autowired
    public ForumController(HeadArticleService headArticleService, ArticleService articleService) {
        this.headArticleService = headArticleService;
        this.articleService = articleService;
    }

    @GetMapping("/")
    public String welcome(Model model){
        List<HeadArticle> headArticleList = headArticleService.findAll();
        model.addAttribute("time", new java.util.Date());
        model.addAttribute("headArticleList",headArticleList);
        return "index";
    }

    @GetMapping("/post")
    public String directToPostPage(Model model){
        HeadArticle headArticle = new HeadArticle();
        model.addAttribute("headArticle", headArticle);
        return "post";
    }

    @PostMapping("/post")
    public String post(@ModelAttribute("headArticle") HeadArticle headArticle){
        System.err.println(headArticle.getTitle());
        headArticleService.save(headArticle);
        return "redirect:/";
    }

    @GetMapping("/reply")
    public String directToReplyPage(Model model, @RequestParam("head") String articleID){
        Article article = new Article();
        article.setHeadArticle(headArticleService.findById(Integer.parseInt(articleID)));
        model.addAttribute("article", article);
        log.info(String.valueOf(article.getHeadArticle().getArticleID()));
        return "reply";
    }

    @PostMapping("/reply")
    public String reply(@ModelAttribute("article") Article article){
        articleService.save(article);
        return "redirect:/";
    }
}
