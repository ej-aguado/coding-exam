package stepDefinitions;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.RestAssured.get;

public class StepDefinitions {

    private static final String URL = "https://api.tmsandbox.co.nz/v1/Categories/6329/Details.json?catalogue=false";
    private static Response response;
    private static JsonPath jsonPathEvaluator;

    @ParameterType(value = "true|True|false|False")
    public Boolean booleanValue(String value) {
        return Boolean.valueOf(value);
    }

    @Given("I have a category with an ID of {int}")
    public void i_have_a_category_with_an_ID_of(Integer categoryId) {
        response = get(URL);
        jsonPathEvaluator = response.jsonPath();
        categoryId = jsonPathEvaluator.get("CategoryId");
    }

    @When("I query for the details of {int}")
    public void i_query_for_its_details_of(Integer categoryId) {
        response = get(URL);
        jsonPathEvaluator = response.jsonPath();
        Integer categoryIdActual = jsonPathEvaluator.get("CategoryId");
        Assert.assertEquals(categoryId, categoryIdActual);
    }

    @Then("I should see the category {string}")
    public void i_should_see_the_category(String categoryName) {
        response = get(URL);
        jsonPathEvaluator = response.jsonPath();
        String categoryNameActual = jsonPathEvaluator.get("Name");
        Assert.assertEquals(categoryName, categoryNameActual);
    }

    @Then("the category canRelist status is {booleanValue}")
    public void the_category_canRelist_status_is_true(boolean canRelistStatus) {
        response = get(URL);
        jsonPathEvaluator = response.jsonPath();
        boolean canRelistStatusActual = jsonPathEvaluator.get("CanRelist");
        Assert.assertEquals(canRelistStatus, canRelistStatusActual);
    }

    @Then("the category should have a promotions name of {word} with text description of {string}")
    public void the_category_should_have_a_promotions_name_of_Feature_with_text_description_of_Better_position_in_category(String promotionName, String promotionDesc) {
        response = get(URL);
        jsonPathEvaluator = response.jsonPath();
        String promotionNameActual = jsonPathEvaluator.get("Promotions[2].Name");
        String promotionDescActual = jsonPathEvaluator.get("Promotions[2].Description");
        Assert.assertEquals(promotionName, promotionNameActual);
        Assert.assertEquals(promotionDesc, promotionDescActual);
    }


}

