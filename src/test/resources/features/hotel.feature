Feature: Тест по поиску отеля

  Background:
    Given browser is started
    * search page is opened

  Scenario: Проверка страницы поиска
    Then search button is displayed

  Scenario: Поиск отеля Kimpton Vividora Hotel и проверка
    When find "Kimpton Vividora Hotel" and click button
    Then name "Kimpton Vividora Hotel" is displayed
    * score "9,2" is displayed