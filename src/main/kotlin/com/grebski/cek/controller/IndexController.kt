package com.grebski.cek.controller

import com.grebski.cek.repository.PersonRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class IndexController(val personRepository: PersonRepository) {

    @RequestMapping("/")
    fun index(model: ModelMap): String {
        model.addAttribute("userCount", personRepository.count().block())
        return "index"
    }
}