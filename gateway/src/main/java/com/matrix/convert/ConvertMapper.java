package com.matrix.convert;

import com.matrix.entity.dto.SysMenuDto;
import com.matrix.entity.dto.SysResourceDto;
import com.matrix.entity.dto.SysRoleDto;
import com.matrix.entity.dto.TenantDto;
import com.matrix.entity.po.SysMenu;
import com.matrix.entity.po.SysResource;
import com.matrix.entity.po.SysRole;
import com.matrix.entity.po.Tenant;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

/**
 * 描述：转换工具类
 *
 * @author zwl
 * @since 2022/7/13 15:44
 **/
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ConvertMapper {

    ConvertMapper INSTALL = Mappers.getMapper(ConvertMapper.class);

    /**
     * 描述：转换SysRoleAddDto为SysRole
     *
     * @param dto SysRoleAddDto
     * @return SysRole
     * @author zwl
     * @since 2022/7/13 15:45
     **/
    SysRole convert(SysRoleDto dto);

    SysMenu convert(SysMenuDto dto);

    SysResource convert(SysResourceDto dto);

    Tenant convert(TenantDto dto);

}
