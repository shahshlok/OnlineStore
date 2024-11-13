package com._4.OnlineStore.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class TestDbController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/test-db")
    public String testDb() {
        StringBuilder result = new StringBuilder();

        try {
            // Test 1: Check if we can connect and get database name
            String dbName = jdbcTemplate.queryForObject(
                    "SELECT DB_NAME()", String.class);
            result.append("Connected to database: ").append(dbName).append("\n\n");

            // Test 2: List all tables in the dbo schema
            List<String> tables = jdbcTemplate.queryForList(
                    "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'dbo'",
                    String.class
            );
            result.append("Tables in database:\n");
            tables.forEach(table -> result.append("- ").append(table).append("\n"));
            result.append("\n");

            // Test 3: Show product table structure
            List<Map<String, Object>> columns = jdbcTemplate.queryForList(
                    "SELECT COLUMN_NAME, DATA_TYPE, IS_NULLABLE " +
                            "FROM INFORMATION_SCHEMA.COLUMNS " +
                            "WHERE TABLE_NAME = 'product' AND TABLE_SCHEMA = 'dbo' " +
                            "ORDER BY ORDINAL_POSITION"
            );

            result.append("Product table structure:\n");
            columns.forEach(column -> {
                result.append("- ")
                        .append(column.get("COLUMN_NAME"))
                        .append(" (")
                        .append(column.get("DATA_TYPE"))
                        .append(", ")
                        .append(column.get("IS_NULLABLE"))
                        .append(")\n");
            });
            result.append("\n");

            // Test 4: Count products
            Integer productCount = jdbcTemplate.queryForObject(
                    "SELECT COUNT(*) FROM dbo.product", Integer.class);
            result.append("Number of products: ").append(productCount);

            return result.toString();

        } catch (Exception e) {
            return "Database Error: " + e.getMessage() + "\n" +
                    "Stack trace: " + e.getStackTrace()[0];
        }
    }

    @GetMapping("/test-product")
    public String testProduct() {
        try {
            List<Map<String, Object>> products = jdbcTemplate.queryForList(
                    "SELECT TOP 5 * FROM dbo.product"
            );

            StringBuilder result = new StringBuilder("First 5 products:\n");

            for (Map<String, Object> product : products) {
                result.append("\nProduct ID: ").append(product.get("productId"))
                        .append("\nName: ").append(product.get("productName"))
                        .append("\nPrice: ").append(product.get("productPrice"))
                        .append("\n-----------------");
            }

            return result.toString();

        } catch (Exception e) {
            return "Error fetching products: " + e.getMessage();
        }
    }
}