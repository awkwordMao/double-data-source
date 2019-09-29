package shiyue.jery.doubledatasourse.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * @author Jery
 * @date 2019/9/25
 */
@Configuration
@MapperScan(basePackages = "shiyue.jery.doubledatasourse.db1.dao", sqlSessionTemplateRef = "db1SqlSessionTemplate")
public class DataSource1Config {

    @Autowired
    MybatisProperties mybatisProperties;

    /**
     * 生成数据源。@Primary注解声明为默认数据源
     * @author Jery
     * @params []
     * @return
     **/
    @Primary
    @Bean(name = "db1DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.hikari.db1")
    public DataSource testDataSource(){
        return DataSourceBuilder.create().build();
    }

    /**
     * 创建 SqlSessionFactory
     * @author Jery
     * @params [dataSource]
     * @return
     **/
    @Bean(name = "db1SqlSessionFactory")
    @Primary
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("db1DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        //TODO 如果使用xxx.xml写sql的话，要设置路径
        //  bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/db1/*.xml"));
        sessionFactoryBean.setConfiguration(mybatisProperties.getConfiguration());
        return sessionFactoryBean.getObject();
    }

    /**
     * 配置事务管理
     * @author Jery
     * @params [dataSource]
     * @return
     **/
    @Primary
    @Bean(name = "db1TransactionManager")
    public DataSourceTransactionManager testTransactionManager(@Qualifier("db1DataSource") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "db1SqlSessionTemplate")
    @Primary
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("db1SqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
