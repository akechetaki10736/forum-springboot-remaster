package kit.side.forum.service;

import kit.side.forum.entity.Article;
import kit.side.forum.entity.HeadArticle;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArticleService {
    public List<Article> findAll();

    public Article findById(Integer articleID);

    public void save(Article article);

    List<Article> getArticleByTitle(String title);

    List<Article> getArticleByNickname(String nicknameOfAuthor);

    void hideArticle(Integer articleID);

    void like(Integer articleID, Article Article);
}
