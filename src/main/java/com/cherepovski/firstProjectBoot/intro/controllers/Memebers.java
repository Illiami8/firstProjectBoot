package com.cherepovski.firstProjectBoot.intro.controllers;


import com.cherepovski.firstProjectBoot.intro.models.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/members")
public class Memebers {

 private static List  <Member> memberList = new ArrayList<>();

    @GetMapping("")
    public String toMembers(Model model) {
        model.addAttribute("members",memberList);
        return "members/members";
    }

    @GetMapping("/new_member")
    public String toAddMembers() {
        return "members/new_member";
    }

    @PostMapping("/new_member/create")
    public String createMember(@RequestParam String firstName,
                               @RequestParam String lastName,
                               Model model) {
        memberList.add(new Member(firstName,lastName));
        return "redirect:/members";
       // return "members/members";
    }
}
