package com.bpg.palindrome.service;

import com.bpg.palindrome.entity.Palindrome;

import java.math.BigDecimal;
import java.util.List;

public interface PalindromeService {
    List<Palindrome> getAll();

    Palindrome getById(Long Id);

    Palindrome save(Palindrome Palindrome);

    void delete(Long Id);

}

