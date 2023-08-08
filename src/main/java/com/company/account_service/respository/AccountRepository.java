package com.company.account_service.respository;

import com.company.account_service.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    //CRUD
  // @Query(value = "Select name from account", nativeQuery = false)
    //Account findByName(String name);

}
