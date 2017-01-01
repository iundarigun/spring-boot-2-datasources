package br.com.s2it.blog.sample2datasources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @Autowired
    @Qualifier("primaryJdbcTemplate")
    private JdbcTemplate primaryJdbcTemplate;

    @Autowired
    @Qualifier("secundaryJdbcTemplate")
    private JdbcTemplate secundaryJdbcTemplate;

    @RequestMapping(path = "/test-db", method = RequestMethod.GET)
    public Integer testDB(){
        return contarPrimary() + contarSecundary();
    }

    private Integer contarPrimary(){
        return primaryJdbcTemplate.queryForObject("select sum(id) from teste", Integer.class);
    }

    private Integer contarSecundary(){
        return secundaryJdbcTemplate.queryForObject("select sum(id) from teste", Integer.class);
    }
}
