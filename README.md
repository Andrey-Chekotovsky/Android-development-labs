# Android-development-labs
You know what? FUCK THIS WAR! I just want you dead

В общей сложности тут 3 модуля(6-я лаба предполагает, что проект разбивается на модули)
DbLAyer Содершит работу с бд(4-я лаба, где надо работать с Room)
https://www.youtube.com/playlist?list=PLSrm9z4zp4mEPOfZNV9O-crOhoMa0G2-o
Это хороший плэйлист где норм рассписывается работа с Room.
Работа с Room предполагает что делается Dao(класс работающий с бд), Repository который делает то же самое так что я хз зачем он нужен
и класс ViewModel, который у меня находится в ServiceLayer. Он фактически берет и удерживает данные из базы данных, которые используются
в самих экранах.
Для первых двух лаб все расположенно в модуле app. В папке res из важного папка layout, где хранятся все xml для экранов и папка navigation
https://www.youtube.com/playlist?list=PLSrm9z4zp4mHilvsfUM3jeCYFV3fTAS3J
Это довольно норм плэйлист по навигации. Едиственное что там не говорят как заставить это работать. В layout есть main_activity. Его можно 
можно копировать надо только будет поменять название для файла навигации и вашего класса, который наследуется от FragmentActivity
Так же отдельный момент что вся эта шляпа генерит часть кода за вас и в гайдах нихера не сказанно как его заставить это делать
Краткий гайд на этот счет:
Это:
buildscript {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven (url = uri("https://nexus.bedatadriven.com/content/groups/public") )
    }
    dependencies {
        val nav_version = "2.7.5"
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version")
    }
}
Добавляем в глобальный graddle.build проекта, а внутри модулей в местный graddle.build внутрь plugins(они в самом верху) добавляем
id("androidx.navigation.safeargs")
Это основное
