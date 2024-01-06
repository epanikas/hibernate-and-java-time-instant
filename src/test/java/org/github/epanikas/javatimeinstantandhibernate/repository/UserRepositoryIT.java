package org.github.epanikas.javatimeinstantandhibernate.repository;

import org.apache.log4j.Logger;
import org.github.epanikas.javatimeinstantandhibernate.datasource.DataSourceConfig;
import org.github.epanikas.javatimeinstantandhibernate.entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.stream.StreamSupport;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DataSourceConfig.class)
public class UserRepositoryIT {

    private static final Logger log = Logger.getLogger(UserRepositoryIT.class);

    @Autowired
    private UserRepository userRepository;

    @Test
    public void whenCalledSave_thenCorrectNumberOfUsers() {
        User saved = userRepository.save(new User("Bob", "bob@domain.com"));

        log.info(saved);

        List<User> users = (List<User>) userRepository.findAll();

        assertThat(users.size()).isEqualTo(2);
    }

    @Before
    public void setUp() {
        StreamSupport.stream(userRepository.findAll().spliterator(), false)
                .filter(u -> "Bob".equals(u.getName()))
                .forEach(u -> userRepository.deleteById(u.getId()));
    }
}