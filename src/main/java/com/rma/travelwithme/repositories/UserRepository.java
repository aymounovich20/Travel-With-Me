package com.rma.travelwithme.repositories;

import com.rma.travelwithme.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
<<<<<<< HEAD

	User findByUsername(String username);
	User findByUsernameAndPassword(String username,String password);
    // You can add custom query methods if needed
=======
>>>>>>> 92b76ce9553be02d8832a473b8c87ba59f0df6ca
}

