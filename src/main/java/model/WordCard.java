package model;

public class WordCard {

    private String imgPath = "img/personLogo.png";
    private final String nativeLanguage;
    private final String foreignLanguage;

    public WordCard(String nativeLanguage, String foreignLanguage, String imgPath) {
        if(imgPath!=null){
            this.imgPath = imgPath;
        }
        this.nativeLanguage = nativeLanguage;
        this.foreignLanguage = foreignLanguage;
    }

    public String getImgPath() {
        return imgPath;
    }

    public String getNativeLanguage() {
        return nativeLanguage;
    }

    public String getForeignLanguage() {
        return foreignLanguage;
    }
}
