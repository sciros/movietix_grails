dataSource {
    pooled = true
    jmxExport = true
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
//    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory' // Hibernate 3
    cache.region.factory_class = 'org.hibernate.cache.ehcache.EhCacheRegionFactory' // Hibernate 4
    singleSession = true // configure OSIV singleSession mode
    flush.mode = 'manual' // OSIV session flush mode outside of transactional context
}

// environment specific settings
environments {
    development {
        dataSource {
            dbCreate = "create-drop" // one of 'create', 'create-drop', 'update', 'validate', ''
            driverClassName = "org.h2.Driver"
            url = "jdbc:h2:mem:devDb;MVCC=TRUE;LOCK_TIMEOUT=10000;"
            username = "sa"
            password = ""
        }
    }
    test {
        dataSource {
            dbCreate = "create-drop"
            driverClassName = "com.mysql.jdbc.Driver"
            dialect = "org.hibernate.dialect.MySQL5InnoDBDialect"
            url = "jdbc:mysql://localhost/movietix?useUnicode=yes&characterEncoding=UTF-8"
            username = "developer"
            password = "P4ssw0rd"
        }
    }
    production {
        dataSource {
            dbCreate = "create-drop"
            url = "jdbc:h2:mem:prodDb;MVCC=TRUE;LOCK_TIMEOUT=10000;"
        }
    }
}
