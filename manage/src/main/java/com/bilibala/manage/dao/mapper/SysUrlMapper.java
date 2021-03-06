package com.bilibala.manage.dao.mapper;

import com.bilibala.manage.dao.model.SysUrl;
import com.bilibala.manage.dao.model.SysUrlExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysUrlMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_url
     *
     * @mbggenerated
     */
    int countByExample(SysUrlExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_url
     *
     * @mbggenerated
     */
    int deleteByExample(SysUrlExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_url
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_url
     *
     * @mbggenerated
     */
    int insert(SysUrl record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_url
     *
     * @mbggenerated
     */
    int insertSelective(SysUrl record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_url
     *
     * @mbggenerated
     */
    List<SysUrl> selectByExample(SysUrlExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_url
     *
     * @mbggenerated
     */
    SysUrl selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_url
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") SysUrl record, @Param("example") SysUrlExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_url
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") SysUrl record, @Param("example") SysUrlExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_url
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(SysUrl record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_url
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(SysUrl record);
}