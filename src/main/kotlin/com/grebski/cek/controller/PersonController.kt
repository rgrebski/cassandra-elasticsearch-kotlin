package com.grebski.cek.controller

import com.grebski.cek.service.PersonService
import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam

@Controller
class PersonController(val personService: PersonService) {

    @GetMapping("/person/generate/{noOfUsersToAdd}")
    fun addUsers(@PathVariable("noOfUsersToAdd") noOfUsersToAdd: Int): String {
        personService.generatePersons(noOfUsersToAdd)
        return "redirect:/"
    }

    @GetMapping("/person/list")
    fun listUsers(model: ModelMap,
                  @RequestParam pageNo: Int? = 0,
                  @RequestParam pageSize: Int? = 10): String {

        val personList = personService.getPage(pageNo, pageSize)
        model.addAttribute("persons", personList)

        return "person/list"
    }
}