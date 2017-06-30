package com.ito.domain;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by 韩九日 on 2017/6/29.
 */
public class Resume {
    private Integer r_id;
    private String r_sex;
    private String r_name;
    private int r_age;
    private String r_telephone;
    private String r_post;
    private String r_city;
    private String r_life;
    private MultipartFile r_resume;

    public String getR_sex() {
        return r_sex;
    }

    public void setR_sex(String r_sex) {
        this.r_sex = r_sex;
    }

    public Integer getR_id() {
        return r_id;
    }

    public void setR_id(Integer r_id) {
        this.r_id = r_id;
    }

    public String getR_name() {
        return r_name;
    }

    public void setR_name(String r_name) {
        this.r_name = r_name;
    }

    public int getR_age() {
        return r_age;
    }

    public void setR_age(int r_age) {
        this.r_age = r_age;
    }

    public String getR_telephone() {
        return r_telephone;
    }

    public void setR_telephone(String r_telephone) {
        this.r_telephone = r_telephone;
    }

    public String getR_post() {
        return r_post;
    }

    public void setR_post(String r_post) {
        this.r_post = r_post;
    }

    public String getR_city() {
        return r_city;
    }

    public void setR_city(String r_city) {
        this.r_city = r_city;
    }

    public String getR_life() {
        return r_life;
    }

    public void setR_life(String r_life) {
        this.r_life = r_life;
    }

    public MultipartFile getR_resume() {
        return r_resume;
    }

    public void setR_resume(MultipartFile r_resume) {
        this.r_resume = r_resume;
    }
}
