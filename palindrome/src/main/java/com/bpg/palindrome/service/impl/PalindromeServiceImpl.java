package com.bpg.palindrome.service.impl;

import com.bpg.palindrome.entity.Palindrome;
import com.bpg.palindrome.repository.PalindromeRepository;
import com.bpg.palindrome.service.PalindromeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * @author
 */
@Service
@Transactional
public class PalindromeServiceImpl implements PalindromeService {

    @Autowired
    private PalindromeRepository palindromeRepository;

    public void setRepository(PalindromeRepository palindromeRepository) {
        this.palindromeRepository = palindromeRepository;
    }

    public List<Palindrome> getAll() {
        List<Palindrome> palindromes = palindromeRepository.findAll();
        return palindromes;
    }

    public Palindrome getById(Long id) {
        Optional<Palindrome> optEmp = palindromeRepository.findById(id);
        return optEmp.get();
    }

    public Palindrome save(Palindrome palindrome) {
        if(palindrome==null || palindrome.getInput()==null)
            return null;
        palindrome.setPalindrome(longestPalindromicSubstring(palindrome.getInput()));
        return palindromeRepository.save(palindrome);
    }

    public void delete(Long id) {
        palindromeRepository.deleteById(id);
    }


    static String longestPalindromicSubstring(String _s_) {
        String result = "";
        for (int i = 0; i < _s_.length() ; i++) {
            String po = getPalindromeOdd(i, _s_);
            String pe = getPalindromeEven(i, _s_);
            if (po.length() > result.length())
                result = po;
            if (pe.length() > result.length())
                result = pe;
        }
        return result;
    }


    static String getPalindromeOdd(int i, String arr) {
        int l = i;
        int r = i;
        for (; l >= 0 && r < arr.length() && arr.charAt(l) == arr.charAt(r); l--, r++) {
        }
        return arr.substring(l + 1, r);
    }


    static String getPalindromeEven(int i, String arr) {
        int l = i;
        int r = i + 1;
        for (; l >= 0 && r < arr.length() && arr.charAt(l) == arr.charAt(r); l--, r++) {
        }
        return arr.substring(l + 1, r);
    }


}
