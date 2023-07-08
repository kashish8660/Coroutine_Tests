# Coroutine_Tests

1. We test 3 cases :
    1. delay()
    2. Main Thread
    3. IO Thread
2. Code of Best Practice, which says we need to inject a Dispatcher in the class and not mention it explicitly(Main/IO)
3. Created a Custom Rule, which is a part of jUnit Testing.
4. Saw a scenario where value of a variable is changed within a coroutine
