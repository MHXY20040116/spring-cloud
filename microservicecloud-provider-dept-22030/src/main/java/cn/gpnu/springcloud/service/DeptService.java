package cn.gpnu.springcloud.service;

import cn.gpnu.springcloud.entity.DeptEntity;

import java.util.List;

public interface DeptService {

    /**
     * 插入
     *
     * @param deptEntity
     * @return
     */
    boolean addDept(DeptEntity deptEntity);

    /**
     * 根据id查找
     *
     * @param deptNo
     * @return
     */
    DeptEntity getById(Long deptNo);

    /**
     * 查询全部
     *
     * @return
     */
    List<DeptEntity> listAll();

}
