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
    public EditorFacade provideEditorFacade() { return new EditorFacade();}

    @Bean
    public GenreFacade provideGenreFacade(){return new GenreFacade();}


}