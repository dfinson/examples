package dev.sanda.javagraphqlspqrdemo.service;

import graphql.GraphQL;
import graphql.analysis.MaxQueryDepthInstrumentation;
import graphql.execution.batched.BatchedExecutionStrategy;
import graphql.schema.GraphQLSchema;
import io.leangen.graphql.GraphQLSchemaGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class GraphQLProviderSPQR {

    @Autowired
    public GraphQLProviderSPQR(AuthorService authorService, BlogPostService blogPostService){
        initGraphQLServices(authorService, blogPostService);
    }

    private GraphQL graphQL;

    @Bean
    public GraphQL graphQL(){
        return graphQL;
    }

    @PostConstruct
    private void initGraphQLServices(AuthorService authorService, BlogPostService blogPostService) {
        GraphQLSchemaGenerator schemaGenerator = new GraphQLSchemaGenerator()
                .withOperationsFromSingleton(authorService, AuthorService.class)
                .withOperationsFromSingleton(blogPostService, BlogPostService.class);
        GraphQLSchema schema = schemaGenerator.generate();
        graphQL = GraphQL.newGraphQL(schema).build();
    }
}
