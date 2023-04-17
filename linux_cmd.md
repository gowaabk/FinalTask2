
1. **Используя команду cat в терминале операционной системы Linux, создать
   два файла Домашние животные (заполнив файл собаками, кошками,
   хомяками) и Вьючные животными заполнив файл Лошадьми, верблюдами и
   ослы), а затем объединить их. Просмотреть содержимое созданного файла.
   Переименовать файл, дав ему новое имя (Друзья человека).**

   cat > Домашние_животные\
   Собака\
   Кошка\
   Хомяк

   cat > Вьючные_животные\
   Лошадь\
   Верблюд\
   Осел

   cat Вьючные_животные >> Домашние_животные

   cat Домашние_животные\
   Собака\
   Кошка\
   Хомяк\
   Лошадь\
   Верблюд\
   Осел

   mv Домашние_животные Друзья_человека

2. **Создать директорию, переместить файл туда.**
   
   mkdir dirTask\
   mv Друзья_человека dirTask\

3. **Подключить дополнительный репозиторий MySQL. Установить любой пакет
   из этого репозитория.**

   wget https://dev.mysql.com/get/mysql-apt-config_0.8.24-1_all.deb \
   dpkg -i mysql-apt-config_0.8.24-1_all.deb \
   sudo apt update \
   apt install mysql-server -y 
 
4. **Установить и удалить deb-пакет с помощью dpkg.**

   wget https://download.virtualbox.org/virtualbox/7.0.6/virtualbox-7.0_7.0.6-155176~Ubuntu~jammy_amd64.deb \
   dpkg -i virtualbox-7.0_7.0.6-155176~Ubuntu~jammy_amd64.deb\
   apt -f install \
   dpkg -r virtualbox-7.0 \
   apt autoremove

5. **Выложить историю команд в терминале ubuntu**

   754 cat > Домашние_животные\
   755 cat > Вьючные_животные\
   756 ls\
   757 cat Вьючные_животные >> Домашние_животные\
   758 cat Домашние_животные\
   759 mv Домашние_животные Друзья_человека\
   760 ls\
   761 cat Друзья_человека\
   762 mkdir dirTask\
   763 mv Друзья_человека dirTask2\
   764 ls\
   765 ls dirTask\
   766 wget https://dev.mysql.com/get/mysql-apt-config_0.8.24-1_all.deb\
   767 ls\
   768 dpkg -i mysql-apt-config_0.8.24-1_all.deb\
   769 sudo apt update\
   770 apt install mysql-server -y\
   771 ls\
   772 wget https://download.virtualbox.org/virtualbox/7.0.6/virtualbox-7.0_7.0.6-155176~Ubuntu~jammy_amd64.deb \
   773 dpkg -i virtualbox-7.0_7.0.6-155176~Ubuntu~jammy_amd64.deb\
   774 ls\
   775 dpkg -i virtualbox-7.0_7.0.6-155176~Ubuntu~jammy_amd64.deb\
   776 apt -f install\
   777 dpkg -r virtualbox-7.0\
   778 apt autoremove\
   779 history

