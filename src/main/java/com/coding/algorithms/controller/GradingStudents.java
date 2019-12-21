package com.coding.algorithms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GradingStudents {
    private static final Logger log = LoggerFactory.getLogger(GradingStudents.class);

    @RequestMapping("/grades")
    public List<Integer> studentGrades(@RequestParam(value = "grades") List<Integer> grades) {
        List<Integer> finalGrades = new ArrayList<>();
        for (Integer item : grades) {
            int remainder = item % 5;
            log.info(String.format("Number: %s, Remaider: %s", item, String.valueOf(remainder)));
            if (!(item < 38) & remainder > 2) {
                finalGrades.add(item + (5 - remainder));
            } else {
                finalGrades.add(item);
            }
        }
        return finalGrades;
    }


    @RequestMapping("/")
    public String greetings() {
        return "Hello World";
    }
}
