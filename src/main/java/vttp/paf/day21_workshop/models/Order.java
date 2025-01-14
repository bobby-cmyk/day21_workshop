package vttp.paf.day21_workshop.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import jakarta.json.JsonValue;


public class Order {
    private Integer id;
    private Integer employeeId;
    private Integer customerId; 
    private LocalDateTime orderDate;
    private LocalDateTime shippedDate;
    private Integer shipperId;
    private String shipName;
    private String shipAddress;
    private String shipCity;
    private String shipStateProvince;
    private String shipZipPostalCode;
    private String shipCoutryRegion;
    private Double shippingFee;
    private Double taxes;
    private String paymentType;
    private LocalDateTime paidDate;
    private String notes;
    private Double taxRate;
    private Integer taxStatusId;
    private Integer statusId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDateTime getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(LocalDateTime shippedDate) {
        this.shippedDate = shippedDate;
    }

    public Integer getShipperId() {
        return shipperId;
    }

    public void setShipperId(Integer shipperId) {
        this.shipperId = shipperId;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    public String getShipCity() {
        return shipCity;
    }

    public void setShipCity(String shipCity) {
        this.shipCity = shipCity;
    }

    public String getShipStateProvince() {
        return shipStateProvince;
    }

    public void setShipStateProvince(String shipStateProvince) {
        this.shipStateProvince = shipStateProvince;
    }

    public String getShipZipPostalCode() {
        return shipZipPostalCode;
    }

    public void setShipZipPostalCode(String shipZipPostalCode) {
        this.shipZipPostalCode = shipZipPostalCode;
    }

    public String getShipCoutryRegion() {
        return shipCoutryRegion;
    }

    public void setShipCoutryRegion(String shipCoutryRegion) {
        this.shipCoutryRegion = shipCoutryRegion;
    }

    public Double getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(Double shippingFee) {
        this.shippingFee = shippingFee;
    }

    public Double getTaxes() {
        return taxes;
    }

    public void setTaxes(Double taxes) {
        this.taxes = taxes;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public LocalDateTime getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(LocalDateTime paidDate) {
        this.paidDate = paidDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Double taxRate) {
        this.taxRate = taxRate;
    }

    public Integer getTaxStatusId() {
        return taxStatusId;
    }

    public void setTaxStatusId(Integer taxStatusId) {
        this.taxStatusId = taxStatusId;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public static Order toOrder(SqlRowSet rs) {
        Order o = new Order();

        o.setId(rs.getInt("id"));
        o.setEmployeeId(rs.getInt("employee_id"));
        o.setCustomerId(rs.getInt("customer_id"));
        o.setShipperId(rs.getInt("shipper_id"));
        o.setShipName(rs.getString("ship_name"));
        o.setShipAddress(rs.getString("ship_address"));
        o.setShipCity(rs.getString("ship_city"));
        o.setShipStateProvince(rs.getString("ship_state_province"));
        o.setShipZipPostalCode(rs.getString("ship_zip_postal_code"));
        o.setShipCoutryRegion(rs.getString("ship_country_region"));
        o.setShippingFee(rs.getDouble("shipping_fee"));
        o.setTaxes(rs.getDouble("taxes"));
        o.setPaymentType(rs.getString("payment_type"));
        o.setNotes(rs.getString("notes"));
        o.setTaxRate(rs.getDouble("tax_rate"));
        o.setTaxStatusId(rs.getInt("tax_status_id"));
        o.setStatusId(rs.getInt("status_id"));

        DateTimeFormatter fmt = new DateTimeFormatterBuilder()
            .appendPattern("yyyy-MM-dd'T'HH:mm")
            .optionalStart()
            .appendPattern(":ss")
            .optionalEnd()
            .toFormatter();
        
        String orderDateStr = rs.getString("order_date");
        if (orderDateStr != null) {
            o.setOrderDate(LocalDateTime.parse(orderDateStr, fmt));
        } else {
            o.setOrderDate(null);
        }

        String shippedDateStr = rs.getString("shipped_date");
        if (shippedDateStr != null) {
            o.setShippedDate(LocalDateTime.parse(shippedDateStr, fmt));
        } else {
            o.setShippedDate(null);
        }

        String paidDateStr = rs.getString("paid_date");
        if (paidDateStr != null) {
            o.setPaidDate(LocalDateTime.parse(paidDateStr, fmt));
        } else {
            o.setPaidDate(null);
        }

        return o;
    }

    public JsonObject toJsonObject() {
        JsonObjectBuilder objBuilder = Json.createObjectBuilder();

        // Integer fields: use if/else or createValue(...) to handle null
        if (id != null) {
            objBuilder.add("id", id);
        } else {
            objBuilder.add("id", JsonValue.NULL);
        }

        if (employeeId != null) {
            objBuilder.add("employee_id", employeeId);
        } else {
            objBuilder.add("employee_id", JsonValue.NULL);
        }

        if (customerId != null) {
            objBuilder.add("customer_id", customerId);
        } else {
            objBuilder.add("customer_id", JsonValue.NULL);
        }

        if (shipperId != null) {
            objBuilder.add("shipper_id", shipperId);
        } else {
            objBuilder.add("shipper_id", JsonValue.NULL);
        }

        if (shippingFee != null) {
            objBuilder.add("shipping_fee", shippingFee);
        } else {
            objBuilder.add("shipping_fee", JsonValue.NULL);
        }

        if (taxes != null) {
            objBuilder.add("taxes", taxes);
        } else {
            objBuilder.add("taxes", JsonValue.NULL);
        }

        if (taxRate != null) {
            objBuilder.add("tax_rate", taxRate);
        } else {
            objBuilder.add("tax_rate", JsonValue.NULL);
        }

        if (taxStatusId != null) {
            objBuilder.add("tax_status_id", taxStatusId);
        } else {
            objBuilder.add("tax_status_id", JsonValue.NULL);
        }

        if (statusId != null) {
            objBuilder.add("status_id", statusId);
        } else {
            objBuilder.add("status_id", JsonValue.NULL);
        }

        // String fields
        objBuilder.add("ship_name",
            (shipName != null) ? Json.createValue(shipName) : JsonValue.NULL);

        objBuilder.add("ship_address",
            (shipAddress != null) ? Json.createValue(shipAddress) : JsonValue.NULL);

        objBuilder.add("ship_city",
            (shipCity != null) ? Json.createValue(shipCity) : JsonValue.NULL);

        objBuilder.add("ship_state_province",
            (shipStateProvince != null) ? Json.createValue(shipStateProvince) : JsonValue.NULL);

        objBuilder.add("ship_zip_postal_code",
            (shipZipPostalCode != null) ? Json.createValue(shipZipPostalCode) : JsonValue.NULL);

        objBuilder.add("ship_country_region",
            (shipCoutryRegion != null) ? Json.createValue(shipCoutryRegion) : JsonValue.NULL);

        objBuilder.add("payment_type",
            (paymentType != null) ? Json.createValue(paymentType) : JsonValue.NULL);

        objBuilder.add("notes",
            (notes != null) ? Json.createValue(notes) : JsonValue.NULL);

        // Date/time fields: convert LocalDateTime to string if not null
        objBuilder.add("order_date",
            (orderDate != null) ? Json.createValue(orderDate.toString()) : JsonValue.NULL);

        objBuilder.add("shipped_date",
            (shippedDate != null) ? Json.createValue(shippedDate.toString()) : JsonValue.NULL);

        objBuilder.add("paid_date",
            (paidDate != null) ? Json.createValue(paidDate.toString()) : JsonValue.NULL);

        return objBuilder.build();
    }

}
