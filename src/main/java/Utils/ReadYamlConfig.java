package Utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

public class ReadYamlConfig {
	
	public static Map<String,String> Yamlconfig=new HashMap<String,String>();
	public static Yaml yamlfile=new Yaml();
	public static InputStream qa_input;

	
	public static Map<String,String> Readyaml(){
//		String environment =System.getProperty("env");
		try {
//			if(environment.equalsIgnoreCase("qa-staging")) {

//			}
			InputStream test=new FileInputStream(System.getProperty("user.dir")+"/testInputs/QA_Staging.yaml");
			Yamlconfig=yamlfile.load(test);
			
		}catch(Exception e) {}
		
		return Yamlconfig;

	}
	public static Map<String,String> getConfig(){
		if(Yamlconfig==null) {
			Yamlconfig=Readyaml();
		}
		return Yamlconfig;
		
		
	}

		
}

