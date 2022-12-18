Issue:
Can't change test profile using environmente variable *QUARKUS_TEST_PROFILE*, as described at https://quarkus.io/guides/continuous-testing#quarkus-test-dev-testing-test-config_quarkus.test.profile

Reproduction:

Actual:
```
Green test: *mvn clean test -Dquarkus.test.profile=my_profile*
Red test: *QUARKUS_TEST_PROFILE=my_profile mvn clean test*
```

Expected:
```
Green test: *mvn clean test -Dquarkus.test.profile=my_profile*
Green test: *QUARKUS_TEST_PROFILE=my_profile mvn clean test*
```
