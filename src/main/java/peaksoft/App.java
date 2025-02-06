package peaksoft;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import peaksoft.config.HibernateConfig;
import peaksoft.models.Laptop;
import peaksoft.models.Programmer;
import peaksoft.repository.impl.ProgrammerRepoImpl;
import peaksoft.services.LaptopService;
import peaksoft.services.ProgrammerService;
import peaksoft.services.impl.ProgrammerServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("peaksoft");


        context.register(ProgrammerRepoImpl.class);
        context.register(ProgrammerServiceImpl.class);
//        context.register(Laptop.class);
        context.refresh();
        ProgrammerService programmerService =
                context.getBean(ProgrammerServiceImpl.class);

        programmerService.save(new Programmer("Aibek", 20));
        programmerService.findAll().forEach(System.out::println);
        context.close();



    }
}
