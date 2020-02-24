package com.linhongren.feign;

import com.linhongren.entity.Student;
import com.linhongren.feign.impl.FeignError;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

//因为是声明式接口，所以只有当服务中心有provider，即可访问。
//若出现问题则访问FeignError的这个逻辑
@FeignClient(value = "provider", fallback = FeignError.class)
public interface FeignProviderClient {
    @GetMapping("/student/findAll")
    public Collection<Student> findAll();
    @GetMapping("/student/index")
    public String index();
}
