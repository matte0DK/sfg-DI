package matteo.springframework.sfgdi;

import matteo.springframework.sfgdi.config.SfgConfig;
import matteo.springframework.sfgdi.config.SfgConstructorConfig;
import matteo.springframework.sfgdi.controllers.*;
import matteo.springframework.sfgdi.datasource.FakeDataSource;
import matteo.springframework.sfgdi.services.PrototypeBean;
import matteo.springframework.sfgdi.services.SingletonBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SfgDiApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(SfgDiApplication.class, args);

        PetController petController = (PetController) context.getBean("petController");
        System.out.println(petController.whichPetIsTheBest());

		I18nController i18nController = (I18nController) context.getBean("i18nController");
		System.out.println(i18nController.sayHello());

        MyController myController = (MyController) context.getBean("myController");

        System.out.println("------ Primary Bean");
        System.out.println(myController.sayHello());
        /*System.out.println(greeting);*/

        System.out.println("------ Property");
        PropertyInjectionController propertyInjectionController = (PropertyInjectionController) context.getBean("propertyInjectionController");
        System.out.println(propertyInjectionController.getGreeting());

        System.out.println("------ Setter");
        SetterInjectionController setterInjectionController = (SetterInjectionController) context.getBean("setterInjectionController");
        System.out.println(setterInjectionController.getGreeting());

        System.out.println("------ Constructor");
        ConstructorInjectionController constructorInjectionController = (ConstructorInjectionController) context.getBean("constructorInjectionController");
        System.out.println(constructorInjectionController.getGreeting());

        System.out.println("------ Bean scopes");
        SingletonBean singletonBean = context.getBean(SingletonBean.class);
        System.out.println(singletonBean.getMyScope());
        SingletonBean singletonBean1 = context.getBean(SingletonBean.class);
        System.out.println(singletonBean1.getMyScope());

        PrototypeBean prototypeBean = context.getBean(PrototypeBean.class);
        System.out.println(prototypeBean.getMyScope());
        PrototypeBean prototypeBean1 = context.getBean(PrototypeBean.class);
        System.out.println(prototypeBean1.getMyScope());

        FakeDataSource fakeDataSource = context.getBean(FakeDataSource.class);
        System.out.println(fakeDataSource.getUsername());
        System.out.println(fakeDataSource.getPassword());
        System.out.println(fakeDataSource.getJdbcUrl());

        System.out.println("------ Config Props Bean");
        SfgConfig sfgConfig = context.getBean(SfgConfig.class);
        System.out.println(sfgConfig.getUsername());
        System.out.println(sfgConfig.getPassword());
        System.out.println(sfgConfig.getJdbcUrl());

        System.out.println("------ Constructor Binding");
        SfgConstructorConfig sfgConstructorConfig = context.getBean(SfgConstructorConfig.class);
        System.out.println(sfgConstructorConfig.getUsername());
        System.out.println(sfgConstructorConfig.getPassword());
        System.out.println(sfgConstructorConfig.getJdbcUrl());
    }

}
