package com.example.aretrusaWeb1.facade;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FacadeBuilder {

    @Bean
    public AuthorFacade provideAuthorFacade(){
        return new AuthorFacade();
    }

    @Bean
    public CollectionFacade provideCollectionFacade(){
        return new CollectionFacade();
    }

    @Bean
    public CustomerFacade provideCustomerFacade(){
        return new CustomerFacade();
    }

    @Bean
    public AisleFacade provideAisleFacade(){
        return new AisleFacade();
    }

    @Bean
    public BookcaseFacade provideBookcaseFacade(){
        return new BookcaseFacade();
    }

    @Bean
    public EditorFacade provideEditorFacade(){
        return new EditorFacade();
    }

    @Bean
    public GenreFacade provideGenreFacade(){
        return new GenreFacade();
    }

    @Bean
    public UserFacade provideUserFacade(){
        return new UserFacade();
    }

    @Bean
    public BookFacade provideBookFacade() {  return new BookFacade(); }

    @Bean
    public BorrowFacade provideBorrowFacade() {  return new BorrowFacade(); }

}