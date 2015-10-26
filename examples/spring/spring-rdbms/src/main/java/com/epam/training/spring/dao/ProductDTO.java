package com.epam.training.spring.dao;

public class ProductDTO {

    private Long id;
    private String longName;
    private String shortName;
    private String category;
    private int netPrice;
    private double vat;
    private String description;
    private String brand;
    private Boolean isChinese;

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the longName
     */
    public String getLongName() {
        return longName;
    }

    /**
     * @param longName the longName to set
     */
    public void setLongName(String longName) {
        this.longName = longName;
    }

    /**
     * @return the shortName
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * @param shortName the shortName to set
     */
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return the netPrice
     */
    public int getNetPrice() {
        return netPrice;
    }

    /**
     * @param netPrice the netPrice to set
     */
    public void setNetPrice(int netPrice) {
        this.netPrice = netPrice;
    }

    /**
     * @return the vat
     */
    public double getVat() {
        return vat;
    }

    /**
     * @param vat the vat to set
     */
    public void setVat(double vat) {
        this.vat = vat;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * @param brand the brand to set
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * @return the isChinese
     */
    public Boolean getIsChinese() {
        return isChinese;
    }

    /**
     * @param isChenese the isChinese to set
     */
    public void setIsChinese(Boolean isChinese) {
        this.isChinese = isChinese;
    }

    @Override
    public String toString() {
        return    "Id:                      " + getId() + "\n"
                + "LongName:                " + getLongName() + "\n"
                + "ShortName:               " + getShortName() + "\n";

    }
    
    @Override
    public boolean equals(Object obj) {
    	
    	if( obj instanceof ProductDTO ) {
    		ProductDTO other = (ProductDTO)obj;
    		
    		return this.id == other.id &&
    			(this.longName != null ? this.longName.equals(other.longName) : other.longName == null) &&
    			(this.shortName != null ? this.shortName.equals(other.shortName): other.shortName == null) &&
    			(this.category != null ? this.category.equals(other.category) : other.category == null) &&
    			this.netPrice == other.netPrice &&
    			this.vat == other.vat &&
    			(this.description != null ? this.description.equals(other.description) : other.description == null) &&
    			(this.brand != null ? this.brand.equals(other.brand) : other.brand == null) &&
    			(this.isChinese != null ? this.isChinese.equals(other.isChinese) : other.isChinese == null)
    		;
    	}
    	
    	return false;
    }
}
