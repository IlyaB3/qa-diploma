# Дипломный проект профессии «Тестировщик ПО»

Дипломный проект представляет собой автоматизацию тестирования комплексного сервиса ***"Путешествие дня"*** для покупки туров, приложение взаимодействует с СУБД и API
Банка.
<img alt="Приложение" height="400" src="https://github.com/netology-code/qa-diploma/raw/master/pic/service.png" width="600"/>

## Запуск приложения и автотестов

Для запуска необходимы следующие инструменты:
- Git
- IntelliJ IDEA
- Docker Desktop
- Google Chrome

### Начало работы
1. Склонировать репозиторий на локальный компьютер командой ***git clone***
2. Запустить Docker
3. Загрузить контейнеры mysql, postgres и образ платежного шлюза nodejs в терминале IDEA командой

    ````
    docker-compose up
    ````
4. Во втором терминале запустить SUT командой

- для конфигурации с базой данный MySql:

 ````
 java "-Dspring.datasource.url=jdbc:mysql://localhost:3306/app" "-Dspring.datasource.username=app" "-Dspring.datasource.password=pass" -jar artifacts/aqa-shop.jar
 ````

- для конфигурации с базой данных PostgreSQL:

 ````
 java "-Dspring.datasource.url=jdbc:postgresql://localhost:5432/app" "-Dspring.datasource.username=app" "-Dspring.datasource.password=pass" -jar artifacts/aqa-shop.jar
 ````

### Запуск тестов
Запускаем автотесты командой в новом терминале в зависимости от СУБД:

- для MySQL:
    ````
  ./gradlew clean test "-Ddb.url=jdbc:mysql://localhost:3306/app"
    ````
- для PostgreSQL:
    ````
  ./gradlew clean test "-Ddb.url=jdbc:postgresql://localhost:5432/app"  
    ````
### Формирование отчетов тестирования

- В терминале ввести команду:
````
 ./gradlew allureServe
````
Отчёт автоматически откроется в браузере. После просмотра и закрытия отчёта необходимо остановить работу команды, нажав ***Ctrl+С*** и подтверждаем действие в терминале вводом ***Y***.

### Перезапуск приложенеия, контейнеров или автотестов.
- В терминале, где запущено приложение, ввести команду ***Ctrl+С***.
- Для прекращения работы контейнеров в терминале, где запущены базы данных, ввести команду ***Ctrl+С***, далее ввести ***docker-compose down***.


### Документация

- [План автоматизации тестирования](https://github.com/IlyaB3/qa-diploma/blob/main/documentation/Plan.md)

- [Отчётные документы по итогам автоматизированного тестирования](https://github.com/IlyaB3/qa-diploma/blob/main/documentation/Report.md)

- [Отчётные документы по итогам автоматизации](https://github.com/IlyaB3/qa-diploma/blob/main/documentation/Summary.md)
