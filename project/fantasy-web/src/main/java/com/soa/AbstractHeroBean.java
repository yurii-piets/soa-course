package com.soa;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.IOException;

@EqualsAndHashCode(callSuper = true)
@Data
public abstract class AbstractHeroBean extends AbstractManagedBean {

    public abstract void modify() throws IOException;

    public abstract void delete() throws IOException;
}
