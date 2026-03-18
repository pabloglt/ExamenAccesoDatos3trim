package com.example.examen3accesodatos.config;



import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(
        prefix = "item"
)
public class ItemConfig {
    private Integer stockMinimo;

    public Integer getStockMinimo() {
        return this.stockMinimo;
    }

    public void setStockMinimo(Integer stockMinimo) {
        this.stockMinimo = stockMinimo;
    }
}