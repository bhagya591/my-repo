package com.bpg.palindrome.controller;

import com.bpg.palindrome.controller.errors.InvalidOperationException;
import com.bpg.palindrome.entity.Palindrome;
import com.bpg.palindrome.service.PalindromeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;


@RestController
@RequestMapping("/api/palindromes")
public class PalindromeRestController {

    @Autowired
    private PalindromeService service;


    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<Palindrome> getPalindromes() {
        List<Palindrome> palindromes = service.getAll();
        return palindromes;
    }

    @GetMapping("/{PalindromeId}")
    @ResponseStatus(HttpStatus.OK)
    public Palindrome getById(@PathVariable(name = "PalindromeId") Long palindromeId) {
        return service.getById(palindromeId);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Palindrome savePalindrome(String _str_) {
        Palindrome palindrome= service.save(new Palindrome(_str_));
        System.out.println("Palindrome Saved Successfully");
        return palindrome;
    }

    @DeleteMapping("/{PalindromeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)

    public void deletePalindrome(@PathVariable(name = "PalindromeId") Long palindromeId) {
        Palindrome acc = service.getById(palindromeId);
        if (acc != null) {
            service.delete(palindromeId);
        } else {
            throw new InvalidOperationException("Operation Failed");
        }
        System.out.println("Palindrome Deleted Successfully");
    }



}
