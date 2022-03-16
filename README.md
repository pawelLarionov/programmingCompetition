# Programming competition game

Rest API for web application for a programming competition game

## Requirements

1. Java - 11

2. gradle - 7.4

## Steps to Setup

**1. Clone the application**

```bash
git clone https://github.com/pawelLarionov/programmingCompetition.git
```

**2. Build and run the app using gradle**

```bash
./gradlew bootRun
```

The app will start running at <http://localhost:8080>.

## Explore Rest APIs

The app defines following APIs.

##### List of all tasks

    GET http://localhost:8080/competition/task/list

##### Test to complete the task

    POST http://localhost:8080/competition/test/execute-and-check
    Content-type: application/json

    {
    "playerNickName": "Nik",
    "solutionCode": "import java.util.Scanner;\n\npublic class SolutionDoubleString {\n    public static void main(String[] args) {\n        Scanner scanner = new Scanner(System.in);\n        String inputParameter = scanner.nextLine();\n        String outputParameter = doubleString(inputParameter);\n        System.out.print(outputParameter);\n    }\n\n\n    private static String doubleString(String string) {\n        return string + \" \" + string;\n    }\n}",
    "taskGlobalId": "31fb0240-7d59-4601-8465-e59ca96109b2"
    }

##### List of the top players

    GET http://localhost:8080/competition/player/top-list/3

You can test them using postman or any other rest client.

    curl http://localhost:8080/competition/task/list
     
    curl -d "@SolutionDoubleStringNik.json" -H "Content-Type: application/json" -X POST http://localhost:8080/competition/test/execute-and-check
    curl -d "@SolutionDoubleStringOry.json" -H "Content-Type: application/json" -X POST http://localhost:8080/competition/test/execute-and-check
    curl -d "@SolutionDoubleStringTom.json" -H "Content-Type: application/json" -X POST http://localhost:8080/competition/test/execute-and-check
    curl -d "@SolutionReverseStringAnn.json" -H "Content-Type: application/json" -X POST http://localhost:8080/competition/test/execute-and-check
    curl -d "@SolutionReverseStringNik.json" -H "Content-Type: application/json" -X POST http://localhost:8080/competition/test/execute-and-check
    curl -d "@SolutionReverseStringTom.json" -H "Content-Type: application/json" -X POST http://localhost:8080/competition/test/execute-and-check

    curl http://localhost:8080/competition/player/top-list/3

## Testing

To launch application's tests, run:

    ./gradlew test

## H2 database console

    http://localhost:8080/h2-console

## JDoodle compiler api and documentation

    https://www.jdoodle.com/compiler-api/

    https://docs.jdoodle.com/compiler-api/compiler-api
