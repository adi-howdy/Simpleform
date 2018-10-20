package com.formCheck.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formCheck.model.Author;
import com.formCheck.repository.AuthorRepository;

@Service("authorService")
public class AuthorService {

	@Autowired
	private AuthorRepository authorRepository;
	
	public Author saveAuthor(Author author){
		return authorRepository.save(author);
	}
		
}
