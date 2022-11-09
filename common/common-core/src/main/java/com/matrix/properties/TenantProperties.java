package com.matrix.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * 描述：
 *
 * @author zwl
 * @since 2022/7/15 17:34
 **/
@Data
@ConfigurationProperties(prefix = "matrix.tenant")
public class TenantProperties {

    public static final String TENANT_KEY = "tenant_id";

    private Boolean enable = false;

    private List<String> ignoreTables;

    private List<String> ignoreUrls;

}
