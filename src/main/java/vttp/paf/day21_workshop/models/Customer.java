package vttp.paf.day21_workshop.models;

import java.util.Arrays;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import jakarta.json.JsonValue;

import java.util.Base64;

public class Customer {
    private Integer id;
    private String company;
    private String lastName;
    private String firstName;
    private String emailAddress;
    private String jobTitle;
    private String businessPhone;
    private String homePhone;
    private String mobilePhone;
    private String faxNumber;
    private String address;
    private String city;
    private String stateProvince;
    private String zipPostalCode;
    private String countryRegion;
    private String webPage;
    private String notes;
    private byte[] attachments;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getEmailAddress() {
        return emailAddress;
    }
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    public String getJobTitle() {
        return jobTitle;
    }
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
    public String getBusinessPhone() {
        return businessPhone;
    }
    public void setBusinessPhone(String businessPhone) {
        this.businessPhone = businessPhone;
    }
    public String getHomePhone() {
        return homePhone;
    }
    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }
    public String getMobilePhone() {
        return mobilePhone;
    }
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }
    public String getFaxNumber() {
        return faxNumber;
    }
    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getStateProvince() {
        return stateProvince;
    }
    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }
    public String getZipPostalCode() {
        return zipPostalCode;
    }
    public void setZipPostalCode(String zipPostalCode) {
        this.zipPostalCode = zipPostalCode;
    }
    public String getCountryRegion() {
        return countryRegion;
    }
    public void setCountryRegion(String countryRegion) {
        this.countryRegion = countryRegion;
    }
    public String getWebPage() {
        return webPage;
    }
    public void setWebPage(String webPage) {
        this.webPage = webPage;
    }
    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
    public byte[] getAttachments() {
        return attachments;
    }
    public void setAttachments(byte[] attachments) {
        this.attachments = attachments;
    }

    @Override
    public String toString() {
        return "Customer [id=" + id + ", company=" + company + ", lastName=" + lastName + ", firstName=" + firstName
                + ", emailAddress=" + emailAddress + ", jobTitle=" + jobTitle + ", businessPhone=" + businessPhone
                + ", homePhone=" + homePhone + ", mobilePhone=" + mobilePhone + ", faxNumber=" + faxNumber
                + ", address=" + address + ", city=" + city + ", stateProvince=" + stateProvince + ", zipPostalCode="
                + zipPostalCode + ", countryRegion=" + countryRegion + ", webPage=" + webPage + ", notes=" + notes
                + ", attachments=" + Arrays.toString(attachments) + "]";
    }

    public static Customer toCustomer(SqlRowSet rs) {
        Customer c = new Customer();
        c.setId(rs.getInt("id"));
        c.setLastName(rs.getString("last_name"));
        c.setFirstName(rs.getString("first_name"));
        c.setEmailAddress(rs.getString("email_address"));
        c.setJobTitle(rs.getString("job_title"));
        c.setBusinessPhone(rs.getString("business_phone"));
        c.setHomePhone(rs.getString("home_phone"));
        c.setFaxNumber(rs.getString("fax_number"));
        c.setAddress(rs.getString("address"));
        c.setCity(rs.getString("city"));
        c.setStateProvince(rs.getString("state_province"));
        c.setZipPostalCode(rs.getString("zip_postal_code"));
        c.setCountryRegion(rs.getString("country_region"));
        c.setWebPage(rs.getString("web_page"));
        c.setNotes(rs.getString("notes"));
        c.setAttachments((byte[]) rs.getObject("attachments"));

        return c;
    }

    public JsonObject toJsonObject() {
        JsonObjectBuilder objBuilder = Json.createObjectBuilder();
    
        objBuilder.add("id", id);
        objBuilder.add("last_name", lastName != null ? Json.createValue(lastName) : JsonValue.NULL);
        objBuilder.add("first_name", firstName != null ? Json.createValue(firstName) : JsonValue.NULL);
        objBuilder.add("email_address", emailAddress != null ? Json.createValue(emailAddress) : JsonValue.NULL);
        objBuilder.add("job_title", jobTitle != null ? Json.createValue(jobTitle) : JsonValue.NULL);
        objBuilder.add("business_phone", businessPhone != null ? Json.createValue(businessPhone) : JsonValue.NULL);
        objBuilder.add("mobile_phone", mobilePhone != null ? Json.createValue(mobilePhone) : JsonValue.NULL);
        objBuilder.add("fax_number", faxNumber != null ? Json.createValue(faxNumber) : JsonValue.NULL);
        objBuilder.add("address", address != null ? Json.createValue(address) : JsonValue.NULL);
        objBuilder.add("city", city != null ? Json.createValue(city) : JsonValue.NULL);
        objBuilder.add("state_province", stateProvince != null ? Json.createValue(stateProvince) : JsonValue.NULL);
        objBuilder.add("zip_postal_code", zipPostalCode != null ? Json.createValue(zipPostalCode) : JsonValue.NULL);
        objBuilder.add("country_region", countryRegion != null ? Json.createValue(countryRegion) : JsonValue.NULL);
        objBuilder.add("web_page", webPage != null ? Json.createValue(webPage) : JsonValue.NULL);
        objBuilder.add("notes", notes != null ? Json.createValue(notes) : JsonValue.NULL);
    
        // Convert byte[] to Base64 if attachments is not null
        if (attachments != null) {
            String encodedAttachments = Base64.getEncoder().encodeToString(attachments);
            objBuilder.add("attachments", encodedAttachments);
        } else {
            objBuilder.add("attachments", JsonValue.NULL);
        }
    
        return objBuilder.build();
    }
    
}
