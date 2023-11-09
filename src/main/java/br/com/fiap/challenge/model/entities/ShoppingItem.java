package br.com.fiap.challenge.model.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ShoppingItem {

    @JsonProperty("position")
    private Integer position;
    @JsonProperty("title")
    private String title;
    @JsonProperty("link")
    private String link;
    @JsonProperty("product_link")
    private String productLink;
    @JsonProperty("product_id")
    private String productId;
    @JsonProperty("serpapi_product_api")
    private String serpapiProductApi;
    @JsonProperty("number_of_comparisons")
    private String numberOfComparisons;
    @JsonProperty("comparison_link")
    private String comparisonLink;
    @JsonProperty("serpapi_product_api_comparisons")
    private String serpapiProductApiComparisons;
    @JsonProperty("source")
    private String source;
    @JsonProperty("price")
    private String price;
    @JsonProperty("extracted_price")
    private Double extractedPrice;
    @JsonProperty("rating")
    private Double rating;
    @JsonProperty("reviews")
    private Integer reviews;
    @JsonProperty("extensions")
    private String[] extensions;
    @JsonProperty("thumbnail")
    private String thumbnail;
    @JsonProperty("delivery")
    private String delivery;
    @JsonProperty("tag")
    private String tag;
    @JsonProperty("old_price")
    private String oldPrice;
    @JsonProperty("extracted_old_price")
    private Double extractedOldPrice;

    public ShoppingItem() {
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getProductLink() {
        return productLink;
    }

    public void setProductLink(String productLink) {
        this.productLink = productLink;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getSerpapiProductApi() {
        return serpapiProductApi;
    }

    public void setSerpapiProductApi(String serpapiProductApi) {
        this.serpapiProductApi = serpapiProductApi;
    }

    public String getNumberOfComparisons() {
        return numberOfComparisons;
    }

    public void setNumberOfComparisons(String numberOfComparisons) {
        this.numberOfComparisons = numberOfComparisons;
    }

    public String getComparisonLink() {
        return comparisonLink;
    }

    public void setComparisonLink(String comparisonLink) {
        this.comparisonLink = comparisonLink;
    }

    public String getSerpapiProductApiComparisons() {
        return serpapiProductApiComparisons;
    }

    public void setSerpapiProductApiComparisons(String serpapiProductApiComparisons) {
        this.serpapiProductApiComparisons = serpapiProductApiComparisons;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Double getExtractedPrice() {
        return extractedPrice;
    }

    public void setExtractedPrice(Double extractedPrice) {
        this.extractedPrice = extractedPrice;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getReviews() {
        return reviews;
    }

    public void setReviews(Integer reviews) {
        this.reviews = reviews;
    }

    public String[] getExtensions() {
        return extensions;
    }

    public void setExtensions(String[] extensions) {
        this.extensions = extensions;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }


}
