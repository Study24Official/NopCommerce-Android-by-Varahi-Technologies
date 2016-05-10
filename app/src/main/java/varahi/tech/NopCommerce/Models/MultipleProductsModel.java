package varahi.tech.NopCommerce.Models;

import java.util.ArrayList;

/**
 * Created by prati on 04-May-16.
 */
public class MultipleProductsModel {

    String productCatagory;
    private ArrayList<SingleProductShortModel> allProductsInCatagory;

    public String getProductCatagory() {
        return productCatagory;
    }

    public void setProductCatagory(String productCatagory) {
        this.productCatagory = productCatagory;
    }

    public ArrayList<SingleProductShortModel> getAllProductsInCatagory() {
        return allProductsInCatagory;
    }

    public void setAllProductsInCatagory(ArrayList<SingleProductShortModel> allProductsInCatagory) {
        this.allProductsInCatagory = allProductsInCatagory;
    }
}
