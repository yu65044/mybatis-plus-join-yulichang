package com.github.mybatisplus.base;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.github.mybatisplus.toolkit.Constant;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author yulichang
 * @see BaseMapper
 */
public interface MyBaseMapper<T> extends BaseMapper<T> {

    /**
     * 连表查询返回一条记录
     *
     * @param queryWrapper joinWrapper
     * @param clazz        resultType
     */
    <DTO> DTO selectJoinOne(@Param(Constant.CLAZZ) Class<DTO> clazz, @Param(Constants.WRAPPER) Wrapper<?> queryWrapper);

    /**
     * 连表查询返回Map
     *
     * @param queryWrapper joinWrapper
     */
    Map<String, Object> selectJoinMap(@Param(Constants.WRAPPER) Wrapper<?> queryWrapper);

    /**
     * 连表查询返回记录集合
     *
     * @param queryWrapper joinWrapper
     * @param clazz        resultType
     */
    <DTO> List<DTO> selectJoinList(@Param(Constant.CLAZZ) Class<DTO> clazz, @Param(Constants.WRAPPER) Wrapper<?> queryWrapper);

    /**
     * 连表查询返回Map集合
     *
     * @param queryWrapper joinWrapper
     */
    List<Map<String, Object>> selectJoinMaps(@Param(Constants.WRAPPER) Wrapper<?> queryWrapper);

    /**
     * 连表查询返回记录集合并分页
     *
     * @param queryWrapper joinWrapper
     * @param clazz        resultType
     * @param <DTO>        分页返回对象
     */
    <DTO, P extends IPage<?>> IPage<DTO> selectJoinPage(P page,
                                                        @Param(Constant.CLAZZ) Class<DTO> clazz,
                                                        @Param(Constants.WRAPPER) Wrapper<?> queryWrapper);

    /**
     * 连表查询返回Map集合并分页
     *
     * @param queryWrapper joinWrapper
     */
    <P extends IPage<?>> IPage<Map<String, Object>> selectJoinMapsPage(P page, @Param(Constants.WRAPPER) Wrapper<?> queryWrapper);
}