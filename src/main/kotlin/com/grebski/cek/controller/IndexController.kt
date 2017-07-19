package com.grebski.cek.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class IndexController {

    @RequestMapping("/") open fun index(map: ModelMap): String {
        return "index"
    }
}