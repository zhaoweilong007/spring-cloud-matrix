package com.matrix.security;

import cn.dev33.satoken.exception.NotPermissionException;
import cn.dev33.satoken.filter.SaFilterAuthStrategy;
import cn.dev33.satoken.reactor.context.SaReactorSyncHolder;
import cn.dev33.satoken.stp.StpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.List;

/**
 * 描述：权限鉴权策略
 *
 * @author zwl
 * @since 2022/7/8 15:04
 **/
@Component
@Slf4j
public class SecurityAuth implements SaFilterAuthStrategy {

    private final AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public void run(Object r) {
        log.info("SecurityAuth check permission...");
        //检查登录
        StpUtil.checkLogin();
        //获取用户拥有资源
        List<String> permissionList = StpUtil.getPermissionList();
        //将访问所需资源或用户拥有资源进行比对
        ServerHttpRequest request = SaReactorSyncHolder.getContext().getRequest();
        String path = request.getURI().getPath();
        String resource = permissionList.stream().filter(url -> antPathMatcher.match(url, path)).findFirst().orElseThrow(() -> new NotPermissionException(path));
        log.info("用户:【{}】 资源:【{}】授权成功", StpUtil.getLoginId(), resource);
    }
}
