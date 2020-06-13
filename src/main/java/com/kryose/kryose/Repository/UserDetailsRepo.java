package com.kryose.kryose.Repository;

import com.kryose.kryose.Entity.MyUserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepo extends JpaRepository<MyUserDetails,Long> {
}
