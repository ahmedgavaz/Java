package com.example.json_processing_exercise.entities.dto;

import java.math.BigDecimal;

public class CategoryTotalProductsDTO {
    private String categoryName;
    private Long productCount;
    private Double averagePrice;
    private BigDecimal totalRevenue;

    public CategoryTotalProductsDTO() {
    }

    public CategoryTotalProductsDTO(String category, long productCount, double averagePrice, BigDecimal totalRevenue) {
        this.categoryName = category;
        this.productCount = productCount;
        this.averagePrice = averagePrice;
        this.totalRevenue = totalRevenue;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public long getProductCount() {
        return productCount;
    }

    public void setProductCount(long productCount) {
        this.productCount = productCount;
    }

    public double getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(double averagePrice) {
        this.averagePrice = averagePrice;
    }

    public BigDecimal getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(BigDecimal totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
}
