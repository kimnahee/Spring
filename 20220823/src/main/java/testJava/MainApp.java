package testJava;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		AbstractApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		
		LgTV tv = (LgTV) context.getBean("LgTV");//<-> setBean
		tv.getTv().powerOff();
		
	}

}
