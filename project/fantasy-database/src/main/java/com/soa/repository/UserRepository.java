package com.soa.repository;

import com.soa.domain.UserData;
import com.soa.repository.def.AbstractRepository;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;

import static com.soa.domain.UserData.USER_DATA_QUERY_NAME;

@Stateless
@LocalBean
@SuppressWarnings("unchecked")
public class UserRepository extends AbstractRepository<UserData> {

    public UserRepository() {
        super(UserData.class);
    }

    public UserData findUserDataByLogin(String name) {
        Query query = entityManager.createNamedQuery(USER_DATA_QUERY_NAME).setParameter("login", name);
        List<UserData> resultList = query.getResultList();
        return resultList.isEmpty() ? null : resultList.get(0);
    }
}
