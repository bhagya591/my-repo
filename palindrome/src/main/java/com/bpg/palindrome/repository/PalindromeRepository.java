package com.bpg.palindrome.repository;

import com.bpg.palindrome.entity.Palindrome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PalindromeRepository extends JpaRepository<Palindrome, Long> {

}
