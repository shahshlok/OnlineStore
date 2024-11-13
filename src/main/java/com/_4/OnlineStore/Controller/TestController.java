package com._4.OnlineStore.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/test")
    public String testConnection(Model model) {
        try {
            // Test basic connection
            String result = jdbcTemplate.queryForObject(
                    "SELECT 'Connection Successful' as result", String.class);
            model.addAttribute("message", result);

            // Get table structure
            String tableInfo = getTableStructure();
            model.addAttribute("tableStructure", tableInfo);

        } catch (Exception e) {
            model.addAttribute("message", "Connection Failed: " + e.getMessage());
        }
        return "test";
    }

    private String getTableStructure() {
        StringBuilder structure = new StringBuilder();
        try {
            // Get column information for the product table
            var columns = jdbcTemplate.queryForList(
                    "SELECT COLUMN_NAME, DATA_TYPE, IS_NULLABLE " +
                            "FROM INFORMATION_SCHEMA.COLUMNS " +
                            "WHERE TABLE_NAME = 'product' AND TABLE_SCHEMA = 'dbo' " +
                            "ORDER BY ORDINAL_POSITION"
            );

            structure.append("\n\nProduct Table Structure:\n");
            for (var column : columns) {
                structure.append(String.format("Column: %s, Type: %s, Nullable: %s\n",
                        column.get("COLUMN_NAME"),
                        column.get("DATA_TYPE"),
                        column.get("IS_NULLABLE")));
            }

        } catch (Exception e) {
            structure.append("Error getting table structure: ").append(e.getMessage());
        }
        return structure.toString();
    }
}