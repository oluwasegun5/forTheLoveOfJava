package bank.data.repositories;

import bank.data.model.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Bank extends MongoRepository<Account,String> {
}
