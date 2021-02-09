package ExponentialAI.API_Automation;

import org.testng.annotations.Test;
import org.testng.Assert;


import Utils.ReadYamlConfig;
import builders.GitBuilder;


/**
 * Unit test for simple App.
 */
public class AppTest {
	/**
	 * Rigorous Test :-)
	 */
	@Test
	public void shouldAnswerWithTrue() {
		ReadYamlConfig.Readyaml();
		System.out.println(ReadYamlConfig.Yamlconfig);
		System.out.println(ReadYamlConfig.Yamlconfig.get("API_GATEWAY_URL"));
		Assert.assertTrue(10<12);
		GitBuilder git=new GitBuilder();
		git.TestLogin();
	}
}
