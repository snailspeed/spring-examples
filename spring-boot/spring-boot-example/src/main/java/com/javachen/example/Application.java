package com.javachen.example;

import com.javachen.example.exception.ExitException;
import com.javachen.example.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@SpringBootApplication
public class Application implements CommandLineRunner {
  private static final Logger logger = LoggerFactory.getLogger(Application.class);

  @Autowired
  private MessageService messageService;

  @RequestMapping("/")
  String home() {
    return this.messageService.getMessage();
  }

  @Override
  public void run(String... args) {
    logger.info(this.messageService.getMessage());
    if (args.length > 0 && args[0].equals("exitcode")) {
      throw new ExitException();
    }
  }

  public static void main(String[] args) throws Exception {
    SpringApplication.run(Application.class, args);
//    SpringApplication.run("classpath:/META-INF/application-context.xml", args);
  }

  @PostConstruct
  public void logSomething() {
    logger.debug("Sample Debug Message");
    logger.trace("Sample Trace Message");
  }
}