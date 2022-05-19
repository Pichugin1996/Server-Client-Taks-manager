package com.dimastik.server.repository;

import com.dimastik.server.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findAllByUserId(Integer id);

}
