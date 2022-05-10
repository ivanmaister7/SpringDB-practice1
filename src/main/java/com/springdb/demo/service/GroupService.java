package com.springdb.demo.service;

import com.springdb.demo.model.Group;
import com.springdb.demo.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GroupService{

    @Autowired
    private GroupRepository groupRepository;

    public Group createGroup(Group group){
       return groupRepository.save(group);
    }

    public Group getById(String name) {
        return groupRepository.getGroupByGroupName(name);
    }

    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    public boolean delete(String name) {

        if(!groupRepository.existsById(name)) {
            return false;
        }
        groupRepository.deleteById(name);
        return true;
    }
}
