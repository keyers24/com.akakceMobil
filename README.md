# Akakce Mobile Automation
## Project Overview
- **Pre Condition **: It works with driver activity. you need to install and run the relevant apk on the phone.
  note : Automatic installation of the apk with getAbsolutePath method has been tried and there is no stable apk on the web.
- **Page Object Model (POM)**: The framework is built using the Page Object Model pattern for better reusability and maintainability.
- **Technologies Used**:
  - Java 18.0.2
  - Selenium 4.27
  - Appium 9.2
- **Framework Highlights**:
  - Mobil automation using AppiumDriver.
  - Integration of dynamic waits and reusable components.
  - Use of TestNG  test execution and reporting
  - Use of cucumber report
  - Log to Log4j2
  - Scenario planning with Cucumber - Gherkin
    
- **Test Scenario**:
   Scenario: Laptop
   - Given Akakce application opens
   - When  Continue without signing up
   - And   Search for laptop in the search bar
   - And   See Products filter is applied
   - And   Category selection is made
   - And   The product with the highest price is selected
   - Then  Go to seller button is verified
    


   
<img width="949" alt="Mobil_Result" src="https://github.com/user-attachments/assets/57107870-c112-414d-a186-1514038f1b48" />


