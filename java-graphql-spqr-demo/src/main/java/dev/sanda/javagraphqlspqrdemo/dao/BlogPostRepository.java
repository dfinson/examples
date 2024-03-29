package dev.sanda.javagraphqlspqrdemo.dao;


import dev.sanda.javagraphqlspqrdemo.model.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {
}
