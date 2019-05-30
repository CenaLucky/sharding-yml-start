package com.cs.yml.config;

import com.cs.yml.utils.IoUtil;
import io.shardingsphere.shardingjdbc.api.yaml.YamlShardingDataSourceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;
import sun.nio.ch.IOUtil;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

/**
 * @author:CaoShuai
 * @dateTime:5/29/2019 10:03 AM
 * @description:
 */
@Configuration
public class ShardingDataSourceConfig {
    @Autowired
    private Environment env;

    @Bean
    public DataSource dataSource() throws Exception {
        InputStream inputStream = new ClassPathResource("sharding-" + env.getActiveProfiles()[0] + ".yml").getInputStream();
        DataSource dataSource = YamlShardingDataSourceFactory.createDataSource(IoUtil.toBytes(inputStream));
        return dataSource;
    }
}
