
1. **Используя команду cat в терминале операционной системы Linux, создать
   два файла Домашние животные (заполнив файл собаками, кошками,
   хомяками) и Вьючные животными заполнив файл Лошадьми, верблюдами и
   ослы), а затем объединить их. Просмотреть содержимое созданного файла.
   Переименовать файл, дав ему новое имя (Друзья человека).**

   cat > Домашние_животные
   Собака
   Кошка
   Хомяк

   cat > Вьючные_животные
   Лошадь\
   Верблюд\
   Осел

   cat Вьючные_животные >> Домашние_животные

   cat Домашние_животные \
   Собака\
   Кошка\
   Хомяк\
   Лошадь\
   Верблюд\
   Осел

   >mv Домашние_животные Друзья_человека

2. **Создать директорию, переместить файл туда.**
   
   mkdir dirTask2\
   mv Друзья_человека dirTask2/

3. **Подключить дополнительный репозиторий MySQL. Установить любой пакет
   из этого репозитория.**

   wget https://dev.mysql.com/get/mysql-apt-config_0.8.24-1_all.deb \
   dpkg -i mysql-apt-config_0.8.24-1_all.deb\
   sudo apt update\
   apt install mysql-server -y

4. **Установить и удалить deb-пакет с помощью dpkg.**

   wget https://download.virtualbox.org/virtualbox/7.0.6/virtualbox-7.0_7.0.6-155176~Ubuntu~jammy_amd64.deb \
   dpkg -i virtualbox-7.0_7.0.6-155176~Ubuntu~jammy_amd64.deb \
   apt -f install \
   dpkg -r virtualbox-7.0 \
   apt autoremove \

5. **Выложить историю команд в терминале ubuntu**

   cat > Домашние_животные\
   cat > Вьючные_животные\
   ll\
   cat Вьючные_животные >> Домашние_животные\
   cat Домашние_животные\
   mv Домашние_животные Друзья_человека\
   ll\
   cat Друзья_человека\
   mkdir dirTask2\
   mv Друзья_человека dirTask2/\
   ll\
   ll dirTask2/\
   wget https://dev.mysql.com/get/mysql-apt-config_0.8.24-1_all.deb \
   ll\
   dpkg -i mysql-apt-config_0.8.24-1_all.deb\
   sudo apt update\
   apt install mysql-server -y\
   ll\
   wget https://download.virtualbox.org/virtualbox/7.0.6/virtualbox-7.0_7.0.6-155176~Ubuntu~jammy_amd64.deb \
   dpkg -i virtualbox-7.0_7.0.6-155176~Ubuntu~jammy_amd64.deb\
   ll\
   dpkg -i virtualbox-7.0_7.0.6-155176~Ubuntu~jammy_amd64.deb\
   apt -f install\
   dpkg -r virtualbox-7.0\
   apt autoremove\
   history

