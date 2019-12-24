package kit.side.forum.service;

import kit.side.forum.dao.ArticleRepository;
import kit.side.forum.entity.Article;
import kit.side.forum.entity.HeadArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService {
    private ArticleRepository articleRepository;

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    @Override
    public Article findById(Integer articleID) {
        Optional<Article> queryResult = articleRepository.findById(articleID);
        Article article = null;
        if(queryResult.isPresent())
            article = queryResult.get();
        else
            throw new RuntimeException("articleID is not exist :" + articleID);
        return article;
    }

    @Override
    public void save(Article article) {
        articleRepository.save(article);
    }

    @Override
    public List<Article> getArticleByTitle(String title) {
        List<Article> queryResultList = articleRepository.getArticleByTitle(title);
        if(queryResultList.isEmpty())
            throw new RuntimeException("No result match the title : " + title);
        else
            return queryResultList;
    }

    @Override
    public List<Article> getArticleByNickname(String nicknameOfAuthor) {
        List<Article> queryResultList = articleRepository.getArticleByNickname(nicknameOfAuthor);
        if(queryResultList.isEmpty())
            throw new RuntimeException("No result match the nickname : " + nicknameOfAuthor);
        else
            return queryResultList;
    }

    @Override
    public void hideArticle(Integer articleID) {
        articleRepository.hideArticle(articleID);
    }

    @Override
    public void like(Integer articleID, Article Article) {
        articleRepository.like(articleID, Article);
    }
}
