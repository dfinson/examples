package dev.sanda.javagraphqlspqrdemo.service;


import dev.sanda.javagraphqlspqrdemo.dao.AuthorRepository;
import dev.sanda.javagraphqlspqrdemo.model.Author;
import dev.sanda.javagraphqlspqrdemo.model.BlogPost;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;

@Service
@GraphQLApi // <-- note this
@Transactional
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @GraphQLMutation(name = "createAuthor")
    public Author createAuthor(@GraphQLArgument(name = "author") Author input){
        return authorRepository.save(input);
    }

    @GraphQLQuery(name = "authorById")
    public Author getAuthorById(@GraphQLArgument(name = "id") Long id){
        return authorRepository
                .findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Cannot find Author with id #" + id)
                );
    }
}
