    Steps for Web application with Spring Data JPA module:
        1. Dependency for spring-data-jpa & mysql
        2. mysql specific config
        3. Create an Entity
        4. Repository Interface 

    Create a Spring boot application for currency exchange
    POST & GET
    URL : /currency-exchange/from/USD/to/INR 
    ExchangeValue
        int id;
        Column("currency_from")
        String from;
        Column("currency_to")
        String to;
        BigDecimal currency_exchange_rate;

        1 USD = 71 INR
        I EUR = 96 INR
