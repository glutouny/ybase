package com.yl.jdk8.optional;

import java.io.Serializable;
import java.util.Optional;

/**
 * @author yangli
 * @title
 * @description
 * @DATE 2019/11/26  15:08
 */
public class Department implements Serializable {

    private Company company;

    public Optional<Company> getCompany() {
        return Optional.ofNullable(company);
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
