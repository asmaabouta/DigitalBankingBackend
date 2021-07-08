package bank.ma.repositories;




import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import bank.ma.entities.Operation;

public interface OperationRepository extends JpaRepository<Operation, Long>{

	@Query("select o from Operation o where o.compte.numCompte=:x")
	public Page<Operation> getOperations(@Param("x") String code , Pageable pageable);
	
	
	
}
