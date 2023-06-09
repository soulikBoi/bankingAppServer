package bankingApp.repository;

import bankingApp.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



import java.util.ArrayList;


@Repository
public interface ITransactionsRepository extends JpaRepository<Transaction, Integer> {

    @Query(value = "SELECT * FROM transactions WHERE ( senders_acc_number = ?1 OR receivers_acc_number = ?1 )",
            nativeQuery = true)
    ArrayList<Transaction> getTransactions(String sender);


}
