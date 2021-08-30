# catalogs

#Масштабируемое SpringBoot приложение для работы с каталогами

#Использован flyway для написания скриптов добавления и обновления каталогов

#Приложение способно принимать запрос в txt файле с внутренним содержанием формата "Операция ТАБЛИЦА: Json"

#С помошью TableExecutorContainer можно получить по названию Executor для нужной таблицы (внутри реализован словарь)

#При добавлении нового каталога нужно написать скрипт для flyway, и создать новую сущность и  Executor для контейнера

#Тесты прописаны для примера только под один каталог и сопутствующие сервисы (остальные по аналогии)
