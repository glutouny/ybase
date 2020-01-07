package com.yl.jdk8.optional;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

/**
 * @author yangli
 * @title
 * @description
 * @DATE 2019/11/26  15:11
 */
public class Test {

    public static void main(String[] args) {
        testCalendar();
        Company company = null;
        company.setName("goudan");
        Department department = new Department();
        department.setCompany(company);
        Staff staff = new Staff();
        staff.setDepartment(department);

        Optional<Company> optionalCompany = Optional.ofNullable(company);
        optionalCompany.map(Company::getName).orElse("");

        optionalCompany.filter(company1 -> "goudan".equalsIgnoreCase(company1.getName()))
                .ifPresent(company1 -> company1.setName("wangcai"));

        System.out.println(company.getName());

        Optional<Staff> optionalStaff = Optional.ofNullable(staff);
        String name = optionalStaff.flatMap(Staff::getDepartment)
                .flatMap(Department::getCompany)
                .map(Company::getName)
                .orElse("");
        System.out.println(name);

    }

    public static void testCalendar(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE,1);
        calendar.add(Calendar.SECOND,-1);
        System.out.println(calendar.getTime());
    }
}
