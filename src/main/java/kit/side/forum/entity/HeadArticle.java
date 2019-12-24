package kit.side.forum.entity;

import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table
@AllArgsConstructor
public class HeadArticle {
    @Column(length = 45)
    private String username;
    @Column(length = 45)
    private String nickname;
    @Column(length = 45)
    private String category;
    @Column(length = 100)
    private String title;
    @Lob
    @Column(columnDefinition = "text")
    private String content;
    @Lob
    @Column(columnDefinition = "text")
    private String signature;
    private Integer popularity = 0;
    private Integer likes = 0;
    private Integer replies = 0;
    private Timestamp postTime;
    private Timestamp editTime;
    private Integer memberID;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer articleID;
    private Boolean isHide = false;

    @OneToMany(mappedBy = "headArticle")
    private List<Article> articleList;

    public HeadArticle() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String account) {
        this.username = account;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Integer getPopularity() {
        return popularity;
    }

    public void setPopularity(Integer popularity) {
        this.popularity = popularity;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getReplies() {
        return replies;
    }

    public void setReplies(Integer replies) {
        this.replies = replies;
    }

    public Timestamp getPostTime() {
        return postTime;
    }

    public void setPostTime(Timestamp postTime) {
        this.postTime = postTime;
    }

    public Timestamp getEditTime() {
        return editTime;
    }

    public void setEditTime(Timestamp editTime) {
        this.editTime = editTime;
    }

    public Integer getMemberID() {
        return memberID;
    }

    public void setMemberID(Integer memberID) {
        this.memberID = memberID;
    }

    public Integer getArticleID() {
        return articleID;
    }

    public void setArticleID(Integer articleID) {
        this.articleID = articleID;
    }
}
