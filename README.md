# Prepare environment
- Reopen the project in vscode devcontainer to have already working dev environment, with all required tools
- Build Java application named app1
  ```
  mvn clean install -ntp
  ```
- Initialize DAPR engine
  ```bash
  dapr init
  ```
- Run app1 using DAPR, stop and run it again. Observe last lines in produced logs
  ```
  dapr run -f dapr.yaml
  ```

## Compare results
  Expected in logs (about 50-80% of runs):
  ```
  INFO 10625 --- [           main] com.example.DaprCallbacks                : init
  INFO 10625 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8080 (http) with context path ''
  INFO 10625 --- [           main] com.example.DemoApplication              : Started DemoApplication in ..... seconds (process running for .....)
  INFO 13662 --- [ault-executor-0] com.example.DaprCallbacks                : listTopicSubscriptions
  ```

  Actual in logs (about 20-50% of runs):
  ```
  INFO 10625 --- [           main] com.example.DaprCallbacks                : init
  INFO 10625 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8080 (http) with context path ''
  INFO 10625 --- [           main] com.example.DemoApplication              : Started DemoApplication in ..... seconds (process running for .....)
  ```

