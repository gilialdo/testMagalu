package br.com.magalutest.api.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


//@Entity
//@Table(name = "produto")
public class Produto {

    @Column(name="price")
    private Double price;

    @Column(name="image")
    private String image;

    @Column(name="brand")
    private String brand;

    @Column(name="id")
    private String id;

    @Column(name="title")
    private String title;

    @Column(name="reviewscore")
    private String reviewScore;

    public Produto() {
    }

    public Produto( 
        Double price, 
        String image, 
        String brand, 
        String id, 
        String title, 
        String reviewScore) {

        this.price = price;
        this.image = image;
        this.brand = brand;
        this.id = id;
        this.title = title;
        this.reviewScore = reviewScore;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return this.image;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setReviewScore(String reviewScore) {
        this.reviewScore = reviewScore;
    }

    public String getReviewScore() {
        return this.reviewScore;
    }

    public static Produto jsonToProduto(String json) {
    	Produto data = null;
    	try {
    		data = new Gson().fromJson(json, Produto.class);	
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	return data;
    }
    
    public static List<Produto> jsonToListProduto(String jsonStr) {
    	List<Produto> data = null;
    	try {
    		JsonParser parser = new JsonParser();
    		JsonObject json = (JsonObject) parser.parse(jsonStr);
    		ObjectMapper mapper = new ObjectMapper();
    		data = mapper.readValue(json.get("products").toString(), new TypeReference<List<Produto>>(){});
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return data;
    }
    
}
