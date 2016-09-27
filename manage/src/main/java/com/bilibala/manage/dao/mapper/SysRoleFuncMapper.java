package com.bilibala.manage.dao.mapper;

import com.bilibala.manage.dao.model.SysRoleFuncExample;
import com.bilibala.manage.dao.model.SysRoleFuncKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysRoleFuncMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_func
     *
     * @mbggenerated
     */
    int countByExample(SysRoleFuncExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_func
     *
     * @mbggenerated
     */
    int deleteByExample(SysRoleFuncExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_func
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(SysRoleFuncKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_func
     *
     * @mbggenerated
     */
    int insert(SysRoleFuncKey record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_func
     *
     * @mbggenerated
     */
    int insertSelective(SysRoleFuncKey record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_func
     *
     * @mbggenerated
     */
    List<SysRoleFuncKey> selectByExample(SysRoleFuncExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_func
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") SysRoleFuncKey record, @Param("example") SysRoleFuncExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_func
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") SysRoleFuncKey record, @Param("example") SysRoleFuncExample example);
}