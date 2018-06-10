package com.soa.domain.categories;

import com.soa.domain.UserData;

public interface Category {

    UserData getOwner();

    void setOwner(UserData user);
}
