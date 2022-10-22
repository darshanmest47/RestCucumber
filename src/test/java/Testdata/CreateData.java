package Testdata;

import POJO.CreateProduct;
import Utils.RandomGenerator;

public class CreateData {

    public CreateProduct setTestData(String name, String type, int price){
        CreateProduct cp = new CreateProduct();
        RandomGenerator rg = new RandomGenerator();
        cp.setName(name);
        cp.setType(type);
        cp.setPrice(price);
        cp.setShipping(rg.getShippingData());
        cp.setUpc(rg.getUPCData());
        cp.setDescription(rg.getDescription());
        cp.setManufacturer(rg.getManufacturer());
        cp.setModel(rg.getModel());
        cp.setUrl(rg.getURL());
        cp.setImage(rg.getImage());

        return cp;


    }
}
