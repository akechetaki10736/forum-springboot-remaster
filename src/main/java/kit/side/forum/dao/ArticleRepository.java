package kit.side.forum.dao;

import kit.side.forum.entity.Article;
import kit.side.forum.entity.HeadArticle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

    @Query("select a from Article a where a.title like concat('%',:title,'%')")
    List<Article> getArticleByTitle(@Param("title") String title);

    @Query("select a from Article a where a.nickname like concat('%',:nicknameOfAuthor,'%')")
    List<Article> getArticleByNickname(@Param("nicknameOfAuthor") String nicknameOfAuthor);

    @Query("update Article set isHide = true")
    void hideArticle(Integer articleID);

    @Query("update Article set popularity = popularity+1")
    void like(Integer articleID, Article article);
}
