package com.zxin.louvre.controller;

import java.io.Writer;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/louvre")
public class LouvreController {
    
    @RequestMapping("/hello")
    public void hello(HttpServletResponse response, String world) throws Exception {
        Writer writer = response.getWriter();
        writer.write(String.format("%s %s", "hello", world));
        writer.close();
    }
}
