package com.ead.authuser.specifications;

import com.ead.authuser.models.UserCourseModel;
import com.ead.authuser.models.UserModel;
import jakarta.persistence.criteria.Join;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

import java.util.UUID;

public class SpecificationTemplate {
    @And({
            @Spec(path = "userType", spec = Equal.class), // EQUAL - TRAS EXATAMENTE O QUE FOI PASSADO
            @Spec(path = "userStatus", spec = Equal.class),
            @Spec(path = "fullName", spec = Like.class),// LIKE - TRAS O QUE CONTENHA O QUE FOI PASSADO EX THIAGO : THIAGO123,THIAGO455,THIAGO
            @Spec(path = "email", spec = Like.class)
    })

    public interface UserSpec extends Specification<UserModel> {}

    //FAZ O JOIN COM A TABELA USERCOURSE E TRAS OS USUARIOS QUE TEM O ID DO CURSO
    public static Specification<UserModel> userCourseId(final UUID courseId) {
        return ((root, query, cb) -> {
            query.distinct(true);
            Join<UserModel, UserCourseModel> userProd  = root.join("userCourses");
            return cb.equal(userProd.get("courseId"), courseId);
        });
    }

}
