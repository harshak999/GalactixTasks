package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.IEmployeeService;

//@Component   // ✅ Enable this annotation
public class EmployeeTestRunner implements CommandLineRunner {

    @Autowired
    private IEmployeeService empService;

    @Override
    public void run(String... args) throws Exception {
        try {
            System.out.println("======= Employee Records (Paginated) =======");
            empService.showEmployeeBypagination(3); // pageSize = 3
            System.out.println("============================================");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
