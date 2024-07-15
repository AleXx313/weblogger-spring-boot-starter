# weblogger-spring-boot-starter
## Практическое задание по созданию собственного spring boot стартера.

### Описание проекта
#### Перехватчики
В рамках задания было создано 2 перехватчика http запросов.<br> Входящие запросы перехвачены с помощью HandlerInterceptor.<br>
Исходящие запросы перехвачены с помощью ClientHttpRequestInterceptor.<br>
Запросы обработаны путем добавления в них логирования содержащего обобщенную информацию о запросе, включающую в себя:
- Метода запроса
- URI
- Заголовки запроса
- Код ответа
- Заголовки ответа
- Время выполнения.

#### Автоконфигурация
Для превращения проекта в spring-boot-starter была настроена автоконфигурация с spring-boot-autoconfigure-processor.
Добавлена возможность изменять настройки проекта через файл настроек для выключения и выключения автоматического логирования http запросов.
Добавлено логирование при инициализации стартера, указывающее на то, что он подключен, а также проверка на валидность передаваемых конфигураций.

### Подключение

Для подключения weblogger-spring-boot-starter вам необходимо клонировать проект из git и выполнить таксу maven - mvn clean install, для сохранения стартера в локальном репозитории maven.

Настройки стартера могут быть изменены в файле настройки application.yaml
Для включения стартера необходимо в файл application.properties или application.yaml добавить настройки:
```
web.logger.enabled=true
```
По умолчанию значение - false <br>
Для включения логирования входящих запросов в файл application.properties или application.yaml добавить настройки:
```
web.logger.incoming-enabled=true
```
По умолчанию значение - true <br>
Для включения логирования исходящих запросов в файл application.properties или application.yaml добавить настройки:
```
web.logger.outgoing-enabled=true
```
По умолчанию значение - true <br>
### Используемые технологии
+ [Java](https://www.java.com/) (21)
+ [Spring Boot](https://spring.io/projects/spring-boot) (3)
+ [Apache Maven](https://maven.apache.org)
+ [Project Lombok](https://projectlombok.org)
