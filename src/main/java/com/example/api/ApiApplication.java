package com.example.api;

import com.example.api.dao.QuestionRepository;
import com.example.api.dao.UserRepository;
import com.example.api.model.Question;
import com.example.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private QuestionRepository questionRepository;

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        userRepository.save(new User("yahya", "gmail.com", "123"));
        userRepository.save(new User("taimourya", "gmail.com", "123"));
        userRepository.save(new User("amine", "gmail.com", "123"));
        userRepository.save(new User("hamza", "gmail.com", "123"));
        userRepository.save(new User("mehdi", "gmail.com", "123"));

        questionRepository.save(new Question("question 1",
                "reponse1,reponse2,reponse3,reponse4",
                "reponse1"));

        questionRepository.save(new Question("question 2",
                "reponse1,reponse2,reponse3,reponse4",
                "reponse2"));

        questionRepository.save(new Question("question 3",
                "reponse1,reponse2,reponse3,reponse4",
                "reponse3"));

        questionRepository.save(new Question("question 4",
                "reponse1,reponse2,reponse3,reponse4",
                "reponse4"));
    }
}
