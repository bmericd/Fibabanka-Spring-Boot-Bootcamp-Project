package com.fiba.orm.data.repository;

import com.fiba.orm.data.entity.Team;
import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<Team, Long> {
}
