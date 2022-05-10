package com.springdb.demo.repository;

import com.springdb.demo.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, String> {
    Group getGroupByGroupName(String name);
}
