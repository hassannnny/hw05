package edu.neiu.hw06.data;

import edu.neiu.hw06.models.Tasks;
import org.springframework.data.repository.CrudRepository;

public interface TasksRepository extends CrudRepository<Tasks, Long> {
}
