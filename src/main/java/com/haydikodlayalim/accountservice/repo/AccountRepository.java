package com.haydikodlayalim.accountservice.repo;

import com.haydikodlayalim.accountservice.entity.Account;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

//CassandraRepository Tip ve Id istiyor
@Repository
public interface AccountRepository extends CassandraRepository<Account,String> {

}
