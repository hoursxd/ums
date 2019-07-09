package com.xd.ums.web;

import com.xd.ums.domain.Depart;
import com.xd.ums.domain.Department;
import com.xd.ums.domain.ResultBean;
import com.xd.ums.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@EnableAutoConfiguration
public class DepartController {

    @Autowired
    private DepartService departService;

    @RequestMapping("alldep")
    public List<Department> getAllDepart() {
        return departService.selectAllDepart();
    }

    @RequestMapping("depapi")
    public ResultBean getApiDepart(){
        return departService.selectApiDepart();
    }


    @RequestMapping("dep")
    public List<Depart> getDepart() {

        Depart depart = new Depart();
        List<Depart> df = new ArrayList<Depart>();


        depart.setId(1);
        depart.setPId(0);
//        depart.setParent(true);
        depart.setName("山东");

        df.add(depart);


        Depart depart1 = new Depart();

        depart1.setId(2);
        depart1.setPId(1);
//        depart1.setParent(false);
        depart1.setName("济南");

        df.add(depart1);
        df.add(new Depart(3, 1, "德州"));

        return df;
    }

}
