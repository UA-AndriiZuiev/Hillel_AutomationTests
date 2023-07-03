Feature: Certificate check
  As a user,
  I want to open Home page -> Certificate check page and check
    some certifications number

  Scenario Outline: Open Checking page
    Given Open Home page
    Then  Verify opened Home page
    Given Go to Checking page
    Then Verify opened Checking page
    Given Check <CertificateNumber> of certification
    Then Check <Result> text
    Examples:
      | CertificateNumber | Result               |
      | FJ026912345       |Сертифікат не знайдено|
      | HR936789          |Сертифікат не знайдено|
      | AT7531            |Сертифікат не знайдено|