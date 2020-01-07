package com.yl.jdk8.optional;

import java.io.Serializable;
import java.util.Optional;

/**
 * @author yangli
 * @title
 * @description
 * @DATE 2019/11/26  15:06
 */
public class Staff implements Serializable {

    private Department department;

    public Optional<Department> getDepartment() {
        return Optional.ofNullable(department);
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
