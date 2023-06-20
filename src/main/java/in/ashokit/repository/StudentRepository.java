package in.ashokit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.binding.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
