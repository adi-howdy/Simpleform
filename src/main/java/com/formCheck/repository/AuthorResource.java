package com.formCheck.repository;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.formCheck.model.Author;
import com.formCheck.service.AuthorService;

@Controller
public class AuthorResource {
	
	
	@Autowired
	private AuthorRepository authorRepository;	
	
	private AuthorService authorService;
	
	@Autowired
	public AuthorResource(AuthorService authorService) {
		this.authorService = authorService;
	}
	
	/*
	@RequestMapping(value="/about", method = RequestMethod.GET)
	public String showAbout(ModelMap model, Author author){
		System.out.print("FUCK IT" + "/n");
		//Author author1 = new Author();
		//model.addAttribute("author", author1);
		return "about";
	}
	*/
	
	@RequestMapping("/about")
	public String About(){
		return "about";
	}
	
	@RequestMapping("/index")
	public String Index(){
		return "index";
	}
	/*
	@RequestMapping(value="/authors", method = RequestMethod.GET)
	public String showForm(ModelMap model, Author author){
		System.out.print("FUCK IT" + "/n");
		Author author1 = new Author();
		model.addAttribute("author", author1);
		return "authors";
	}
	*/
	
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public String showForm(ModelMap model, Author author){
		System.out.print("FUCK IT" + "/n");
		Author author1 = new Author();
		model.addAttribute("author", author1);
		return "register";
	}
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String index(){
		System.out.print("2");
		return "redirect:/index";
	}


	/*
	@RequestMapping(value = "/authors", method = RequestMethod.POST)
	public String processRegistration(Author author, BindingResult bindingResult, HttpServletRequest request)
	{
		if(bindingResult.hasErrors()) {
			System.out.println("has errors");
			return "authors";
		}
		authorService.saveAuthor(author);
		
		return "redirect:/authors";

	}
	*/
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String processRegistration(Author author, BindingResult bindingResult, HttpServletRequest request)
	{
		if(bindingResult.hasErrors()) {
			System.out.println("has errors");
			return "register";
		}
		authorService.saveAuthor(author);
		
		return "redirect:/register";

	}
	
	
}
