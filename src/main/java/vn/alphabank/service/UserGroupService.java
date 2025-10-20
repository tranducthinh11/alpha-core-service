package vn.alphabank.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.alphabank.domain.UserGroup;
import vn.alphabank.repository.UserGroupRepository;

//@Service
public class UserGroupService {

    private final UserGroupRepository userGroupRepository;

    public UserGroupService(UserGroupRepository userGroupRepository) {
        this.userGroupRepository = userGroupRepository;
    }

    public List<UserGroup> getGroupByUserID(Integer id) {
        // TODO Auto-generated method stub
        return userGroupRepository.findAllByUserId(id);
    }
}
