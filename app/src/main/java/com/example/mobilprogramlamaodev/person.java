package com.example.mobilprogramlamaodev;

public class person {

    String nickname;
    int imagepp,image2;

    public person(String nickname, int imagepp, int image2) {
        this.nickname = nickname;
        this.imagepp = imagepp;
        this.image2 = image2;
    }
    public person(String nickname,int imagepp){
        this.nickname = nickname;
        this.imagepp = imagepp;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getImagepp() {
        return imagepp;
    }

    public void setImagepp(int imagepp) {
        this.imagepp = imagepp;
    }

    public int getImage2() {
        return image2;
    }

    public void setImage2(int image2) {
        this.image2 = image2;
    }
}
