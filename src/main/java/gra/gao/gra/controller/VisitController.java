package gra.gao.gra.controller;

import gra.gao.gra.mapper.VisitMapper;
import gra.gao.gra.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:gao
 * @date:2020/4/5
 * @time:21:42
 * @version:0.0.1
 * @description:none
 */

@RestController
@CrossOrigin
@RequestMapping("/admin/visit")
public class VisitController {

    @Autowired
    VisitService visitService;

    @PostMapping("/today")
    public String getToday(){
        String visitJSON=visitService.getVisitToday();
        return visitJSON;
    }
}
