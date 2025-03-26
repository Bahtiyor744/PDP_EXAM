package com.example.pdp_project.repo;

import com.example.pdp_project.entity.Degree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DegreeRepository extends JpaRepository<Degree, Integer> {
    Optional<Degree> findByUserIdAndLessonId(Integer currentUserId, Integer lessonId);

    @Query(value = """
            SELECT users.first_name,
                   users.last_name,
                   COALESCE(SUM(d.mark), 0) AS mark
            FROM pdp.public.users
            LEFT JOIN degree d ON users.id = d.user_id
            LEFT JOIN lesson l ON l.id = d.lesson_id
            LEFT JOIN modules m ON l.module_id = m.id
            WHERE m.course_id = :courseId OR m.course_id IS NULL
            GROUP BY users.first_name, users.last_name
            ORDER BY mark DESC
            """, nativeQuery = true)
    List<Object[]> getRatingByCourseID(@Param("courseId") Integer courseId);

    @Query(value = """
            WITH FilteredLessons AS (SELECT DISTINCT l.module_id
                                     FROM degree d
                                              JOIN lesson l ON d.lesson_id = l.id
                                     WHERE d.user_id = :currentUserID)
            SELECT c.id                         AS course_id,
                   c.name                       AS course_name,
                   COUNT(DISTINCT m.id)         AS total_modules,
                   COUNT(DISTINCT fl.module_id) AS completed_modules 
                   
            FROM course c
                     LEFT JOIN modules m ON c.id = m.course_id
                     LEFT JOIN FilteredLessons fl ON m.id = fl.module_id
            GROUP BY c.id, c.name
                        """, nativeQuery = true)
    List<Object[]> getRating(@Param("currentUserID") Integer currentUserID);

}