package com.xd.ums.service;

import com.xd.ums.dao.DepartMapper;
import com.xd.ums.domain.Department;
import com.xd.ums.domain.ResultBean;
import com.xd.ums.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartService {

    @Autowired
    private DepartMapper departMapper;
    //查询所有用户
    public List<Department> selectAllDepart(){
        return departMapper.findAllDepart();
    }

    public ResultBean selectApiDepart(){
        List<Department> depList = departMapper.findAllDepart();
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(0);
        resultBean.setMsg("ok");
        resultBean.setCount(depList.size());
        resultBean.setData(depList);
        return resultBean;
    }

}
