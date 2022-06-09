# hackathon-IBA
Командная работа над проектом. Выполняла роль PM. Реализовала функции выгрузки данных в PDF и Excel.

# КОНСТРУКТОР ИНТЕРАКТИВНЫХ ТЕСТОВ, КВИЗОВ, ОПРОСОВ

Игра — лучший способ вовлечь участников во что угодно. Квизы (quiz) — интерактивные опросы, тесты, викторины. Суть менеджера квизов: пользователи отвечают на вопросы, оставляют контактные данные, чтобы получить результаты или какой-то бонус — скидку, полезные материалы, подборку товаров.


1. Разработанное приложение должно иметь возможности открывать, редактировать и сохранять текстовые документы. 
Наш функционал: вопросы + ответы пользователя + сведения о пользователе конвертируются в .txt, которые можно открыть, редактировать и сохранить.

2. Приложение должно иметь возможность как по выбору пользователя, так и рандомно выбирать (создавать) различные вопросы и соединять их вместе, создавая викторину по различным темам. 
Наш функционал: 
Викторина в начале опроса: пользователю (П) предлагается пройти викторину, чтобы получить бонус. На первом этапе П выбирает ту тему, в которой он силен (советские мультфильмы/современные мультфильмы/во всем). Далее по выбору пользователя рандомно подгружается 1  из 5 вопросов по советским мультикам/современным мультикам/или из обеих тем. 

3. Приложение должно сравнивать ответы с правильными вариантами и выдавать полученный результат.
Наш функционал: ответ пользователя в викторине сравниваются с правильными и 
если ответ верный, то выдается сообщение типа «Поздравляем! Вы получили бонус! Хотите его использовать? Пройдите небольшой опрос.» далее клиент кликает на кнопку Пройти опрос, переходит в опросник
Если ответ неверный – выдается сообщение типа «Не расстраивайтесь! Вы все еще можете получить бонус, пройдя небольшой опрос!» далее клиент кликает на кнопку Пройти опрос, переходит в опросник.

4. Создайте разные вопросы для разных целей. Реализуйте получение данных о клиенте и предоставление ему информацию о вас. Реализовано в опроснике

5. Также должна быть возможность создания архива (zip, rar) созданных файлов викторин. Пользователь добавляет файлы (возможно из различных директорий), а приложение архивирует их в архив. 
Наш функционал: пользователь в отзывах имеет возможность загрузить фото, которое архивируется приложением в архив

6. В приложении должна быть возможность генерации PDF файлов. 
Наш функционал: пользователь в отзывах имеет возможность добавить рукописный отзыв, который выгружается в виде PDF   ИЛИ генерация меню в виде PDF   по результатам опросника про питание ребенка

7. По желанию можно добавить, например, подсветку синтаксиса при создании квиза и другие фичи, которые считаете необходимым. Может быть у нас есть какие-то фичи, не указанные в требованиях?

8. Вы можете задавать вопросы пользователям не по стандартному сценарию, а в зависимости от их ответов. Пользователи не будут отвечать на лишние вопросы, а вы получите больше полезной информации.
Наш функционал: реализовано в опроснике, когда пользователь выбирает ветку с празднованием ДР или ветку с размещением ребенка в детском центре

9. Можно фиксировать процент отказов на каждом вопросе и статистику выбора вариантов ответов. Это поможет увидеть проблемные вопросы, на которых посетители бросают квиз.