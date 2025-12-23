package board.DAO;

public class DesignerVO {
    private int id;
    private String name;
    private String info;
    private String career;
    private int reviewCnt;
    private String imgUrl;

    // Getter & Setter (우클릭 -> Source -> Generate Getters and Setters로 만드세요)
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getInfo() { return info; }
    public void setInfo(String info) { this.info = info; }
    public String getCareer() { return career; }
    public void setCareer(String career) { this.career = career; }
    public int getReviewCnt() { return reviewCnt; }
    public void setReviewCnt(int reviewCnt) { this.reviewCnt = reviewCnt; }
    public String getImgUrl() { return imgUrl; }
    public void setImgUrl(String imgUrl) { this.imgUrl = imgUrl; }
}