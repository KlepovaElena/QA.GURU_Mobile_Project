# Проект по автоматизации приложения Wikipedia
## Содержание:

- [Использованный стек технологий](#computer-использованный-стек-технологий)
- [Запуск автотестов](#arrow_forward-запуск-автотестов)
- [Сборка в Jenkins](#jenkins)
- [Пример Allure-отчета](#allure)
- <a href="#movie">Видеопример прохождения тестов Browserstack</a>

## :computer: Использованный стек технологий

<p align="center">
<img width="6%" title="IntelliJ IDEA" src="media/logo/Idea.svg">
<img width="6%" title="Java" src="media/logo/Java.svg">
<img width="6%" title="Selenide" src="media/logo/Selenide.svg">
<img width="6%" title="Selenoid" src="media/logo/Selenoid.svg">
<img width="6%" title="Allure Report" src="media/logo/Allure.svg">
<img width="6%" title="Gradle" src="media/logo/Gradle.svg">
<img width="6%" title="JUnit5" src="media/logo/JUnit5.svg">
<img width="6%" title="GitHub" src="media/logo/GitHub.svg">
<img width="6%" title="Jenkins" src="media/logo/Jenkins.svg">
<img width="6%" title="Appium" src="media/logo/Appium.svg">
<img width="6%" title="Browserstack" src="media/logo/Browserstack.svg">
</p>

## :arrow_forward: Запуск автотестов

### Запуск тестов на локальном эмуляторе
```
gradle clean emulation_test -DdeviceHost=emulation
```
### Запуск тестов на удаленном устройстве через Browserstack
```
gradle clean ios_test -DdeviceHost=ios
gradle clean android_test -DdeviceHost=android
```
При выполнении команды, тесты запустятся удаленно в <code>Browserstack</code>.

## <img name="jenkins" src="media/logo/Jenkins.svg" title="Jenkins" width="4%"/> <a href="https://jenkins.autotests.cloud/job/QA.GURU_MobileProject" target="blank">Сборка в Jenkins</a>

<p align="center">
<img title="Jenkins Build" src="media/screens/Mobile_jenkins.png">
</p>

### Параметры сборки

* <code>PLATFORM</code> – мобильная платформа, на которой выполняются тесты. По-умолчанию - <code>android</code>.

## <img name="allure" src="media/logo/Mobile_AllureReport.jpg" title="Allure Report" width="4%"/> <a href="https://jenkins.autotests.cloud/job/QA.GURU_MobileProject/2/allure/" target="_blank">Пример Allure-отчета</a>

Содержание Allure-отчета:
* Шаги теста;
* Page Source;
* Видео выполнения автотеста.

### Overview

<p align="center">
<img title="Allure Overview" src="media/Reports/Mobile_AllureTC.png">
</p>

### Результат выполнения теста

<p align="center">
<img title="Test Results in Alure" src="attach/Reports/ResultTest.png">
</p>

<a id="movie"></a>
## <img alt="Browserstack" height="25" src="attach/Logo/Browserstack.svg" width="25"/></a> Видеопример выполнения теста Browserstack

<p align="center">
<img title="Browserstack Video" src="attach/Reports/ErrorMovie.gif" width="350" height="350"  alt="video">   
</p>