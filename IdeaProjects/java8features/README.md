сетап <br />
   
    - git clone git@gitlab.com:nikitenkobohdan/java8.git
    - cd java8
    - git remote remove origin
    - git remote add origin YOUR_REPO
    - git push origin master


запуск <br />
    - мейна **com.spduniversity.Application.main** <br />
    - linux: **./gradlew bootRun** <br />
    - win: **gradlew bootRun** <br />

урл
http://localhost:8080/

завдання (перше обовязково, решта по бажанню)
треба дописати реалізацію у всі 4 екшена <br />

    - Plain Java Simple
    - Plain Java Simple with counter
    - Stream
    - Parallel Stream

1) додати фільтрацію по Job Title <br />
2) сортування по одному з полів (Firstname, Lastname, Job Title, Age) <br />
3) замінити стаб статистики інформацією про частоту з якою з FirstName зявляється в відфільтрованій інформації (в відсотках)<br />
    так як варіантів багато треба виводити (PAGE_SIZE - 1) найуживаніших імен і додавати пункт Other в якому буде сума решти

