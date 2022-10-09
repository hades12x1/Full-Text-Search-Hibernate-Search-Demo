## Full-Text Search with Hibernate Search and Spring Boot ##


Description:

    - Data example: data.sql
    - Search example: TestService.java
    - Result: TestController.java, index-detail-es.png
        + Nested: Time normal: 167ms, Time ES: 11ms
        + Like: Time normal: 2574ms, Time ES: 131ms
        + Equal: Time normal: 99ms, Time ES: 10ms
        
    - Hibernate 6 beta version
    - Manual index: HibernateElasticsearchDemoApplication.java => cx.getBean(IndexingService.class).initiateIndexing();
    - Run Elasticseacrch(ARM): 
        docker run -d --name es -p 9200:9200 -p 9300:9300 -p 10000:8080  -e xpack.security.enabled=false -e discovery.type=single-node arm64v8/elasticsearch:7.17.1
    - Tool manager: Elasticvue(Extension Browser)
         + Disable Chorme or CORS ES: https://stackoverflow.com/questions/37384380/cross-origin-request-blocked-elasticsearch

Reference:

    - https://docs.jboss.org/hibernate/search/6.0/reference/en-US/pdf/hibernate_search_reference.pdf
    - https://reflectoring.io/hibernate-search/#indexedembedded-and-containedin

Author:

    - ChuyenNS(nchuyen128@gmail.com)
