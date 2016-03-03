# SOAP-Webservices with Apache CXF & MuleESB using JAX-WS RI & JAXB
[![Build Status](https://travis-ci.org/jonashackt/soap-mule-cxf.svg?branch=master)](https://travis-ci.org/jonashackt/soap-mule-cxf)
[![Coverage Status](https://coveralls.io/repos/jonashackt/soap-mule-cxf/badge.svg)](https://coveralls.io/r/jonashackt/soap-mule-cxf)
[![Dependency Status](https://www.versioneye.com/user/projects/56d7e97fd71695003886c467/badge.svg?style=flat)](https://www.versioneye.com/user/projects/56d7e97fd71695003886c467)

Fully running example of [https://github.com/jonashackt/soap-spring-boot-cxf](https://github.com/jonashackt/soap-spring-boot-cxf). But instead of [Spring Boot] the project is based on [MuleESB].
Works only, if you boot the Weather-Backend, which exposes a REST-Service that the Mule-Flow needs to run: [https://github.com/jonashackt/weatherbackend](https://github.com/jonashackt/weatherbackend). Just clone and mvn spring-boot:run :)

[MuleESB]:https://www.mulesoft.com/resources/esb/what-mule-esb
[Spring Boot]:http://projects.spring.io/spring-boot/