package stepDefs;

import Enums.APIResources;
import POJO.CreateProduct;
import Testdata.CreateData;
import Utils.BaseSetUp;
import Utils.Utils;
import io.cucumber.java.en.*;
import io.cucumber.junit.Cucumber;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.runner.RunWith;
import io.restassured.*;
import static io.restassured.RestAssured.*;

@RunWith(Cucumber.class)
public class stepdefs extends BaseSetUp {
    RequestSpecification reqspec;
    CreateData cdata;
    CreateProduct cp;
    Response res;
    RequestSpecification req;
    APIResources api;
    Response resp;
    String id;
    @Given("^User already has API to Add Product$")
    public void user_already_has_api_to_add_product() throws Throwable {
         reqspec = baseSetUp();
         cdata= new CreateData();
    }

    @When("^User Hits \"([^\"]*)\" API with \"([^\"]*)\" request$")
    public void user_hits_something_api_with_something_request(String API, String method) throws Throwable {
         api = APIResources.valueOf(API);
        System.out.println(api.getURL());
        if(method.equalsIgnoreCase("GET")){
            req= given().spec(reqspec).pathParam("ID",id);

        } else if (method.equalsIgnoreCase("POST")) {
             req = given().spec(reqspec).body(cp);

        } else if (method.equalsIgnoreCase("PUT")) {

        }
        else{

        }
    }

    @Then("^User creates testdata with \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void user_creates_testdata_with_something_something_something(String name, String type, String price) throws Throwable {
       cp=cdata.setTestData(name,type,Integer.parseInt(price));
    }

    @Then("^the status code received by the User is \"([^\"]*)\"$")
    public void the_status_code_received_by_the_user_is_something(String code) throws Throwable {
        resp = req.when().post(api.getURL());
        Assert.assertEquals(resp.getStatusCode(),Integer.parseInt(code));
    }

    @When("^User Hits \"([^\"]*)\" with the id$")
    public void user_hits_something_with_the_id(String url) throws Throwable {
         id = Utils.getJSONStringValue(resp, "id");
         System.out.println("id is "+id);
        user_hits_something_api_with_something_request(url,"GET");
        resp = req.when().get(api.getURL()+"/{ID}");
    }

    @Then("^the details received in response are equal to \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void the_details_received_in_response_are_equal_to_something_something_something(String name, String type, String price) throws Throwable {
        Assert.assertEquals(Utils.getJSONStringValue(resp,"name"),name);
        Assert.assertEquals(Utils.getJSONStringValue(resp,"type"),type);
        Assert.assertEquals(Utils.getJSONStringValue(resp,"price"),price);
    }



}
