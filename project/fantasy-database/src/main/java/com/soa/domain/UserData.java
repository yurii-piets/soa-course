package com.soa.domain;

import com.soa.domain.categories.Category;
import com.soa.domain.categories.Cave;
import com.soa.domain.categories.Forest;
import com.soa.domain.categories.Tower;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static com.soa.domain.UserData.USER_DATA_QUERY_NAME;

@Entity(name = "USER_DATA")
@Table(name = "USER_DATA")
@NamedQueries({@NamedQuery(name = USER_DATA_QUERY_NAME, query = "SELECT user FROM com.soa.domain.UserData user WHERE user.login = :login")})
@Data
@NoArgsConstructor
@ToString(exclude = {"caves", "forests", "towers"})
@EqualsAndHashCode(exclude = {"caves", "forests", "towers"})
public class UserData implements Serializable {

    public static final String USER_ID = "user_id";

    public static final String USER_DATA_QUERY_NAME = "USER_DATA_BY_LOGIN";

    public enum UserRole {
        ADMIN,
        USER;


        @Override
        public String toString() {
            return super.toString();
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = USER_ID)
    private Long id;

    @NotNull
    @Column(length = 6, unique = true)
    private Integer index;

    @NotNull
    @Column(length = 50, unique = true)
    private String login;

    @NotNull
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "owner")
    private List<Cave> caves = new ArrayList<>();

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "owner")
    private List<Forest> forests = new ArrayList<>();

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "owner")
    private List<Tower> towers = new ArrayList<>();

    @Builder
    public UserData(Integer index, String login, String password, UserRole role) {
        this.index = index;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    @Transient
    public List<Category> getCategories() {
        List<Category> categories = new ArrayList<>();
        categories.addAll(caves);
        categories.addAll(forests);
        categories.addAll(towers);
        return categories;
    }
}
