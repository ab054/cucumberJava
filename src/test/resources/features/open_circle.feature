@JoinCircle
Feature: Open circle functionality

  @JoinCircle1
  Scenario Outline: Join circle with existed email
    Given open Join Circle page
    Then wait for 1 sec
    Then type <My Test Circle> in <Circle name field>
    Then type <Passcode> in <Passcode field>
    Then type <My First name> in <First name field>
    Then type <My Last name> in <Last name field>
    Then type <My email> in <Email field>
    Then type <My password> in <Password field>
    And click to <Join button>
    Then wait for 2 sec
    Then verify that <Error message> appears
    Examples:
      | My Test Circle | Circle name field | Passcode | Passcode field | My First name | First name field | My Last name | Last name field | My email       | Email field | My password     | Password field | Join button            | Error message |
      | "May2023"      | "id=circleId"     | "2jPSc3" | "id=passCode"  | "S"           | "id=firstName"   | "K"          | "id=lastName"   | "ab@gmail.com" | "id=email"  | "Test123456789" | "id=password"  | "css=.ant-btn-primary" | "email_exist" |
      | "May2023"      | "id=circleId"     | "2jPSc3" | "id=passCode"  | "S"           | "id=firstName"   | "K"          | "id=lastName"   | "random_non_exist_email" | "id=email"  | "Te123" | "id=password"  | "css=.ant-btn-primary" | "too_short_pw" |
      | "May2024"      | "id=circleId"     | "2jPSc3" | "id=passCode"  | "S"           | "id=firstName"   | "K"          | "id=lastName"   | "random_non_exist_email" | "id=email"  | "Test123456789" | "id=password"  | "css=.ant-btn-primary" | "invalid_circle_name" |
      | "May2023"      | "id=circleId"     | "2jPSc4" | "id=passCode"  | "S"           | "id=firstName"   | "K"          | "id=lastName"   | "random_non_exist_email" | "id=email"  | "Test123456789" | "id=password"  | "css=.ant-btn-primary" | "invalid_passcode" |
      | "May2023"      | "id=circleId"     | "2jPSc3" | "id=passCode"  | ""           | "id=firstName"   | "K"          | "id=lastName"   | "random_non_exist_email" | "id=email"  | "Test123456789" | "id=password"  | "css=.ant-btn-primary" | "empty_fname_field" |
      | "May2023"      | "id=circleId"     | "2jPSc3" | "id=passCode"  | "S"           | "id=firstName"   | ""          | "id=lastName"   | "random_non_exist_email" | "id=email"  | "Test123456789" | "id=password"  | "css=.ant-btn-primary" | "empty_lname_field" |
