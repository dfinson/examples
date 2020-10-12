package dev.sanda.javagraphqlspqrdemo.service;


import dev.sanda.javagraphqlspqrdemo.dao.AuthorRepository;
import dev.sanda.javagraphqlspqrdemo.dao.BlogPostRepository;
import dev.sanda.javagraphqlspqrdemo.model.Author;
import dev.sanda.javagraphqlspqrdemo.model.BlogPost;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@GraphQLApi// <-- note this
@Transactional
public class BlogPostService {

    @Autowired
    private BlogPostRepository blogPostRepository;
    @Autowired
    private AuthorRepository authorRepository;

    @GraphQLMutation(name = "createBlogPost")
    public BlogPost createBlogPost(@GraphQLArgument(name = "authorId") Long authorId,
                                   @GraphQLArgument(name = "input") BlogPost input){
        Author author = authorRepository
                .findById(authorId)
                .orElseThrow(() ->
                        new RuntimeException("Cannot find Author with id #" + authorId)
                );
        BlogPost savedInstance = blogPostRepository.save(input);
        savedInstance.setAuthor(author);
        author.getBlogPosts().add(input);
        return savedInstance;
    }
}
