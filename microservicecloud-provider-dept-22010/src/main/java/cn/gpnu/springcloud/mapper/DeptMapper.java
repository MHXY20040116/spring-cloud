package cn.gpnu.springcloud.mapper;

import cn.gpnu.springcloud.entity.DeptEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @description
 */
@Mapper
public interface DeptMapper {

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
    DeptEntity findById(Long deptNo);

    /**
     * 查询全部
     *
     * @return
     */
    List<DeptEntity> findAll();

}
