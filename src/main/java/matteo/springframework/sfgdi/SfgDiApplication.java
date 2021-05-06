package matteo.springframework.sfgdi;

import matteo.springframework.sfgdi.controllers.ConstructorInjectionController;
import matteo.springframework.sfgdi.controllers.MyController;
import matteo.springframework.sfgdi.controllers.PropertyInjectionController;
import matteo.springframework.sfgdi.controllers.SetterInjectionController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SfgDiApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(SfgDiApplication.class, args);
		MyController myController = (MyController) context.getBean("myController");
		String greeting = myController.sayHello();
		System.out.println(greeting);

		System.out.println("------ Property");
		PropertyInjectionController propertyInjectionController = (PropertyInjectionController) context.getBean("propertyInjectionController");
		System.out.println(propertyInjectionController.getGreeting());

		System.out.println("------ Setter");
		SetterInjectionController setterInjectionController = (SetterInjectionController) context.getBean("setterInjectionController");
		System.out.println(setterInjectionController.getGreeting());

		System.out.println("------ Constructor");
		ConstructorInjectionController constructorInjectionController = (ConstructorInjectionController) context.getBean("constructorInjectionController");
		System.out.println(constructorInjectionController.getGreeting());
	}

}
