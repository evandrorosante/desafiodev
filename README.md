# desafiodev
Tecnologias utilizadas:

NetBeans IDE 8.1
GlassFish Server 4.1.1
PostgreSQL 9.4
Google Cloud Platform - login conta da google
Java Web 7.0 - JSF - PrimeFaces

Configuração do GlassFish (criação do data source)

1- create-jdbc-connection-pool --datasourceclassname org.postgresql.ds.PGSimpleDataSource --restype javax.sql.DataSource --property user=postgres:password=root:DatabaseName=dashboard_task:ServerName=localhost:port=5432  post-gre-sql_dashboard_task_postgresPool

2- create-jdbc-resource
post-gre-sql_dashboard_task_postgresPool
jdbc/dashboard_task



