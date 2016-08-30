package shopper;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext("beans.xml");
		
		Person person1 = (Person)context.getBean("person");
		person1.speak();
		
		((FileSystemXmlApplicationContext)context).close();

	}

}
