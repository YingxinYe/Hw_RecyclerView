package android.example.hw_recyclerview.model;

public class user {
    private int image;
    private String title;
    private String descripton;

    public user(){};

    public user(int image, String title, String descripton) {
        this.image = image;
        this.title = title;
        this.descripton = descripton;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescripton() {
        return descripton;
    }

    public void setDescripton(String descripton) {
        this.descripton = descripton;
    }
}
