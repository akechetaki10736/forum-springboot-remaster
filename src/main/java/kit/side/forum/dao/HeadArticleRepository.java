package kit.side.forum.dao;

import kit.side.forum.entity.HeadArticle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HeadArticleRepository extends JpaRepository<HeadArticle, Integer> {

    @Query("select h from HeadArticle h where h.title like CONCAT('%',:title,'%')")
    List<HeadArticle> getHeadArticleByTitle(@Param("title") String title);

    @Query("select a from HeadArticle a where a.nickname like CONCAT('%',:nicknameOfAuthor,'%')")
    List<HeadArticle> getHeadArticleByNickname(@Param("nicknameOfAuthor") String nicknameOfAuthor);

    @Query("select h from HeadArticle h where h.category like CONCAT('%',:category,'%')")
    List<HeadArticle> getHeadArticleByCategory(@Param("category") String category);

    @Query("select h from HeadArticle h order by h.popularity")
    List<HeadArticle> getHeadArticleByPopularity();

    @Query("update HeadArticle set isHide = true")
    void hideArticle(Integer headArticleID);

    @Query("update HeadArticle set likes = likes+1")
    void like(Integer articleID, HeadArticle headArticle);
}
