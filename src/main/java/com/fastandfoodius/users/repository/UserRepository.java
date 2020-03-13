package com.fastandfoodius.users.repository;

        import com.fastandfoodius.users.model.UserBean;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;
        import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserBean, Integer>{

    public List<UserBean> findByTitle(String title);

    public List<UserBean> findByFirstNameLikeOrLastNameLike(String  firstName, String lastName);

    public UserBean findByEmailAddress(String emailAddress);

}

