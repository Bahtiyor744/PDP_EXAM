package com.example.pdp_project.config;

import com.example.pdp_project.entity.Module;
import com.example.pdp_project.entity.*;
import com.example.pdp_project.enums.UserRole;
import com.example.pdp_project.repo.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
@RequiredArgsConstructor
public class DateLoader implements CommandLineRunner {
    private final RolesRepository rolesRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;
    private final ModuleRepository moduleRepository;
    private final LessonRepository lessonRepository;
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;
    @Override
    public void run(String... args) throws Exception {
        Roles role1 = new Roles(UserRole.SUPER_ADMIN);
        Roles role2 = new Roles(UserRole.ADMIN);
        Roles role3 = new Roles(UserRole.USER);
        rolesRepository.save(role1);
        rolesRepository.save(role2);
        rolesRepository.save(role3);

        List<Roles> rolesList = rolesRepository.findAll();
        List<Roles> roleUser = new ArrayList<>();
        roleUser.add(role3);
        User user1 = new User("Admin", "Admin", "bahhtee7444@mail.ru", passwordEncoder.encode("1"), rolesList, null);
        User user2 = new User("Eshmat", "Toshmatov", "bahhtee7555@mail.ru", passwordEncoder.encode("1"), roleUser, null);
        userRepository.save(user1);
        userRepository.save(user2);

        Course course1 = new Course("Course1");
        Course course2 = new Course("Course2");
        courseRepository.save(course1);
        courseRepository.save(course2);


        Module module1 = new Module("Module1", course1, new ArrayList<>());
        Module module2 = new Module("Module2", course1, new ArrayList<>());
        Module module3 = new Module("Module3", course2, new ArrayList<>());
        Module module4 = new Module("Module4", course2, new ArrayList<>());
        moduleRepository.save(module1);
        moduleRepository.save(module2);
        moduleRepository.save(module3);
        moduleRepository.save(module4);


        Lesson lesson1 = new Lesson("lesson1", module1, new ArrayList<>());
        Lesson lesson2 = new Lesson("lesson2", module2, new ArrayList<>());
        Lesson lesson3 = new Lesson("lesson3", module3, new ArrayList<>());
        Lesson lesson4 = new Lesson("lesson4", module4, new ArrayList<>());
        lessonRepository.save(lesson1);
        lessonRepository.save(lesson2);
        lessonRepository.save(lesson3);
        lessonRepository.save(lesson4);

        Question question1 = new Question("quation1", lesson1, new ArrayList<>());
        Question question2 = new Question("quation2", lesson2, new ArrayList<>());
        Question question3 = new Question("quation3", lesson3, new ArrayList<>());
        Question question4 = new Question("quation4", lesson4, new ArrayList<>());

        questionRepository.save(question1);
        questionRepository.save(question2);
        questionRepository.save(question3);
        questionRepository.save(question4);

        Answer answer1 = new Answer("answer1", true, question1);
        Answer answer2 = new Answer("answer2", false, question1);
        Answer answer3 = new Answer("answer3", false, question1);

        Answer answer4 = new Answer("answer4", true, question2);
        Answer answer5 = new Answer("answer5", false, question2);
        Answer answer6 = new Answer("answer6", false, question2);

        Answer answer7 = new Answer("answer7", true, question3);
        Answer answer8 = new Answer("answer8", false, question3);
        Answer answer9 = new Answer("answer9", false, question3);

        Answer answer10 = new Answer("answer10", true, question4);
        Answer answer11 = new Answer("answer11", false, question4);
        Answer answer12 = new Answer("answer12", false, question4);

        answerRepository.save(answer1);
        answerRepository.save(answer2);
        answerRepository.save(answer3);
        answerRepository.save(answer4);
        answerRepository.save(answer5);
        answerRepository.save(answer6);
        answerRepository.save(answer7);
        answerRepository.save(answer8);
        answerRepository.save(answer9);
        answerRepository.save(answer10);
        answerRepository.save(answer11);
        answerRepository.save(answer12);
    }
}
