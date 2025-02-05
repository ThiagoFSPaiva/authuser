package com.ead.authuser.specifications;

import com.ead.authuser.models.UserModel;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

public class SpecificationTemplate {
    @And({
            @Spec(path = "userType", spec = Equal.class), // EQUAL - TRAS EXATAMENTE O QUE FOI PASSADO
            @Spec(path = "userStatus", spec = Equal.class),
            @Spec(path = "username", spec = Like.class),// LIKE - TRAS O QUE CONTENHA O QUE FOI PASSADO EX THIAGO : THIAGO123,THIAGO455,THIAGO
            @Spec(path = "email", spec = Like.class)
    })

    public interface UserSpec extends Specification<UserModel> {}
}
