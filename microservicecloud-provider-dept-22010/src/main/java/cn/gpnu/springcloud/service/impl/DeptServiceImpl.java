package cn.gpnu.springcloud.service.impl;

import cn.gpnu.springcloud.entity.DeptEntity;
import cn.gpnu.springcloud.mapper.DeptMapper;
import cn.gpnu.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public boolean addDept(DeptEntity deptEntity) {
        return deptMapper.addDept(deptEntity);
    }

    @Override
    public DeptEntity getById(Long deptNo) {
        return deptMapper.findById(deptNo);
    }

    @Override
    public List<DeptEntity> listAll() {
        return deptMapper.findAll();
    }
}
