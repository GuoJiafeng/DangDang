package com.baizhi.entity;

import java.util.Date;

/**
 * @Author :Create by Guo Jiafeng
 * @Date : Created in 15:45 2017/9/16
 * @Descripon :
 */
public class Goods {
    private Integer good_id;
    private String good_name;
    private String good_author;
    private String good_press;
    private Date good_publication_time;
    private Integer good_publication_count;
    private Date good_printing_time;
    private Integer good_printing_count;
    private Long good_isbn;
    private Integer good_number_of_words;
    private Integer good_number_of_page;
    private Integer good_folio;
    private String good_paper;
    private String good_package;
    private Double good_price;
    private Double good_dangdang_price;
    private String good_image;
    private String good_editorial_recommendation;
    private Double good_editorial_score;
    private String good_content_validity;
    private String good_author_validityl;
    private String good_catalog;
    private String good_media_review;
    private String good_digest;
    private Integer good_sales_volume;
    private Date good_shelf_time;
    private Integer good_stock;
    private TypeSon typeSon;
    private Long good_click_amount;

    public Goods() {
    }

    public Goods(Integer good_id, String good_name, String good_author, String good_press, Date good_publication_time, Integer good_publication_count, Date good_printing_time, Integer good_printing_count, Long good_isbn, Integer good_number_of_words, Integer good_number_of_page, Integer good_folio, String good_paper, String good_package, Double good_price, Double good_dangdang_price, String good_image, String good_editorial_recommendation, Double good_editorial_score, String good_content_validity, String good_author_validityl, String good_catalog, String good_media_review, String good_digest, Integer good_sales_volume, Date good_shelf_time, Integer good_stock, TypeSon typeSon, Long good_click_amount) {
        this.good_id = good_id;
        this.good_name = good_name;
        this.good_author = good_author;
        this.good_press = good_press;
        this.good_publication_time = good_publication_time;
        this.good_publication_count = good_publication_count;
        this.good_printing_time = good_printing_time;
        this.good_printing_count = good_printing_count;
        this.good_isbn = good_isbn;
        this.good_number_of_words = good_number_of_words;
        this.good_number_of_page = good_number_of_page;
        this.good_folio = good_folio;
        this.good_paper = good_paper;
        this.good_package = good_package;
        this.good_price = good_price;
        this.good_dangdang_price = good_dangdang_price;
        this.good_image = good_image;
        this.good_editorial_recommendation = good_editorial_recommendation;
        this.good_editorial_score = good_editorial_score;
        this.good_content_validity = good_content_validity;
        this.good_author_validityl = good_author_validityl;
        this.good_catalog = good_catalog;
        this.good_media_review = good_media_review;
        this.good_digest = good_digest;
        this.good_sales_volume = good_sales_volume;
        this.good_shelf_time = good_shelf_time;
        this.good_stock = good_stock;
        this.typeSon = typeSon;
        this.good_click_amount = good_click_amount;
    }

    public Integer getGood_id() {
        return good_id;
    }

    public void setGood_id(Integer good_id) {
        this.good_id = good_id;
    }

    public String getGood_name() {
        return good_name;
    }

    public void setGood_name(String good_name) {
        this.good_name = good_name;
    }

    public String getGood_author() {
        return good_author;
    }

    public void setGood_author(String good_author) {
        this.good_author = good_author;
    }

    public String getGood_press() {
        return good_press;
    }

    public void setGood_press(String good_press) {
        this.good_press = good_press;
    }

    public Date getGood_publication_time() {
        return good_publication_time;
    }

    public void setGood_publication_time(Date good_publication_time) {
        this.good_publication_time = good_publication_time;
    }

    public Integer getGood_publication_count() {
        return good_publication_count;
    }

    public void setGood_publication_count(Integer good_publication_count) {
        this.good_publication_count = good_publication_count;
    }

    public Date getGood_printing_time() {
        return good_printing_time;
    }

    public void setGood_printing_time(Date good_printing_time) {
        this.good_printing_time = good_printing_time;
    }

    public Integer getGood_printing_count() {
        return good_printing_count;
    }

    public void setGood_printing_count(Integer good_printing_count) {
        this.good_printing_count = good_printing_count;
    }

    public Long getGood_isbn() {
        return good_isbn;
    }

    public void setGood_isbn(Long good_isbn) {
        this.good_isbn = good_isbn;
    }

    public Integer getGood_number_of_words() {
        return good_number_of_words;
    }

    public void setGood_number_of_words(Integer good_number_of_words) {
        this.good_number_of_words = good_number_of_words;
    }

    public Integer getGood_number_of_page() {
        return good_number_of_page;
    }

