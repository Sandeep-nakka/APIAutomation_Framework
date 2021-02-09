package builders;

import endpoints.Endpoints;
import io.restassured.RestAssured;
import io.restassured.authentication.AuthenticationScheme;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.given;

import Utils.ReadYamlConfig;


public class GitBuilder{
	RequestSpecification reqSpec;
	ResponseSpecification resSpec;
	public void BaseSetup() {
		
		reqSpec = BaseBuilder.getRequestSpecification();		
		resSpec = BaseBuilder.getResponseSpecification();
	}
	
	public void AdminLogin() {
		BaseSetup();
		BaseBuilder.setEndPoint(Endpoints.ADMIN_LOGIN);
		reqSpec.basePath(Endpoints.BASE_PATH);
	
		//Header Authorization = new Header("Authorization", "Bearer eyJ1c2VyTmFtZSI6ImFkbWluIiwicGFzc3dvcmQiOiJwYXNzIn0=");
		//reqSpec.header(Authorization);
		reqSpec.header("Authorization","Bearer eyJ1c2VyTmFtZSI6ImFkbWluIiwicGFzc3dvcmQiOiJwYXNzIn0=");
		reqSpec.contentType(ContentType.JSON);
//		reqSpec.accept("application/json,text/plain,*/*");		
		reqSpec.body("{}");
		reqSpec.log().all();
		Response res = BaseBuilder.getResponse(reqSpec,"post");
		System.out.println(res.asString());
		
		
	}
	public void TestLogin() {
		Response res=given().
		header("Authorization","Bearer eyJ1c2VyTmFtZSI6ImFkbWluIiwicGFzc3dvcmQiOiJwYXNzIn0=").contentType(ContentType.JSON).
		body("{}").when().post("https://admin.qa-staging.discovery.xpms.ai/api/auth");
		System.out.println(res.asString());
		JsonPath jsPath = BaseBuilder.getJsonPath(res);
		System.out.println(jsPath.get("data.token"));
		ReadYamlConfig.Yamlconfig.put("token", (String) jsPath.get("data.token"));		
				
	}

	


}
