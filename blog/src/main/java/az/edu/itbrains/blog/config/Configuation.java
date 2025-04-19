package az.edu.itbrains.blog.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configuation {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
