package com.love.controller;

import com.love.model.CreateRequest;
import com.love.model.Plan;
import com.love.service.PlanService;
import com.love.service.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.Collections;
import java.util.List;

/**
 * Created by bhagi on 10/2/2017.
 */
@RestController
@AllArgsConstructor
public class UserController {

    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private PlanService planService;

    @RequestMapping("/auth/{value}")
    public String validate(@PathVariable("value") String auth) {
        if (StringUtils.isNoneBlank(auth)) {
            String decodedAuth = new String(Base64.getDecoder().decode(auth));
            String parts[] = decodedAuth.split(";");
            Pair<Boolean, String> result = userService.verify(parts[0], parts[1]);
            if (result.getKey()) return String.format("Welcome %s .Login is successful", result.getValue());
            else return "Login was a Failure, Invalid Credentials";
        }
        return  "Need Credentials";
    }


    @RequestMapping("/getPlans")
    public List<Plan> getPlans(@RequestParam String date, @RequestParam String userName) {
        List<Plan> plansForDay = planService.getPlans(String.join("_", date, userName));
        return plansForDay.isEmpty()? Collections.EMPTY_LIST : plansForDay;
    }

    @RequestMapping("/createPlan")
    public boolean createPlan(@RequestBody CreateRequest createRequest) {
        Plan plan = new Plan();
        plan.setData(createRequest.getData());
        plan.setDateName(String.join("_", createRequest.getCreationDate(), createRequest.getUserName()));
        planService.persist(plan);
        return true;
    }
}