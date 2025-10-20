package vn.alphabank.repository;

import java.util.List;


import vn.alphabank.domain.UserGroup;

//@Repository
public interface UserGroupRepository {
    List<UserGroup> findAllByUserId(Integer id);
}
