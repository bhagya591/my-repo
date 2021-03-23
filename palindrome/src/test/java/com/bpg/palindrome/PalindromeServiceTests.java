package com.bpg.palindrome;

import com.bpg.palindrome.entity.Palindrome;
import com.bpg.palindrome.service.PalindromeService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PalindromeServiceTests {

	@Autowired
	PalindromeService ps;



	@Test
	public void singleLetter() {
		Palindrome p = ps.save(new Palindrome("a"));
		Assert.assertEquals("Output must match the expected","a", p.getPalindrome());
	}

	@Test
	public void doubleLetter() {
		Palindrome p = ps.save(new Palindrome("aa"));
		Assert.assertEquals("Output must match the expected","aa", p.getPalindrome());
	}

	@Test
	public void threeLetter() {
		Palindrome p = ps.save(new Palindrome("aba"));
		Assert.assertEquals("Output must match the expected","aba", p.getPalindrome());
	}



	@Test
	public void noPalindrome() {
		Palindrome p = ps.save(new Palindrome("palindrome"));
		Assert.assertEquals("Output must match the expected","p", p.getPalindrome());
	}

	@Test
	public void evenPalindrome() {
		Palindrome p = ps.save(new Palindrome("springframeemarworok"));
		Assert.assertEquals("Output must match the expected","rameemar", p.getPalindrome());
	}
	@Test
	public void oddPalindrome() {
		Palindrome p = ps.save(new Palindrome("springframemarworok"));
		Assert.assertEquals("Output must match the expected","ramemar", p.getPalindrome());
	}


	@Test
	public void nullTest() {
		Palindrome p = ps.save(new Palindrome(null));
		Assert.assertNull("Output must match the null", p);
	}

}
