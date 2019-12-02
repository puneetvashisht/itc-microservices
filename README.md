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

        -Direct inovation of currency exchange service
        http://localhost:8000/currency-exchange/from/USD/to/INR
        - Invocation of CES through Zuul API Gateway
        http://localhost:8765/its-currency-exchange-service/currency-exchange/from/USD/to/INR

        - Invocation of CCS through Zuul API Gateway
         http://localhost:8765/its-currency-conversion-service/currency-converter-feign/from/USD/to/INR/quantity/125

         Steps:
            1. Zipkin jar files -- dependencies
            2. Zipkin Setup
                a) https://zipkin.io/pages/quickstart.html to download and start using java -jar zipkin.jar
                b) Download and start rabbitmq: https://www.rabbitmq.com/download.html
                c) Run in conjunction: 
                RABBIT_URI=amqp://localhost java -jar zipkin.jar

        Security with Microservices:
            1. Security Check in Zuul API Gateway: Gateway can be plugged in/out before any microservice.
            2. Authentication Server: Currency Conversion service also acts as Authentication Server - generates the JWT.
            