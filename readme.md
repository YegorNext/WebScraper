# Spring Application 

<big>Dubina Yehor, 122-20-4</big>

## Project Structure

**controllers/** 
    
    ListController.java - Запити Excel
    ProductController.java - Запити до товарів 

**entity/** 

    Product.java - Опис таблиці товарів

**repository/** 

    IProductRepository.java - Репозиторий товарів    
    
**services/** 

    ExcelService.java - Обробка Excel запитів
    WebParserService.java - Парсер сайту 

**model/**

    UrlRequest.java - модель запиту


**resources/** 

    application.properties - містить конфігурацію БД

## Description

Проект використовує збірник **Maven**. Сервер написаний з використанням фреймворку Spring. 

Додаток містить ендпоінти, що виконують парсинг сайту **https://epicentrk.ua/** з використанням бібліотеки **Jsoup**.

Окрім цього, додаток має наступний функціонал, що виконаний за архітектурним стилем REST:

* Створення ресурсу
* Видалення ресурсу 
* Отримання ресурсу

Додаток має можливість працювати з **експортом Excel файлів**, що містять данні отримані з **бази даних**.

Додаток массово імпортує данні за вказаним лінком у запиті з відповідних розділів товарів вище зазначенкого сайту, наприклад:

* **https://epicentrk.ua/ua/shop/vesy-napolnye/** 
* **https://epicentrk.ua/ua/shop/setka-svarnaya/** 