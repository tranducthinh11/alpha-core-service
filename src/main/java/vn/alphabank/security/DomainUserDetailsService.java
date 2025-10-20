//package vn.alphabank.security;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Locale;
//import java.util.Optional;
//import java.util.Set;
//import java.util.stream.Collectors;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
//import vn.alphabank.domain.Group;
//import vn.alphabank.domain.User;
//import vn.alphabank.domain.UserGroup;
//import vn.alphabank.repository.GroupRepository;
//import vn.alphabank.repository.UserGroupRepository;
//import vn.alphabank.repository.UserRepository;
//
///**
// * Authenticate a user from the database.
// */
//@Component("userDetailsService")
//public class DomainUserDetailsService implements UserDetailsService {
//
//    private final Logger log = LoggerFactory.getLogger(DomainUserDetailsService.class);
//
//    private final UserRepository userRepository;
//    private final UserGroupRepository userGroupRepository;
//    private final GroupRepository groupRepository;
//
//    public DomainUserDetailsService(
//        UserRepository userRepository,
//        UserGroupRepository userGroupRepository,
//        GroupRepository groupRepository
//    ) {
//        this.userRepository = userRepository;
//        this.userGroupRepository = userGroupRepository;
//        this.groupRepository = groupRepository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(final String login) {
//        log.debug("Authenticating {}", login);
//        String lowercaseLogin = login.toLowerCase(Locale.ENGLISH);
//        Optional<User> userLogin = userRepository.findOneByLogin(lowercaseLogin);
//        List<UserGroup> lstUserGroup = userGroupRepository.findAllByUserId(userLogin.get().getId());
//        List<Integer> lstGroupIds = new ArrayList<Integer>();
//        if (!lstUserGroup.isEmpty()) {
//            lstUserGroup.stream().forEach(u -> lstGroupIds.add(u.getGroupId()));
//        }
//
//        Set<Group> lstGroup = groupRepository.findByIdIn(lstGroupIds);
//        userLogin.get().setAuthorities(lstGroup);
//        UserDetails userDetail = userLogin
//            .map(user -> createSpringSecurityUser(lowercaseLogin, user))
//            .orElseThrow(() -> new UsernameNotFoundException("User " + lowercaseLogin + " was not found in the database"));
//        return userDetail;
//    }
//
//    private org.springframework.security.core.userdetails.User createSpringSecurityUser(String lowercaseLogin, User user) {
//        if (!user.isActivated()) {
//            throw new UserNotActivatedException("User " + lowercaseLogin + " was not activated");
//        }
//        List<GrantedAuthority> grantedAuthorities = user
//            .getAuthorities()
//            .stream()
//            .map(authority -> new SimpleGrantedAuthority(authority.getName()))
//            .collect(Collectors.toList());
//        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), grantedAuthorities);
//    }
//}
