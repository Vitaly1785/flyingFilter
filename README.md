
Решение:
Так как фильтры для перелетов редко применяются по одному, решил использовать паттерн Декоратор;)
Создаем фильтр используя интерфейс Filter и декорируем его с помощью FilterDecorator. 
При добавлении нового фильтра коллекция flights передается в его метод addFilter уже с исключенными правилами
предыдущего фильтра.
Таким образом мы можем добавлять в нашу систему новые фильтры, тем самым расширяя ее с помощью декоратора.
Для каждого фильтра использовал stream и его замечательный промежуточный метод filter().

Убрал бесполезную итерацию из фильтров. Реализовал доступ по индексу в stream.