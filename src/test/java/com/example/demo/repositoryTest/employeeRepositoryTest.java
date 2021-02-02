package com.example.demo.repositoryTest;

import com.example.demo.entity.employeeEntity;
import com.example.demo.repository.employeeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class employeeRepositoryTest {

    @Autowired
    employeeRepository emRepos;

    @Test
    //@Rollback(value = false)
    public void repositorySaveTest(){
        employeeEntity emEntity=new employeeEntity("manh","le","manh@gmail.com");
        Assertions.assertNotNull(emRepos.save(emEntity));
        Assertions.assertTrue(emRepos.save(emEntity).getId()>0);
    }


}
