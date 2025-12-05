package micro.service.review;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reviews")
public class ReviewEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    private Long productId;

    private String author;

    private String subject;

    private String content;

    public ReviewEntity() {
    }

    public ReviewEntity(Long reviewId, Long productId, String author, String subject, String content) {
        this.reviewId = reviewId;
        this.productId = productId;
        this.author = author;
        this.subject = subject;
        this.content = content;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setReviewId(Long productId) {
        this.productId = productId;
    }

    public Long getReviewId() {
        return reviewId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
