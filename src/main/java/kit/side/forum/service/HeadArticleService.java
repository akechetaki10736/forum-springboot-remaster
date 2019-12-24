package kit.side.forum.service;

import kit.side.forum.entity.HeadArticle;

import java.util.List;

public interface HeadArticleService {
    public List<HeadArticle> findAll();

    public HeadArticle findById(Integer articleID);

    public void save(HeadArticle headArticle);

    public List<HeadArticle> getHeadArticleByTitle(String title);

    public List<HeadArticle> getHeadArticleByNickname(String nicknameOfAuthor);

    public List<HeadArticle> getHeadArticleByCategory(String category);

    public List<HeadArticle> getHeadArticleByPopularity();

    public void like(Integer articleID, HeadArticle headArticle);

    public void hideArticle(Integer articleID);

}
