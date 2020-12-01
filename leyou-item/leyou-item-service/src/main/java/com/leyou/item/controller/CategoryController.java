package com.leyou.item.controller;

import com.leyou.item.pojo.Category;
import com.leyou.item.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 根据父id查询子节点(商品类目)
     * @param pid
     * @return
     */
    @GetMapping("/list")
    public ResponseEntity<List<Category>> queryCategoriesByPid(
            @RequestParam(value = "pid",defaultValue = "0") Long pid) {

        if (pid == null || pid.longValue() < 0) {
            // 响应400，相当于ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            return ResponseEntity.badRequest().build();
        }
        List<Category> categories = this.categoryService.queryCategoriesByPid(pid);
        if (CollectionUtils.isEmpty(categories)) {
            // 响应404
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(categories);
    }

    @GetMapping("names")
    public ResponseEntity<List<String>> queryNameByIds(@RequestParam("ids")List<Long> ids){
        List<String> names = this.categoryService.queryNameByIds(ids);
        if (CollectionUtils.isEmpty(names)) {
            // 响应404
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(names);
    }
}