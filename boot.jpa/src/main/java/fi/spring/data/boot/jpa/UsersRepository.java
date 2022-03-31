package fi.spring.data.boot.jpa;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users,String> {
@Query(name="byName", nativeQuery=true,
value="select * from users1 where name=:var1")
public Optional<Users> findByName(@Param("var1") String name);

}
//@Query(name="byEmail", nativeQuery=false,
//value="select objUser from Users objUser where objUser.email=:pemail")
//public Optional<Users>findByEmail(@Param("pemail")String email);
//@Modifying 
//@Query(name="changePassword", nativeQuery=true,
//value="upadate users set password=:pwd where username=:uname")
//@Transactional
//public void changePassword(@Param("uname")String username,@Param("pwd")String password);