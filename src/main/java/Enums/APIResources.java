package Enums;

public enum APIResources {
    CREATEPRODUCT("/products"),
    GETPRODUCTBYID("/products");

    private String url;
    APIResources(String url){
        this.url=url;
    }

    public String getURL(){
        return url;
    }
}
