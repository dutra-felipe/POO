package com.example.demo;

public class Product {
    private Long id;
    private String type;
    private String description;
    private double weight;
    private int quantity;
    private MeasurementUnit unit;

    public enum MeasurementUnit {
        METER, SQUARE_METER, LITER, KG
    }

    public Product(String type, String description, double weight, int quantity, MeasurementUnit unit) {
        this.type = type;
        this.description = description;
        this.weight = weight;
        this.quantity = quantity;
        this.unit = unit;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public MeasurementUnit getUnit() { return unit; }
    public void setUnit(MeasurementUnit unit) { this.unit = unit; }

    @Override
    public String toString() {
        return String.format("Product[id=%d, type='%s', description='%s', weight=%.2f, quantity=%d, unit=%s]",
            id, type, description, weight, quantity, unit);
    }
}
