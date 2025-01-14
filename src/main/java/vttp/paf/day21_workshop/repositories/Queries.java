package vttp.paf.day21_workshop.repositories;

public class Queries {
    
    public static final String SQL_GET_CUSTOMERS = """
        SELECT * FROM customers 
        LIMIT ?
        OFFSET ?
    """;

    public static final String SQL_GET_CUSTOMER_BY_ID = """
        SELECT * FROM customers
        WHERE id = ?      
    """;
}