package kit.side.forum.service;

import kit.side.forum.dao.HeadArticleRepository;
import kit.side.forum.entity.HeadArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@Service
public class HeadArticleServiceImpl implements HeadArticleService{

    private HeadArticleRepository headArticleRepository;

    @Autowired
    public HeadArticleServiceImpl(HeadArticleRepository headArticleRepository) {
        this.headArticleRepository = headArticleRepository;
    }

    @Override
    public List<HeadArticle> findAll() {
        return headArticleRepository.findAll();
    }

    @Override
    public HeadArticle findById(Integer articleID) {
        Optional<HeadArticle> queryResult = headArticleRepository.findById(articleID);
        HeadArticle headArticle = null;
        if(queryResult.isPresent())
            headArticle = queryResult.get();
        else
            throw new RuntimeException("articleID is not exist :" + articleID);
        return headArticle;
    }

    @Override
    public void save(HeadArticle headArticle) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = simpleDateFormat.format(new java.sql.Timestamp(System.currentTimeMillis()));
        Timestamp currentTimestamp = Timestamp.valueOf(currentTime);

        if(headArticle.getPostTime() == null)
            headArticle.setPostTime(currentTimestamp);

        headArticle.setEditTime(currentTimestamp);

        headArticleRepository.save(headArticle);
    }

    @Override
    public List<HeadArticle> getHeadArticleByTitle(String title) {
        List<HeadArticle> queryResultList = headArticleRepository.getHeadArticleByTitle(title);
        if(queryResultList.isEmpty())
            throw new RuntimeException("No result match the title : " + title);
        else
            return queryResultList;
    }

    @Override
    public List<HeadArticle> getHeadArticleByNickname(String nicknameOfAuthor) {
        List<HeadArticle> queryResultList = headArticleRepository.getHeadArticleByNickname(nicknameOfAuthor);
        if(queryResultList.isEmpty())
            throw new RuntimeException("No result match the nickname : " + nicknameOfAuthor);
        else
            return queryResultList;
    }

    @Override
    public List<HeadArticle> getHeadArticleByCategory(String category) {
        List<HeadArticle> queryResultList = headArticleRepository.getHeadArticleByCategory(category);
        if(queryResultList.isEmpty())
            throw new RuntimeException("No result match the category : " + category);
        else
            return queryResultList;
    }

    @Override
    public List<HeadArticle> getHeadArticleByPopularity() {
        List<HeadArticle> queryResultList = headArticleRepository.getHeadArticleByPopularity();
        return queryResultList;
    }

    @Override
    public void like(Integer articleID, HeadArticle headArticle) {
        headArticleRepository.like(articleID, headArticle);
    }

    @Override
    public void hideArticle(Integer articleID) {
        headArticleRepository.hideArticle(articleID);
    }
}