    public void setGood_number_of_page(Integer good_number_of_page) {
        this.good_number_of_page = good_number_of_page;
    }

    public Integer getGood_folio() {
        return good_folio;
    }

    public void setGood_folio(Integer good_folio) {
        this.good_folio = good_folio;
    }

    public String getGood_paper() {
        return good_paper;
    }

    public void setGood_paper(String good_paper) {
        this.good_paper = good_paper;
    }

    public String getGood_package() {
        return good_package;
    }

    public void setGood_package(String good_package) {
        this.good_package = good_package;
    }

    public Double getGood_price() {
        return good_price;
    }

    public void setGood_price(Double good_price) {
        this.good_price = good_price;
    }

    public Double getGood_dangdang_price() {
        return good_dangdang_price;
    }

    public void setGood_dangdang_price(Double good_dangdang_price) {
        this.good_dangdang_price = good_dangdang_price;
    }

    public String getGood_image() {
        return good_image;
    }

    public void setGood_image(String good_image) {
        this.good_image = good_image;
    }

    public String getGood_editorial_recommendation() {
        return good_editorial_recommendation;
    }

    public void setGood_editorial_recommendation(String good_editorial_recommendation) {
        this.good_editorial_recommendation = good_editorial_recommendation;
    }

    public Double getGood_editorial_score() {
        return good_editorial_score;
    }

    public void setGood_editorial_score(Double good_editorial_score) {
        this.good_editorial_score = good_editorial_score;
    }

    public String getGood_content_validity() {
        return good_content_validity;
    }

    public void setGood_content_validity(String good_content_validity) {
        this.good_content_validity = good_content_validity;
    }

    public String getGood_author_validityl() {
        return good_author_validityl;
    }

    public void setGood_author_validityl(String good_author_validityl) {
        this.good_author_validityl = good_author_validityl;
    }

    public String getGood_catalog() {
        return good_catalog;
    }

    public void setGood_catalog(String good_catalog) {
        this.good_catalog = good_catalog;
    }

    public String getGood_media_review() {
        return good_media_review;
    }

    public void setGood_media_review(String good_media_review) {
        this.good_media_review = good_media_review;
    }

     public String getGood_digest() {
        return good_digest;
    }

    public void setGood_digest(String good_digest) {
        this.good_digest = good_digest;
    }

    public Integer getGood_sales_volume() {
        return good_sales_volume;
    }

    public void setGood_sales_volume(Integer good_sales_volume) {
        this.good_sales_volume = good_sales_volume;
    }

    public Date getGood_shelf_time() {
        return good_shelf_time;
    }

    public void setGood_shelf_time(Date good_shelf_time) {
        this.good_shelf_time = good_shelf_time;
    }

    public Integer getGood_stock() {
        return good_stock;
    }

    public void setGood_stock(Integer good_stock) {
        this.good_stock = good_stock;
    }

    public TypeSon getTypeSon() {
        return typeSon;
    }

    public void setTypeSon(TypeSon typeSon) {
        this.typeSon = typeSon;
    }

    public Long getGood_click_amount() {
        return good_click_amount;
    }

    public void setGood_click_amount(Long good_click_amount) {
        this.good_click_amount = good_click_amount;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "good_id=" + good_id +
                ", good_name='" + good_name + '\'' +
                ", good_author='" + good_author + '\'' +
                ", good_press='" + good_press + '\'' +
                ", good_publication_time=" + good_publication_time +
                ", good_publication_count=" + good_publication_count +
                ", good_printing_time=" + good_printing_time +
                ", good_printing_count=" + good_printing_count +
                ", good_isbn=" + good_isbn +
                ", good_number_of_words=" + good_number_of_words +
                ", good_number_of_page=" + good_number_of_page +
                ", good_folio=" + good_folio +
                ", good_paper='" + good_paper + '\'' +
                ", good_package='" + good_package + '\'' +
                ", good_price=" + good_price +
                ", good_dangdang_price=" + good_dangdang_price +
                ", good_image='" + good_image + '\'' +
                ", good_editorial_recommendation='" + good_editorial_recommendation + '\'' +
                ", good_editorial_score=" + good_editorial_score +
                ", good_content_validity='" + good_content_validity + '\'' +
                ", good_author_validityl='" + good_author_validityl + '\'' +
                ", good_catalog='" + good_catalog + '\'' +
                ", good_media_review='" + good_media_review + '\'' +
                ", good_digest='" + good_digest + '\'' +
                ", good_sales_volume=" + good_sales_volume +
                ", good_shelf_time=" + good_shelf_time +
                ", good_stock=" + good_stock +
                ", typeSon=" + typeSon +
                ", good_click_amount=" + good_click_amount +
                '}';
    }
}
