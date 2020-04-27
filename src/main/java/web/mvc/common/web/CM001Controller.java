package web.mvc.common.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import java.util.List;

import web.mvc.common.domain.CM001Dto;
import web.mvc.common.dao.CM001Dao;
import web.mvc.common.service.CM001Service;


@Controller
public class CM001Controller {

    @Autowired
    private CM001Service service;


    @RequestMapping("/CM001.do")
    public String main(Model model) {
        List<CM001Dto> notice = service.getNotice();
        List<CM001Dto> free = service.getFree();
        model.addAttribute("notice", notice);
        model.addAttribute("free", free);
        return "CM001";
    }
}
